package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

}
