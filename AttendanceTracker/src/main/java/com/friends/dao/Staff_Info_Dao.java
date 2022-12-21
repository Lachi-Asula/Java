package com.friends.dao;

import com.friends.model.Staff_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface Staff_Info_Dao extends JpaRepository<Staff_Info_Entity, String> {
    Optional<Staff_Info_Entity> findByFldEmpIdAndFldPassword(String empId, String password);

    Optional<Staff_Info_Entity> findByFldEmpId(String empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TBL_AUDIT_STAFF_INFO set FLD_PASSWORD = :password WHERE FLD_EMP_ID = :empId", nativeQuery = true)
    void updatePasswordByEmpId(String password, String empId);
}
