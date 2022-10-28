package com.ojas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.ProductEntity;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Integer> {

}
