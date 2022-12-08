package blog.payloads;

import java.util.Date;

import blog.entities.Category;
import blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {
	
	private Integer id;
	
	private String content;
		
	private String title;
	
	private String image; 
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
}
