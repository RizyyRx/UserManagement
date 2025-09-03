package com.example.springbootvalidations.UserManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name is required")
    @Size(min = 3, max = 10, message = "Name must be between 3 and 10 characters")
	private String name;
	
	@Min(value = 20, message = "Age must be at least 20")
	@Max(value = 50, message = "Age must not exceed 50")
	private int age;
	
	@NotBlank(message = "username is required")
	private String username;
	
	@NotBlank(message = "password is required")
	private String password;
	
	public User(int id,
			@NotBlank(message = "Name is required") @Size(min = 3, max = 10, message = "Name must be between 3 and 10 characters") String name,
			@Min(value = 20, message = "Age must be at least 20") @Max(value = 50, message = "Age must not exceed 50") int age,
			String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", username=" + username + ", password="
				+ password + "]";
	}
}
