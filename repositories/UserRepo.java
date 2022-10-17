package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import entities.User;
import payloads.UserDto;

public interface UserRepo extends JpaRepository<User, Integer> {

	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user);
	UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
	
}
