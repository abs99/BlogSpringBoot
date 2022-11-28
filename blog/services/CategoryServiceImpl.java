package blog.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.entities.Category;
import blog.exceptions.ResourceNotFoundException;
import blog.payloads.CategoryDto;
import blog.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepository catRepo;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
		Category cat = modelMapper.map(categoryDto,Category.class);
		Category category = catRepo.save(cat);
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(Integer categoryId, CategoryDto categoryDto) {
		
		Category category = catRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", String.valueOf(categoryId)));
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		catRepo.save(category);
		
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category =  catRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "id", String.valueOf(categoryId)));
		
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		catRepo.deleteById(categoryId);
		return;

	}

}
