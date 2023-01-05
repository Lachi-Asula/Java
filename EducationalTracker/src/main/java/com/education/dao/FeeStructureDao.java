package com.education.dao;

import com.education.model.FeeStructure_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface FeeStructureDao extends JpaRepository<FeeStructure_Entity, Integer> {

    @Transactional
    @Modifying
    @Query("update FeeStructure_Entity set fldFeeAmount =:feeAmount where fldStandard =:standard")
    void updateFeeStructure(String standard, double feeAmount);
}
