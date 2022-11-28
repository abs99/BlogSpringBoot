package blog.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionController {
      
	 @ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
		
		 String message = ex.getMessage();
		 ApiResponse apiResponse = new ApiResponse(message, false);
		 return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	 
	 @ExceptionHandler(EmptyResultDataAccessException.class)
	 public ResponseEntity<ApiResponse> EmptyResultDataAccessExceptionHandler(EmptyResultDataAccessException ex) {
			
		 String message = ex.getMessage();
		 ApiResponse apiResponse = new ApiResponse(message, false);
		 return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}
