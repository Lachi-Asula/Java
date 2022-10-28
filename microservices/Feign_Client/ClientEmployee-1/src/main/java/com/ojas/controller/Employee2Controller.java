package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Employee123;
import com.ojas.proxy.EmployeeFeign;

@RestController
@RequestMapping("/emp2")
public class Employee2Controller {
	
	@Autowired
	private EmployeeFeign empFeign;
	
	@GetMapping("/wel")
	public String welcome() {
		return "Employee Second Controller";
	}
	
	@GetMapping("/empList")
	public List<Employee123> getEmps(){
		
		return empFeign.getEmpList();
	}
}
