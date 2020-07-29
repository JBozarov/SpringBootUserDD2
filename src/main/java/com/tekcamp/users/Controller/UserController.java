package com.tekcamp.users.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekcamp.users.Dto.UserDto;
import com.tekcamp.users.Model.Request.UserRequest;
import com.tekcamp.users.Model.Response.UserResponse;
import com.tekcamp.users.Service.UserService;

@RestController
@RequestMapping
public class UserController {

	private UserService userService; 
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		UserDto userDto = new UserDto(); 
	}


	@GetMapping
	public void getAllUsers() {
		userService.getAllUsers(); 
	}
	
	@GetMapping(path="/{userId}")
	public UserResponse getSingleUser(@PathVariable String userId) {
		UserResponse userResponse = userService.getSingleUser(userId); 
		return userResponse; 
	}
	
	
}




















