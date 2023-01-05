package com.education.dao;

import com.education.model.Subject_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject_Entity, Integer> {

    @Query(value = "select SUBJECTIDVAL.nextval from dual", nativeQuery = true)
    int getSubjectIdVal();
}
