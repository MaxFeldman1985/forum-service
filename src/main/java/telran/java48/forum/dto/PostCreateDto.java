package telran.java48.forum.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class PostCreateDto {
	String title;
	String content;
	List<String> tags;
	
}
