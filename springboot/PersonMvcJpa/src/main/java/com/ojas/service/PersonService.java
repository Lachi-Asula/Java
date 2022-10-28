package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.PersonDao;
import com.ojas.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao persDao;
	
	public Person addPerson(Person p) {
		
		return persDao.save(p);
	}
	
	public List<Person> getList(){
		
		return persDao.findAll();
	}
	
	public Person getPerson(int id) {
		Person p = null;
		try {
			p = persDao.getById(id);
		}
		catch(Exception e) {
			System.out.println("Record Not Founded");
			p = null;
		}
		
		return p;
	}
	
	public void deletePerson(int id) {
		
		persDao.deleteById(id);
	}
	
	public Person updatePerson(int id,Person p) {
		Person pers = getPerson(id);
		pers.setFirstName(p.getFirstName());
		pers.setLastName(p.getLastName());
		pers.setMobileNum(p.getMobileNum());
		pers.setEmailId(p.getEmailId());
		pers.setPassword(p.getPassword());
		
		return persDao.save(pers);
	}
}
