package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.EmpDao;
import com.ojas.model.Employee;

@Service
public class EmpService {

	@Autowired
	private EmpDao empDao;
	
	public Employee addEmp(Employee emp) {
		
		return empDao.save(emp);
	}
	
	public List<Employee> getEmps(){
		
		List<Employee> li = new ArrayList<>();
		li = empDao.findAll();
	//	empDao.findAll().forEach(li::add);
		return li;
	}
}
