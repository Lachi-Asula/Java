package com.ojas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.User;
import com.ojas.rest.UserNotFoundException;

@RestController
public class UserController {

	static User u = new User();
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot Application";
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@PathVariable int id) {
		
		User user = u.getUser(id);
		
		if(user == null) {
			throw new UserNotFoundException("UserNotFound, Try Again");
		}
		
		return user;
	}
	
	@GetMapping("/getList")
	public List<User> getList(){
		
		List<User> li = u.getLi();
		
		return li;
	}
}
