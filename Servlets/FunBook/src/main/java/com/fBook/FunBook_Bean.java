package com.fBook;

public class FunBook_Bean {
	private int id;
	private String firstName;
	private String surName;
	private String gender;
	private String mobile;
	private String email;
	private String password;
	
	public FunBook_Bean(String firstName, String surName, String gender, String mobile, String email, String password) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "FunBook_Pojo [id=" + id + ", firstName=" + firstName + ", surName=" + surName + ", gender=" + gender
				+ ", mobile=" + mobile + ", email=" + email + ", password=" + password + "]";
	}

}

