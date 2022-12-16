package com.friends.dao;

import com.friends.model.Batch_CSE402_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Batch_CSE402_Dao extends JpaRepository<Batch_CSE402_Entity, Integer> {
    @Query(value = "SELECT FLD_CREATED_DATE from( SELECT FLD_CREATED_DATE from TBL_AUDIT_CSE402 Order by FLD_CREATED_DATE desc) where ROWNUM < 2", nativeQuery = true)
    Optional<String> getTimeStampValueFromDb();
}
