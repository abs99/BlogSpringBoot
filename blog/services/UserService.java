package blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import blog.payloads.UserDto;



public interface UserService {
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Long userId);
	UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);

}
