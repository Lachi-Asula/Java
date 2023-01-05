package com.education.dao;

import com.education.model.Standard_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardDao extends JpaRepository<Standard_Entity, Integer> {
    @Query(value = "select STANDARDIDVAL.nextval from dual", nativeQuery = true)
    int getStandardIdVal();
}
