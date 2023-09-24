package telran.java48.forum.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import telran.java48.forum.model.Post;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PostDto {
	String id;
	String title;
	String content;
	String author;
	LocalDate dataCreated;
	@Singular
	List<String> tags;
	Integer likes;
	@Singular
	List<String> comments;
	
}
