package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.EmpDao;
import model.Employee;

@Controller
public class EmpController {
	
	EmpDao ed = new EmpDao();
	
	@RequestMapping("/reg")
	public String register(Model m) {
		m.addAttribute("emp", new Employee());
		
		return "employeeReg";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String validateEmp(@Valid @ModelAttribute("emp") Employee emp, BindingResult br) {
		
		if(br.hasErrors()) {
			return "employeeReg";
		}
		else {
			ed.addEmp(emp);
			return "login";
		}
	}
	
	@RequestMapping("/log")
	public String loginEmp(@RequestParam String em, @RequestParam String passwd) {
		List<Employee> li = ed.getEmps();
		boolean b = false;
		for(Employee e : li) {
			if(e.getEmail().equals(em) && e.getPassword().equals(passwd)) {
				b = true;
				break;
			}
		}
		
		if(b) {
			return "viewEmp";
		}
		else {
			return "login";
		}
	}
	
	@RequestMapping("/view")
	public String view(){
		
		return "viewEmp";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee e = ed.getEmp(id);
		m.addAttribute("emp", e);
		
		System.out.println("Edit");
		
		return "editUpdate";
	}
	
	@RequestMapping("/updat")
	public String update(@Valid @ModelAttribute("emp") Employee emp, BindingResult br) {
		System.out.println("Update");
		if(br.hasErrors()) {
			return "editUpdate";
		}
		else {
			ed.updateEmp(emp);
			return "viewEmp";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		ed.deleteEmp(id);
		
		return "viewEmp";
	}
}
