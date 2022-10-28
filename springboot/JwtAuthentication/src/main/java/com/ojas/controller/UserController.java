package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.UserEntity;
import com.ojas.jwt.JwtUtil;
import com.ojas.jwtEntity.UserRequest;
import com.ojas.jwtEntity.UserResponse;
import com.ojas.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userServ;
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private AuthenticationManager authentication;
	
	@PostMapping("/register")
	public String addUser(@RequestBody UserEntity user) {
		
		return userServ.addUser(user);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResponse> verify(@RequestBody UserRequest req){
		authentication.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
		
		String token = util.generateToken(req.getUsername());
		
		return ResponseEntity.ok(new UserResponse(token));
	}
	
	@GetMapping("/list")
	public List<UserEntity> getList(){
		
		return userServ.getList();
	}
}
