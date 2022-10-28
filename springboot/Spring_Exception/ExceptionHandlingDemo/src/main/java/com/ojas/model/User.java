package com.ojas.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int uid;
	private String uname;
	private String email;
	private String password;
	
	static List<User> li = new ArrayList<>();
	
	static {
		li.add(new User(11,"lachi","asula.aln@gmail.com","Asula@143"));
		li.add(new User(12,"siva","siva@gmail.com","Siva@143"));
		li.add(new User(13,"leela","leela@gmail.com","Leela@143"));
		li.add(new User(14,"gopi","gopi@gmail.com","gopi@123"));
		li.add(new User(15,"sai","sai@gmail.com","sai@123"));
	}

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int uid, String uname, String email, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.email = email;
		this.password = password;
	}


	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public static List<User> getLi() {
		return li;
	}


	public static void setLi(List<User> li) {
		User.li = li;
	}


	public User getUser(int id) {
		User u = null;
		
		for(User user : li) {
			if(user.getUid() == id) {
				u = user;
				break;
			}
		}
		
		return u;
	}
	
}
