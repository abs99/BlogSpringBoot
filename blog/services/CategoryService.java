package blog.services;


import blog.payloads.CategoryDto;


public interface CategoryService {
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(Integer catefgoryId, CategoryDto categoryDto);
	
	public CategoryDto getCategory(Integer categoryId);
	
	public void deleteCategory(Integer categoryId);

}
