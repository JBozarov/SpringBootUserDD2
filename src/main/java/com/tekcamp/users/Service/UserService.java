package com.tekcamp.users.Service;

import com.tekcamp.users.Model.Response.UserResponse;

public interface UserService {

	void getAllUsers();

	UserResponse getSingleUser(String userId);

}
