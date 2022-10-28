package com.ojas.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.exception.InvalidDetailesException;
import com.ojas.model.Attendance;
import com.ojas.model.Employee;
import com.ojas.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeServ;
	private static String batch;
	
	@GetMapping("/reg")
	public String welcome() {
		
		return "Registration";
	}
	
	@RequestMapping("/register")
	public String register(@ModelAttribute Employee emp) {
		employeeServ.registerEmp(emp);
		
		return "success";
		
	}
	
	@GetMapping("/batchNums")
	public String getBatchNums(Model m) {
		m.addAttribute("attend", new Attendance());
		List<String> list = employeeServ.getBatchNums();
		m.addAttribute("empList", list);
		
		return "EmployeeInfo";
	}
	
	@GetMapping("/empInfo")
	public String displayEmp(@RequestParam String batchNum, Model m) {
		List<Employee> li = employeeServ.getInfo(batchNum);
		m.addAttribute("Info", li);
		batch = batchNum;
		
		return "EmployeeInfo";
	}
	
	@PostMapping("/saveStatus")
	public String saveStatus(@RequestParam List<String> empId,@RequestParam List<String> status, @RequestParam String now) {
		List<Attendance> statusList = new ArrayList<>();
		
		try {
			for(int i = 0; i < empId.size(); i++) {
				Attendance attend = new Attendance();
				attend.setEmpId(Integer.parseInt(empId.get(i)));
				attend.setStatus(status.get(i));
				attend.setDate(new Date(now));
				attend.setBatchNum(batch);
				
				statusList.add(attend);
			}
		
			employeeServ.addStatus(statusList);
		
			return "success";
		}
		catch(Exception e){
			throw new InvalidDetailesException("Please Enter Proper Detailes");
		}
	}
	
}
