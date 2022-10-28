package com.ojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.UserModel;
import com.ojas.service.UserService;

@RestController
@RequestMapping("/mail")
public class UserController {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Mail Transfer Spring Boot Application";
	}
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserModel user) {
		userServ.addUser(user);
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setTo(user.getEmailid());
		mailMessage.setSubject("Registration");
		mailMessage.setText("Registration Successful");
		
		mailSender.send(mailMessage);
		
		return "User added Successfully";
	}

}
