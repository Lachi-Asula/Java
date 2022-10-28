package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.bean.Student;

@Repository
public interface StudDao extends JpaRepository<Student, Integer> {


}
