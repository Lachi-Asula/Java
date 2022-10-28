package com.ojas.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.UserDao;
import com.ojas.entity.UserEntity;
import com.ojas.model.UserModel;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public UserModel addUser(UserModel user) {
		UserEntity user1 = new UserEntity();
		BeanUtils.copyProperties(user, user1);
		
		userDao.save(user1);
		
		return user;
		
	}
}
