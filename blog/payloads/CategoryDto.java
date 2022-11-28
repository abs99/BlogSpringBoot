package blog.payloads;

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
