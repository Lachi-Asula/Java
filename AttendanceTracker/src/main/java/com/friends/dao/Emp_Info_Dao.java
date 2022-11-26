package com.friends.dao;

import com.friends.model.Emp_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Emp_Info_Dao extends JpaRepository<Emp_Info_Entity, Integer> {

    @Query(value = "select empid.NEXTVAL from dual",  nativeQuery = true)
    String getnewEmpID();

    Optional<Emp_Info_Entity> findByFldFullNameAndFldEmailId(String fullName, String emailId);

    Optional<List<Emp_Info_Entity>> findByFldBatchNum(String batchNum);
}
