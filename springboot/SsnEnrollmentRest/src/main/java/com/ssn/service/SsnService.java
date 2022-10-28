package com.ssn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssn.dao.SsnDao;
import com.ssn.entity.SsnEnrollmentApplication;
import com.ssn.exceptions.SsnNotFoundException;
import com.ssn.model.GetNamesAndDobs;
import com.ssn.model.SsnModel;

@Service
public class SsnService {

	@Autowired
	private SsnDao ssnDao;
	
	public SsnModel addUser(SsnModel user) {
		SsnEnrollmentApplication ssnUser = new SsnEnrollmentApplication();
		BeanUtils.copyProperties(user, ssnUser);
		
		ssnUser = ssnDao.save(ssnUser);
		BeanUtils.copyProperties(ssnUser, user);
		
		return user;
	}
	
	public List<SsnModel> getList(){
		List<SsnEnrollmentApplication> li = ssnDao.findAll();
		List<SsnModel> ssnLi = new ArrayList<>();
		
		for(SsnEnrollmentApplication se : li) {
			SsnModel sm = new SsnModel();
			BeanUtils.copyProperties(se, sm);
			
			ssnLi.add(sm);
		}
		
		return ssnLi;
	}
	
	public SsnModel getUser(int id) {
		SsnModel sm;
		try {
			SsnEnrollmentApplication se = ssnDao.findById(id).get();
			sm = new SsnModel();
			BeanUtils.copyProperties(se, sm);
		}
		catch(Exception e) {
			throw new SsnNotFoundException("Given Ssn is Not Matched");
		}
		return sm;
	}
	
	public void deleteUser(int id) {
		try {
			ssnDao.deleteById(id);
		}
		catch(Exception e) {
			throw new SsnNotFoundException("Given Ssn Number is not Matched");
		}
	}
	
	public SsnModel updateUser(int id, SsnModel user) {
		SsnModel ssnUser = getUser(id);
		ssnUser.setFirstname(user.getFirstname());
		ssnUser.setLastname(user.getLastname());
		ssnUser.setStatename(user.getStatename());
		ssnUser.setGender(user.getGender());
		ssnUser.setDob(user.getDob());
		
		SsnEnrollmentApplication se = new SsnEnrollmentApplication();
		BeanUtils.copyProperties(ssnUser, se);
		
		ssnDao.save(se);
		
		return ssnUser;
	}
	
	public boolean validate(String firstName, String lastName) {
		boolean b = true;
		
		SsnEnrollmentApplication se = ssnDao.findByFirstnameAndLastname(firstName, lastName);
		if(se == null) {
			b = false;
		}
		
		return b;
	}
	
	public List<String> getNames(){
		
		return ssnDao.getByNames();
	}
	
	public List<GetNamesAndDobs> getNamesAndDobs(){
		
		return ssnDao.findFirstnamesAndDobs();
	}
}
