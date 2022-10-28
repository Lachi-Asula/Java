package com.ojas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.ProductDao;
import com.ojas.exceptions.ProductNotFoundException;
import com.ojas.model.ProductEntity;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public ProductEntity addProduct(ProductEntity product) {
		
		return productDao.save(product);
	}
	
	public List<ProductEntity> getList(){
		
		return productDao.findAll();
	}
	
	public ProductEntity getProduct(int id) {
		ProductEntity product;
		try {
			product =  productDao.findById(id).get();
		}
		catch(Exception e) {
			throw new ProductNotFoundException("Product Not Found");
		}
		
		return product;
	}
}
