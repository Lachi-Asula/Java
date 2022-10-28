package com.ssn.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.ssn.model.GetNamesAndDobs;
import com.ssn.model.SsnModel;
import com.ssn.service.SsnService;

@RestController
public class SsnController {

	@Autowired
	private SsnService ssnServ;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to the Spring Boot Application";
	}
	
	@PostMapping("/add")
	public SsnModel addUser(@RequestBody SsnModel user) {
		SsnModel ssUser = ssnServ.addUser(user);
		
		return ssUser;
	}
	
	@GetMapping("/list")
	public List<SsnModel> getList(){
		
		return ssnServ.getList();
	}
	
	@GetMapping("/getUser/{id}")
	public SsnModel getUser(@PathVariable int id) {
		return ssnServ.getUser(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		ssnServ.deleteUser(id);
		
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public SsnModel updateUser(@PathVariable int id,@RequestBody SsnModel ssn) {
		
		return ssnServ.updateUser(id, ssn);
	}
	
	@GetMapping("/validate/{firstname}/{lastname}")
	public String validate(@PathVariable String firstname,@PathVariable String lastname) {
		String res = "Invalid Detailes";
		
		if(ssnServ.validate(firstname, lastname)) {
			res = "Valid Detailes";
		}
		
		return res;
	}
	
	@GetMapping("/getNames")
	public List<String> getNames(){
		
		return ssnServ.getNames();
	}
	
	@GetMapping("/getNamesDobs")
	public List<GetNamesAndDobs> getNamesAndDobs(){
		List<GetNamesAndDobs> m = ssnServ.getNamesAndDobs();
		
		return m;
	}
}
