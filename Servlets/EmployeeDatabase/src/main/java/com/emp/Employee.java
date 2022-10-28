package com.emp;

public class Employee {
	private int eno;
	private String ename;
	private float salary;
	private String address;
	private String email;
	private String password;
	
	public Employee(String ename, float salary, String address, String email, String password) {
		super();
		this.ename = ename;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public String getEname() {
		return ename;
	}
	
	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "Employee [ename=" + ename + ", salary=" + salary + ", address=" + address + ", email=" + email
				+ ", password=" + password + "]";
	}
	
}
