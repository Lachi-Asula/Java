package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.EmpDao;
import com.ojas.model.Employee;

@Service
public class EmpServ {

	@Autowired
	private EmpDao empDao;
	
	public Employee addEmp(Employee emp) {
		
		return empDao.save(emp);
	}
	
	public List<Employee> listEmps(){
//		List<Employee> li = new ArrayList<>();
//		empDao.findAll().forEach(li::add);
		
		return empDao.findAll();
	}
	
	public List<Employee> addEmps(List<Employee> li){
		empDao.saveAll(li);
		return li;
	}
	
	public Employee findByIdEmp(int id) {
		return empDao.findById(id).get();
	}
	
	public void deleteEmp(int id) {
		Employee emp = findByIdEmp(id);
		empDao.delete(emp);
	}
	
	public Employee updateEmp(int id, Employee emp) {
		
		Employee e = findByIdEmp(id);
		e.setEid(emp.getEid());
		e.setEname(emp.getEname());
		e.setSalary(emp.getSalary());
		e.setCompany(emp.getCompany());
		
		return empDao.save(e);
	}
		
}
