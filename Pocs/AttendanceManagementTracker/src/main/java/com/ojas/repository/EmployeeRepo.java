package com.ojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.EmployeeTypeMaster;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeTypeMaster, Integer> {

	@Query("select distinct batchNum from EmployeeTypeMaster")
	public List<String> findByBatchNums();
	
	@Query("from EmployeeTypeMaster where batchNum=:batch")
	public List<EmployeeTypeMaster> getEmployeeInfo(String batch);
}
