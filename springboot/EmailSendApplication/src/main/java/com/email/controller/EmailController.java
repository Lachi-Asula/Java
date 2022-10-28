package com.email.controller;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.Email;

@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot Mail Application";
	}
	
	@PostMapping("/normalMail")
	public String sendNormaMail(@RequestBody Email email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email.getReceiverMail());
		mailMessage.setSubject(email.getSubject());
		mailMessage.setText(email.getText());
		
		mailSender.send(mailMessage);
		
		return "Mail Sent Successfully";
	}
	
	@PostMapping("/mailWithAttachment")
	public String sendMailWithAttachment(@RequestBody Email email)throws Exception {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setTo(email.getReceiverMail());
		helper.setSubject(email.getSubject());
		helper.setText(email.getText());
		
		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\asula\\clg.jpg"));
		helper.addAttachment("clg.jpg", file);
		
		mailSender.send(message);
		
		return "Mail Sent Successfully";
	}
}
