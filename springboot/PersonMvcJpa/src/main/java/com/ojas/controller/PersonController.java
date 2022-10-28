package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ojas.model.Person;
import com.ojas.service.PersonService;

@Controller
public class PersonController {

	static int temp = 0;
	
	@Autowired
	private PersonService persServ;
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping("/reg")
	public String regPage(Model m) {
		
		m.addAttribute("pers", new Person());
		
		return "registration";
	}
	
	@RequestMapping("/add")
	public String addPerson(@ModelAttribute("pers") Person person) {
		Person p = persServ.addPerson(person);
		
		return "success";
	}
	
	@RequestMapping("/find")
	public String findPerson(@RequestParam String id, Model m) {
		int id1 = Integer.parseInt(id);
		Person p = persServ.getPerson(id1);
		if(p != null) {
			m.addAttribute("pers", p);
			return "updateDelete";
		}
		else {
			return "error";
		}
	}
	
	@RequestMapping("/list")
	public String getList(Model m) {
		List<Person> li = persServ.getList();
		m.addAttribute("person", li);
		
		return "listPersons";
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePerson(@PathVariable int id, Model m) {
		persServ.deletePerson(id);
		List<Person> li = persServ.getList();
		m.addAttribute("person", li);
		
		return "listPersons";
	}
	
	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable int id, Model m) {
		Person p = persServ.getPerson(id);
		temp = id;
		m.addAttribute("pers", p);
		
		return "updatePerson";
	}
	
	@RequestMapping("/PersonMvcJpa/upd")
	public String updatePerson(@ModelAttribute("pers") Person pers, Model m) {
		Person p = persServ.updatePerson(temp,pers);
		List<Person> li = persServ.getList();
		m.addAttribute("person", li);
		
		return "listPersons";
	}
}
