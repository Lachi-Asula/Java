package com.ojas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employeetypemaster")
public class EmployeeTypeMaster {

	@Id
	@Column(name="EMPID")
	private int empId;
	
	@Column(name="EMPNAME")
	private String empName;
	
	@Column(name="EMAILID")
	private String emailId;
	
	@Column(name="BATCHNUM")
	private String batchNum;
	
	@Column(name="DOJ")
	private Date doj;
}
