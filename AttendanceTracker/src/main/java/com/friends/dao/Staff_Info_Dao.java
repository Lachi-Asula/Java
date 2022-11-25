package com.friends.dao;

import com.friends.model.Staff_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Staff_Info_Dao extends JpaRepository<Staff_Info_Entity, String> {
    Optional<Staff_Info_Entity> findByFldEmpIdAndFldPassword(String empId, String password);

    Optional<Staff_Info_Entity> findByFldEmpId(String empId);
}
