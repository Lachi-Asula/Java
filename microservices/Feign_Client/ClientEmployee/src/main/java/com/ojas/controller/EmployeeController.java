package com.ojas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Employee;

@RestController
@RequestMapping("/emp1")
public class EmployeeController {
	
	@Autowired
	private Employee emp;
	
	@GetMapping("/wel")
	public String welcome() {
		return "Employee First Controller";
	}
	
	@GetMapping("/list")
	public List<Employee> getEmps(){
		List<Employee> li = new ArrayList<>();
		li.add(new Employee(11,"lachi",2000));
		li.add(new Employee(22,"siva",4200));
		li.add(new Employee(33,"gopi",2900));

		return li;
	}
}
