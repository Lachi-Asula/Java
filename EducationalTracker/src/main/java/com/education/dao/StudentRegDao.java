package com.education.dao;

import com.education.model.StudentRegistration_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRegDao extends JpaRepository<StudentRegistration_Entity, Integer> {

    @Query(value = "select STUDENTIDVAL.nextval from dual", nativeQuery = true)
    int getIdVal();

    @Query(value = "select STUDENTID.nextval from dual", nativeQuery = true)
    int getStudentIdVal();

    Optional<StudentRegistration_Entity> findByFldStudentId(String userId);

    List<StudentRegistration_Entity> findByFldStandard(String standard);

    Optional<StudentRegistration_Entity> findByFldFullNameAndFldFatherNameAndFldMotherName(String userName, String fatherName, String motherName);
}
