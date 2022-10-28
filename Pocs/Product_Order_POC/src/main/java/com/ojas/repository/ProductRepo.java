package com.ojas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

//	@Query("from Product where productId=:id")
//	public List<Product> findByProductId(int id);
}
