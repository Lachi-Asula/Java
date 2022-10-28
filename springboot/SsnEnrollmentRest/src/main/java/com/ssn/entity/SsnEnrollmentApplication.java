package com.ssn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ssnenrollment")
public class SsnEnrollmentApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SSN")
	private int ssn;
	@Column(name="FIRSTNAME")
	private String firstname;
	@Column(name="LASTNAME")
	private String lastname;
	@Column(name="GENDER")
	private String gender;
	@Column(name="STATENAME")
	private String statename;
	@Column(name="DOB")
	private Date dob;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATEDATE", updatable = false)
	private Date create_Date;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATEDDATE", insertable = false)
	private Date update_Date;
}
