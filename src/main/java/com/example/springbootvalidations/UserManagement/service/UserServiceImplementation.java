package com.example.springbootvalidations.UserManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springbootvalidations.UserManagement.model.User;
import com.example.springbootvalidations.UserManagement.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	public UserServiceImplementation(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	private UserRepository userRepo;
	
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public boolean loginUser(String username, String password) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findByUsernameAndPassword(username, password);
        return user.isPresent();
	}

	@Override
	public List<User> getUsersAboveAge(int age) {
		// TODO Auto-generated method stub
		return userRepo.findByAgeGreaterThan(age);
	}

}
