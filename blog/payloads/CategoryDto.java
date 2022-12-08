package blog.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	public Integer categoryId;
	
	public  String categoryTitle;
	
	public String categoryDescription;
	

}
