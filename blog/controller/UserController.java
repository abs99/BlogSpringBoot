package blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blog.payloads.ApiResponse;
import blog.payloads.UserDto;
import blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		
		UserDto createduserDto = userService.createUser(userDto);
		
		return new ResponseEntity<>(createduserDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Long uid ) {
		
		UserDto updatedUserDto = userService.updateUser(userDto,uid);		
		return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Long uid ) {
		
		UserDto userDto = userService.getUserById(uid);		
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity <List<UserDto>> getAllUsers() {
		
		List<UserDto>  userDtoList  = userService.getAllUsers();	
		return new ResponseEntity<>(userDtoList, HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser (@PathVariable("userId") Long uid ) {
		
	     userService.deleteUser(uid);		
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
	 
}
