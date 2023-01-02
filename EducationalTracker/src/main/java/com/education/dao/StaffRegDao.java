package com.education.dao;

import com.education.model.StaffRegistration_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRegDao extends JpaRepository<StaffRegistration_Entity, String> {

    Optional<StaffRegistration_Entity> findByFldStaffId(String staffId);
}
