package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.StudDao;
import com.ojas.model.Student;

@Service
public class StudServ {

	@Autowired(required = false)
	private StudDao stdDao;

	public List<Student> getAllStuds() {
		List<Student> userRecords = new ArrayList<>();
		stdDao.findAll().forEach(userRecords::add);
		return userRecords;
	}

	public Student addStud(Student std) {
		return stdDao.save(std);
	}
}
