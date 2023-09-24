package telran.java48.forum.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.xml.stream.events.Comment;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import telran.java48.forum.dto.PeriodDto;
import telran.java48.forum.dto.PostCreateDto;
import telran.java48.forum.dto.PostDto;
import telran.java48.forum.model.Post;

@Service
@RequiredArgsConstructor
public class ForumRepositoryImpl implements ForumRepository {

	final ForumRepository forumRepository;
	final ModelMapper modelMapper;

	@Override
	public PostDto addNewPost(String author, PostCreateDto postCreateDto) {
		Post post = modelMapper.map(postCreateDto, Post.class);
		post.setAuthor(author);
		post = forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto findPostById(String id) {
		Post post = forumRepository.findPostById(id);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto removePost(String id) {
		Post post = forumRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
		forumRepository.deleteById(id);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto updatePost(String id, PostCreateDto postCreateDto) {
		Post post = forumRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
		String content = postCreateDto.getContent();
		if (content != null) {
			post.setContent(content);
		}
		String title = postCreateDto.getTitle();
		if (title != null) {
			post.setTitle(title);
		}
		List<String> tags = postCreateDto.getTags();
		if (tags != null) {
			tags.forEach(post::addTag);
		}
		forumRepository.save(post);
		return modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto addComment(String id, String author, NewCommentDto newCommentDto) {
		Post post = forumRepository.findPostById(id).orElseThrow(() -> new 	PostNotFoundException());
		Comment comment = new Comment(author, newCommentDto.getMessage());
		post.addComment(newCommentDto);
		forumRepository.save(post);
		return modelMapper.map(post,  PostDto.class);  
	}

	@Override
	public void addLike(String id) {
		Post post = forumRepository.findPostById(id).orElseThrow(() -> new PostNotFoundException());
		post.addLike();
		forumRepository.save(post);

	}

	@Override
	public Iterable<PostDto> findPostByAuthor(String author) {
		return forumRepository.findByAuthorIgnoreCase(author)
				.map(p -> modelMapper.map(p, PostDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public Iterable<PostDto> findPostsByTags(List<String> tags) {
		return null;
	}

	@Override
	public Iterable<PostDto> findPostsByPeriod(PeriodDto periodDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
