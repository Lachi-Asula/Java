package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.Employee;
import com.ojas.service.EmpServ;

@RestController
public class EmpController {

	@Autowired
	private EmpServ empServ;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Employee-Company SpringBoot Company";
	}
	
	@PostMapping("/add")
	public Employee getEmp(@RequestBody Employee emp) {
		
		return empServ.addEmp(emp);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getEmps(){
		
		List<Employee> li = empServ.listEmps();
		return new ResponseEntity<List<Employee>>(li, HttpStatus.OK);
	}
	
	@PostMapping("/addEmps")
	public List<Employee> addEmps(@RequestBody List<Employee> li){
		
		return empServ.addEmps(li);
	}
	
	@GetMapping("/getEmp/{id}")
	public Employee getEmp(@PathVariable int id) {
		
		return empServ.findByIdEmp(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		
		empServ.deleteEmp(id);
		
		return "Deleted Successfully";
	}
	
	@PutMapping("/update/{id}")
	public Employee updateEmp(@PathVariable int id, @RequestBody Employee emp) {
		
		return empServ.updateEmp(id, emp);
	}
}
