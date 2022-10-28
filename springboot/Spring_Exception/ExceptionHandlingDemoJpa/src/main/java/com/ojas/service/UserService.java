package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.Dao.UserDao;
import com.ojas.exception.UserNotFoundException;
import com.ojas.model.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserEntity addUser(UserEntity user) {
		
		return userDao.save(user);
	}
	
	public List<UserEntity> getListUsers(){
		
		return userDao.findAll();
	}
	
	public UserEntity getUser(int id) {
		//System.out.println("Ok boss"+id);
		UserEntity ue;
		try {
			ue = userDao.findById(id).get();
		}
		catch(Exception e) {
			throw new UserNotFoundException("UserNotFound");
		}
		return ue;
	}
}
