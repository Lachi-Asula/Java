package com.ojas.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

	private int empId;
	private String empName;
	private String emailId;
	private String batchNum;
	private Date doj;
	
}
