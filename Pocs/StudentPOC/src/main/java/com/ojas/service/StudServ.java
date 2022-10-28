package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.bean.Student;
import com.ojas.dao.StudDao;
import com.ojas.exceptions.StudentNotFoundException;

@Service
public class StudServ {

	@Autowired
	private StudDao stdDao;
	
	public Student addStud(Student std) {
		
		return stdDao.save(std);
	}
	
	public Student getStudent(int id) {
		try {
			return stdDao.findById(id).get();
		}
		catch(Exception e) {
			throw new StudentNotFoundException("Student Not Found");
		}
	}
	
	public List<Student> getAllStuds(){
		return stdDao.findAll();
	}
}
