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
public class Attendance {

	private int sno;
	private int empId;
	private Date date;
	private String status;
	private String batchNum;
}
