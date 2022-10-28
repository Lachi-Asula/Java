package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Employee;
import com.ojas.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empServ;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome Employee Spring Boot Application";
	}
	
	@PostMapping("/add")
	public Employee addEmp(@RequestBody Employee emp) {
		return empServ.addEmp(emp);
	}
	
	@GetMapping("/display")
	public ResponseEntity<List<Employee>> getEmps(){
		List<Employee> li = empServ.getEmps();
		
		return new ResponseEntity<List<Employee>>(li, HttpStatus.OK);
	}
}
