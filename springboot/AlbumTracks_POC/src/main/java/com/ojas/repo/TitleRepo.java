package com.ojas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.TitleMaster;

@Repository
public interface TitleRepo extends JpaRepository<TitleMaster, Integer> {

}
