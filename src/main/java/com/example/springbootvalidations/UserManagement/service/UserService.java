package com.example.springbootvalidations.UserManagement.service;

import java.util.List;

import com.example.springbootvalidations.UserManagement.model.User;

public interface UserService {

	User createUser(User user);
	
	boolean loginUser(String username, String password);
	
	List<User> getUsersAboveAge(int age);
}
