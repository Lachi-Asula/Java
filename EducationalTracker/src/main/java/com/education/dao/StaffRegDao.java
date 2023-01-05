package com.education.dao;

import com.education.model.StaffRegistration_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StaffRegDao extends JpaRepository<StaffRegistration_Entity, String> {

    @Query(value = "select STAFFID.nextval from dual", nativeQuery = true)
    int getStaffIdVal();

    Optional<StaffRegistration_Entity> findByFldStaffId(String staffId);

    Optional<StaffRegistration_Entity> findByFldStaffIdAndFldEmailId(String userId, String emailId);

    Optional<StaffRegistration_Entity> findByFldFullNameAndFldEmailId(String fullName, String emailId);

    @Transactional
    @Modifying
    @Query("update StaffRegistration_Entity set fldPassword =:newPassword where fldStaffId =:userId")
    void updatePasswordByUserId(String userId, String newPassword);
}
