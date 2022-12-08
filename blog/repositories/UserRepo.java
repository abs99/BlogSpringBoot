package blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import blog.entities.User;
import blog.payloads.UserDto;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

//	UserDto createUser(UserDto user);
//	UserDto updateUser(UserDto user);
//	UserDto getUserById(Integer userId);
//    List<UserDto> getAllUsers();
//    void deleteUser(Integer userId);
	
}
