package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.exception.UserNotFoundException;
import com.ojas.model.UserEntity;
import com.ojas.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot Application";
	}
	
	@PostMapping("/add")
	public UserEntity addUser(@RequestBody UserEntity user) {
		
		return userServ.addUser(user);
	}
	
	@GetMapping("/list")
	public List<UserEntity> getList(){
		
		return userServ.getListUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public UserEntity getUser(@PathVariable int id) {
	//	System.out.println("Id ok"+id);
		UserEntity ue=	userServ.getUser(id);
		
		return ue;
	}
}
