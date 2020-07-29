package com.tekcamp.users.Service.Implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tekcamp.users.Dao.UserRepository;
import com.tekcamp.users.Dto.UserDto;
import com.tekcamp.users.Model.UserEntity;
import com.tekcamp.users.Service.UserService;
import com.tekcamp.users.Shared.Utils;

@Service
public class UserServiceImplementation implements UserService{

	private UserRepository userRepository; 
	private Utils utils; 
	
	public UserServiceImplementation(UserRepository userRepository, Utils utils) {
		super();
		this.userRepository = userRepository;
		this.utils = utils; 
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity newUser = new UserEntity(); 
		BeanUtils.copyProperties(userDto, newUser);
		
		newUser.setEncryptedPassword("password-test-mock");
		newUser.setEmailVerification(true);
		newUser.setUserId(utils.generateUserId(30));
	
		UserEntity storedUser = userRepository.save(newUser); 
		
		UserDto returnUser = new UserDto(); 
		BeanUtils.copyProperties(storedUser, returnUser);
		
		return returnUser; 
	}
	

	

	
}
