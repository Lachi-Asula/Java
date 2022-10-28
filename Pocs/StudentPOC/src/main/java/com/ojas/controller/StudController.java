package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.bean.Student;
import com.ojas.service.StudServ;

@RestController
public class StudController {

	@Autowired
	private StudServ stdServ;
	
	@RequestMapping("/")
	public ModelAndView welcome() {
		
		return new ModelAndView("welcome");
	}
		
	public StudServ getStdServ() {
		return stdServ;
	}

	@RequestMapping("/reg")
	public ModelAndView register(Model m) {
		m.addAttribute("stud", new Student());
		
		return new ModelAndView("registration");
	}
	
	@RequestMapping("/add")
	public ModelAndView addStud(@ModelAttribute Student stud) {
		
		Student std = stdServ.addStud(stud);
		System.out.println(std);
		
		return new ModelAndView("success");
	}
	
	@RequestMapping("/display")
	public ModelAndView listStuds(Model m) {
	
		List<Student> li = stdServ.getAllStuds();
		m.addAttribute("lis", li);
		
		for(Student s : li) {
			System.out.println(s);
		}
		
		return new ModelAndView("viewList");
	}
	
	@RequestMapping("/getStud/{id}")
	public ModelAndView getStud(@PathVariable int id) {
		stdServ.getStudent(id);
		return new ModelAndView("success");
	}
}
