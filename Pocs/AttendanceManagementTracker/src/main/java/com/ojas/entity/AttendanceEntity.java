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
@Table(name="attendance")
public class AttendanceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SNO")
	private int sno;
	
	@Column(name="EMPID")
	private int empId;
	
	@Column(name="DATE")
	private Date date;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="BATCHNUM")
	private String batchNum;
}
