package com.users;

public class User_Bean {
	int uid;
	String firstName;
	String surName;
	String gender;
	String mobile;
	String email;
	String password;
	
	public User_Bean(String firstName, String surName, String gender, String mobile, String email,String password) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getsurName() {
		return surName;
	}

	public void setsurName(String surName) {
		this.surName = surName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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

	@Override
	public String toString() {
		return "User_Bean [uid=" + uid + ", firstName=" + firstName + ", surName=" + surName + ", gender=" + gender
				+ ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
	}

}
