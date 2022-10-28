package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Student;
import com.ojas.service.StudServ;

@RestController
@RequestMapping("/api")
public class StudController {
	
	@Autowired(required = false)
	private StudServ studService;
	
	@PostMapping("/add")
	public Student stud(@RequestBody Student std) {
		return studService.addStud(std);
	}
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome Spring Boot Rest Api";
	}
	
	@GetMapping("/display")
	public ResponseEntity<List<Student>> getStuds(){
		
		List<Student> li = studService.getAllStuds();
		return new ResponseEntity<>(li, HttpStatus.OK);
	}
}
