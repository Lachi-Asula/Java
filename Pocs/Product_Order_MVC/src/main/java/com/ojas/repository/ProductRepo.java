package com.ojas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	@Query("select productname from Product")
	public List<String> getProductNames();
	
	@Query("select productprice from Product where productname=:pname")
	public double fingByProductname(String pname);
}
