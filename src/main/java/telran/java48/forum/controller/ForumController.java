package telran.java48.forum.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.java48.forum.dto.CommentDto;
import telran.java48.forum.dto.PeriodDto;
import telran.java48.forum.dto.PostCreateDto;
import telran.java48.forum.dto.PostDto;
import telran.java48.forum.service.ForumService;

@RestController
public class ForumController {
	ForumService forumService;

	@PostMapping("/post/{author}")
	public PostDto addPost(@PathVariable String author,@RequestBody PostCreateDto postCreateDto) {
		return forumService.addPost(postCreateDto);
	}

	@GetMapping("/post/{{postId}}")
	public PostDto findPost(@PathVariable("postId") Integer id) {
		return forumService.findPost(id);
	}

	@GetMapping("/post/{{postId}}")
	public PostDto updatePost(@PathVariable String id,@RequestBody PostCreateDto postCreateDto) {
		return forumService.updatePost(id, postCreateDto);
	}

	@PutMapping("/post/{{postId}}/like")
	public void addLike(@PathVariable String id) {
		forumService.addLike(id);
	}

	@GetMapping("/posts/author/{{user}}")
	public List<PostDto> findPostByAuthor(@PathVariable("user") String author) {
		return forumService.findPostByAuthor(author);
	}

	@PostMapping("/post/{postId}/comment")
	public Map<PostDto, CommentDto> addComment(@PathVariable String postId,@PathVariable String author,
			@RequestBody CommentDto commentDto) {
		return forumService.addComment(postId,author, commentDto);
	}

	@DeleteMapping("/post/{{postId}}")
	public PostDto deletePost(@PathVariable Integer postId) {
		return forumService.deletePost(postId);
	}

	@GetMapping("/posts/tags")
	public PostDto findPostByTags(@RequestParam List<String> tags) {
		return forumService.findPostByTags(tags);
	}

	@GetMapping("/posts/period")
	public List<PostDto> findPostByPeriod(@RequestBody PeriodDto periodDto) {
		return forumService.findPostByPeriod(periodDto);
	}

	@PutMapping("/post/{postId}")
	public PostDto updateDto(@PathVariable String postId,@RequestBody PostCreateDto postCreateDto) {
		return forumService.updateDto(postId, postCreateDto);
	}

}
