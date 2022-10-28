package com.ojas.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
