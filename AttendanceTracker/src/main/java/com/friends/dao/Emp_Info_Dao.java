package com.friends.dao;

import com.friends.model.Emp_Info_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emp_Info_Dao extends JpaRepository<Emp_Info_Entity, Integer> {

}
