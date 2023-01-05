package com.education.dao;

import com.education.model.AllSubjects_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllSubjectsDao extends JpaRepository<AllSubjects_Entity, Integer> {

    @Query("select fldSubject from AllSubjects_Entity")
    List<String> getAllSubjects();
}
