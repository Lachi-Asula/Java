package com.education.dao;

import com.education.model.StudentRegistration_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRegDao extends JpaRepository<StudentRegistration_Entity, Integer> {
}
