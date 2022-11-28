package blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.payloads.ApiResponse;
import blog.payloads.CategoryDto;
import blog.services.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	CategoryService catService;
  
	 @GetMapping("/{categoryId}")
	 public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		 
		 CategoryDto categoryDto = catService.getCategory(categoryId);
		 return new ResponseEntity<>(categoryDto,HttpStatus.OK);
	 }
	 

		@PostMapping("/")
		public ResponseEntity<CategoryDto> creatCategory(@RequestBody CategoryDto categoryDto) {
			
			CategoryDto newcategoryDto = catService.createCategory(categoryDto);
			
			return new ResponseEntity<>(newcategoryDto, HttpStatus.CREATED);
		}
		
		@PutMapping("/{categoryId}")
		public ResponseEntity<CategoryDto> updateUser(@RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer cid ) {
			
			CategoryDto updatedCategoryDto = catService.updateCategory(cid, categoryDto);		
			return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
		}
		
		
		@DeleteMapping("/{categoryId}")
		public ResponseEntity<ApiResponse> deleteUser (@PathVariable("categoryId") Integer cid ) {
			
		     catService.deleteCategory(cid);		
			return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully", true), HttpStatus.OK);
		}
}

