package com.ojas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ojas.entity.UserEntity;
import com.ojas.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public String addUser(UserEntity user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		
		return "User Added Successfully";
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<String> roles = Arrays.asList("USER", "ADMIN");
		UserEntity user = userRepo.findByUserName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("UserName Not Existed");
		}
		
		return new User(username, user.getPassword(), 
				roles.stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
	}
	
	public List<UserEntity> getList(){
		
		return userRepo.findAll();
	}
	
}
