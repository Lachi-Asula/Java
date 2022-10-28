package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.AttendanceEntity;
import com.ojas.entity.EmployeeTypeMaster;
import com.ojas.model.Attendance;
import com.ojas.model.Employee;
import com.ojas.repository.AttendanceRepo;
import com.ojas.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private AttendanceRepo attendRepo;
	
	public Employee registerEmp(Employee emp) {
		EmployeeTypeMaster empTM = new EmployeeTypeMaster();
		
		BeanUtils.copyProperties(emp, empTM);
		
		empTM = employeeRepo.save(empTM);
		BeanUtils.copyProperties(empTM, emp);
		
		return emp;
	}
	
	public List<String> getBatchNums(){
		List<String> list = employeeRepo.findByBatchNums();
		
		return list;
	}
	
	public List<Employee> getInfo(String batchNum){
		List<EmployeeTypeMaster> info = employeeRepo.getEmployeeInfo(batchNum);
		List<Employee> empInfo = new ArrayList<>();
		
		for(EmployeeTypeMaster emp : info) {
			Employee em = new Employee();
			BeanUtils.copyProperties(emp, em);
			
			empInfo.add(em);
		}
		
		return empInfo;
	}
	
	public void addStatus(List<Attendance> list) {
		List<AttendanceEntity> li = new ArrayList<>();
		System.out.println("Service Page");
		for(Attendance attend : list) {
			AttendanceEntity attendEntity = new AttendanceEntity();
			BeanUtils.copyProperties(attend, attendEntity);
			
			li.add(attendEntity);
		//	attendRepo.save(attendEntity);
		}
		
		
		
		attendRepo.saveAll(li);
	}
}
