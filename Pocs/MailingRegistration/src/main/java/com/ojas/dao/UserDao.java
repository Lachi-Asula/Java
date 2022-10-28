package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {

}
