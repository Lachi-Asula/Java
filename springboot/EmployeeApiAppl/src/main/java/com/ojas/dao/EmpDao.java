package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.Employee;

@Repository
public interface EmpDao extends JpaRepository<Employee, Integer>{

}
