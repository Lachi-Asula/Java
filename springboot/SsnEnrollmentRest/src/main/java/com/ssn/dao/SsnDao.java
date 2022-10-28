package com.ssn.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssn.entity.SsnEnrollmentApplication;
import com.ssn.model.GetNamesAndDobs;

@Repository
public interface SsnDao extends JpaRepository<SsnEnrollmentApplication, Integer> {

	public SsnEnrollmentApplication findByFirstnameAndLastname(String firstname, String lastname);
	
	@Query("select firstname from SsnEnrollmentApplication")
	public List<String> getByNames();
	
	@Query("select new com.ssn.model.GetNamesAndDobs(s.firstname, s.dob) from SsnEnrollmentApplication s")
	public List<GetNamesAndDobs> findFirstnamesAndDobs();
	
//	@Query("select firstname, dob from SsnEnrollmentApplication")
//	public HashMap<String, Date> findFirstnamesAndDobs();
}
