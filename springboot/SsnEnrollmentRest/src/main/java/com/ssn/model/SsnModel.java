package com.ssn.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SsnModel {

	private int ssn;
	private String firstname;
	private String lastname;
	private String gender;
	private String statename;
	private Date dob;
}
