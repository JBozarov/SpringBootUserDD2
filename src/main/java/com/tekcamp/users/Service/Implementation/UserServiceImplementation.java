package com.tekcamp.users.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tekcamp.users.Dao.UserRepository;
import com.tekcamp.users.Dto.UserDto;
import com.tekcamp.users.Model.UserEntity;
import com.tekcamp.users.Model.Response.UserResponse;
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

	
	@Override
	public ArrayList<UserDto> getAllUsers() {
		
		ArrayList<UserEntity> users = (ArrayList<UserEntity>) userRepository.findAll(); 
		
		ArrayList<UserDto> userDtoList = new ArrayList<UserDto>(); 
		UserDto userDto = new UserDto(); 
		
		for ( int i = 0; i<users.size(); i++ ) {
			BeanUtils.copyProperties(users.get(i), userDto);
			userDtoList.add(userDto); 
		}
		
		return userDtoList;
	}

	
	
	@Override
	public UserResponse getSingleUser(String userId) {
		ArrayList<UserEntity> users = (ArrayList<UserEntity>) userRepository.findAll();
		UserResponse userResponse = new UserResponse(); 
		for ( int i = 0; i<users.size(); i++ ) {
			if (users.get(i).getUserId().equals(userId)) {
				BeanUtils.copyProperties(users.get(i), userResponse);
				return userResponse; 
			}
		}
		return null; 
	}
	

	

	
}
