package telran.java48.forum.model;

import java.time.LocalDateTime;

import lombok.Setter;

public class Comment {
	
	@Setter
	String user;
	@Setter
    String message;
    LocalDateTime dataCreated;
    Integer likes;
    
    public Comment() {
		dataCreated = LocalDateTime.now();
		likes = 0;
	}
    
	public Comment(String user, String message, LocalDateTime dataCreated, Integer likes) {
		super();
		this.user = user;
		this.message = message;
	}
	
	public void addLike() {
		likes++;
	}
    
    

}
