package com.friends.dao;

import com.friends.model.Batch_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Batch_Info_Dao extends JpaRepository<Batch_Info_Entity, Integer> {

    @Query("select fldBatchName from Batch_Info_Entity")
    Optional<List<String>> getAllBatchesNames();
}
