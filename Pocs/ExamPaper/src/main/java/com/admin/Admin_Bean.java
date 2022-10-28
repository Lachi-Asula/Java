package com.admin;

public class Admin_Bean {
	int adminId;
	String firstName;
	String surName;
	String gender;
	String mobile;
	String emailId;
	String passWord;
	
	public Admin_Bean(int adminId, String firstName, String surName, String gender, String mobile, String emailId, String passWord) {
		super();
		this.adminId = adminId;
		this.firstName = firstName;
		this.surName = surName;
		this.gender = gender;
		this.mobile = mobile;
		this.emailId = emailId;
		this.passWord = passWord;
	}

	public int getId() {
		return adminId;
	}

	public void setId(int id) {
		this.adminId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Admin_Bean [id=" + adminId + ", firstName=" + firstName + ", surName=" + surName + ", mobile=" + mobile
				+ ", emailId=" + emailId + ", passWord=" + passWord + "]";
	}
	
}
