package telran.java48.forum.dao;

import java.util.List;

import telran.java48.forum.dto.PeriodDto;
import telran.java48.forum.dto.PostCreateDto;
import telran.java48.forum.dto.PostDto;
import telran.java48.forum.model.Post;

public interface ForumRepository {
	
	Post deleteById(String id);
	
	List<Post> findAll();

	PostDto removePost(String id);

	PostDto findPostById(String id);

	void addLike(String id);

	Iterable<PostDto> findPostsByTags(List<String> tags);

	Iterable<PostDto> findPostsByPeriod(PeriodDto periodDto);

	Iterable<PostDto> findPostByAuthor(String author);

	PostDto addNewPost(String author, PostCreateDto postCreateDto);

	PostDto updatePost(String id, PostCreateDto postCreateDto);
	

}
