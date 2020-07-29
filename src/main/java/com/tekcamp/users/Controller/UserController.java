package com.tekcamp.users.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekcamp.users.Dto.UserDto;
import com.tekcamp.users.Model.UserEntity;
import com.tekcamp.users.Model.Request.UserRequest;
import com.tekcamp.users.Model.Response.UserResponse;
import com.tekcamp.users.Service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	private UserService userService; 
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		UserDto userDto = new UserDto(); 
		BeanUtils.copyProperties(userRequest, userDto);
		
		UserDto createdUser = userService.createUser(userDto);
		
		UserResponse userResponse = new UserResponse(); 
		BeanUtils.copyProperties(createdUser, userResponse);
		return userResponse; 
	}


	@GetMapping
	public ArrayList<UserResponse> getAllUsers() {
		ArrayList<UserDto> userDtoList = (ArrayList<UserDto>) userService.getAllUsers(); 
		
		ArrayList<UserResponse> responseUserList = new ArrayList<UserResponse>(); 
		UserResponse userResponse = new UserResponse(); 
		
		for ( int i = 0; i<userDtoList.size(); i++ ) {
			BeanUtils.copyProperties(userDtoList.get(i), userResponse);
			responseUserList.add(userResponse); 
		}
		return responseUserList; 
	}

	
	@GetMapping(path="/{userId}")
	public UserResponse getSingleUser(@PathVariable String userId) {
		UserResponse userResponse = userService.getSingleUser(userId); 
		return userResponse; 
	}
	
	
}




















