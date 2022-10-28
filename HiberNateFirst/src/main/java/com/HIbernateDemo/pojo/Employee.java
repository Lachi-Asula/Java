package com.HIbernateDemo.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

import org.hibernate.annotations.Entity;

@Entity
@Table(name="emp2")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(name="ENAME")
	private String empName;
	
	@Column(name="ESAL")
	private float eSalary;
	
	@Column(name="EADDR")
	private String empAddr;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float geteSalary() {
		return eSalary;
	}

	public void seteSalary(float eSalary) {
		this.eSalary = eSalary;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", eSalary=" + eSalary + ", empAddr=" + empAddr
				+ "]";
	}
	
	
}
