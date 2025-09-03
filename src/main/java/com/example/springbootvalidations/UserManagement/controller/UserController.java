package com.example.springbootvalidations.UserManagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootvalidations.UserManagement.dto.LoginRequest;
import com.example.springbootvalidations.UserManagement.model.User;
import com.example.springbootvalidations.UserManagement.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping
	 public ResponseEntity<String> CreateUser(@RequestBody @Valid User user)
	    {
			userService.createUser(user);
	        return new ResponseEntity<String>("User created successfully", HttpStatus.CREATED);
	        // return ResponseEntity.ok("User created successfully");
	    }
	
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean success = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (success) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
    
    @GetMapping("/above/{age}")
    public ResponseEntity<List<User>> getUsersAboveAge(@PathVariable int age) {
        List<User> users = userService.getUsersAboveAge(age);
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

	
}
