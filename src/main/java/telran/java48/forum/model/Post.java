package telran.java48.forum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode(of = "id")
public class Post {
	
	String id;
	@Setter
	String title;
	@Setter
	String content;
	@Setter
	String author;
	LocalDateTime dataCreated;
	List<String> tags;
	Integer likes;
	List<Comment> comments;
	
	public Post() {
		dataCreated = LocalDateTime.now();
		comments = new ArrayList<>();
	}
	
	public Post(String id, String title, String content, String author, LocalDateTime dataCreated, List<String> tags,
			Integer likes, List<String> comments) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.tags = tags;
		this.likes = likes;
		
	}
	
	public boolean addTag(String tag) {
		return tags.add(tag);
	}
	
	public boolean removeTag(String tag) {
		return tags.remove(tag);
	}
	
	public void addLike() {
		likes++;
	}
	
	public boolean addComment(Comment comment) {
		return comments.add(comment);
	}
	
	public boolean removeComment(Comment comment) {
		return comments.remove(comment);
	}

	
	
	

}
