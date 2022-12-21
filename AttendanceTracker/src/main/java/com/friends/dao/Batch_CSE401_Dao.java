package com.friends.dao;

import com.friends.model.Batch_CSE401_Entity;
import com.friends.model.Batch_MCA201_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Batch_CSE401_Dao extends JpaRepository<Batch_CSE401_Entity, Integer> {
    @Query(value = "SELECT FLD_CREATED_DATE from( SELECT FLD_CREATED_DATE from TBL_AUDIT_CSE401 Order by FLD_CREATED_DATE desc) where ROWNUM < 2", nativeQuery = true)
    Optional<String> getTimeStampValueFromDb();

    Optional<List<Batch_CSE401_Entity>> findByFldEmpIdAndFldYearAndFldMonthAndFldStatus(String empId, String year, String month, String status);
}
