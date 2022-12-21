package com.friends.dao;

import com.friends.model.Emp_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface Emp_Info_Dao extends JpaRepository<Emp_Info_Entity, Integer> {

    @Query(value = "select empid.NEXTVAL from dual",  nativeQuery = true)
    String getnewEmpID();

    Optional<Emp_Info_Entity> findByFldFullNameAndFldEmailId(String fullName, String emailId);

    Optional<List<Emp_Info_Entity>> findByFldBatchNum(String batchNum);

    Optional<Emp_Info_Entity> findByFldEmpId(String empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBL_AUDIT_EMP_INFO set FLD_PASSWORD = :password WHERE FLD_EMP_ID = :empId", nativeQuery = true)
    void updatePasswordByEmpId(String password, String empId);
}
