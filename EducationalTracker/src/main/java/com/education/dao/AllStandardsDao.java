package com.education.dao;

import com.education.model.AllStandards_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllStandardsDao extends JpaRepository<AllStandards_Entity, Integer> {

    @Query("select fldStandard from AllStandards_Entity")
    List<String> getAllStandards();
}
