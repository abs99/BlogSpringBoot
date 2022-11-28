package blog.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.entities.User;
import blog.exceptions.ResourceNotFoundException;
import blog.payloads.UserDto;
import blog.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public UserDto createUser(UserDto userdto) {
		  
		  User user = modelMapper.map(userdto, User.class);
		  User savedUser = userRepo.save(user);
	      return modelMapper.map(savedUser, UserDto.class);
		
	}

	public UserDto updateUser(UserDto userdto, Long userId) {
		
		User user = userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User", "id", String.valueOf(userId)));
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setUsername(userdto.getUsername());
		userRepo.save(user);
		
		return modelMapper.map(user,UserDto.class);
	}

	public UserDto getUserById(Long userId) {
		
		User user = userRepo.findById(userId).orElseThrow( ()-> new ResourceNotFoundException("User", "id", String.valueOf(userId)));
		
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
	}

	public List<UserDto> getAllUsers() {
		
		 List<UserDto> userDtoList = new ArrayList<UserDto>();
		 List<User> users = userRepo.findAll(); 
		 for (User user : users) {
			userDtoList.add(modelMapper.map(user, UserDto.class));
		}
		return userDtoList;
	}

	public void deleteUser(Long userId) {
		
		userRepo.deleteById(userId);
		return;
		
	}
	
	
}
