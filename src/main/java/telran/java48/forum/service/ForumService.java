package telran.java48.forum.service;

import java.util.List;
import java.util.Map;

import telran.java48.forum.dto.CommentDto;
import telran.java48.forum.dto.PeriodDto;
import telran.java48.forum.dto.PostCreateDto;
import telran.java48.forum.dto.PostDto;

public interface ForumService {
	PostDto addPost(PostCreateDto postCreateDto);
	
	PostDto findPost(Integer id);
	
	PostDto updatePost(String id, PostCreateDto postCreateDto);
	
	Integer addLike(String id);
	
	List<PostDto> findPostByAuthor(String author);
	
	Map<PostDto, CommentDto> addComment(String postId, String message, CommentDto commentDto);
	
	PostDto deletePost(Integer id);
	
	PostDto findPostByTags(List<String> tags);
	
	List<PostDto> findPostByPeriod(PeriodDto periodDto);
	
	PostDto updateDto(String postId, PostCreateDto postCreateDto);

}
