package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.Order;
import com.ojas.entity.Product;
import com.ojas.model.OrderModel;
import com.ojas.model.ProductModel;
import com.ojas.repository.OrderRepo;
import com.ojas.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public ProductModel addProduct(ProductModel product) {
		
		Product prod = new Product();
		
		BeanUtils.copyProperties(product, prod);
		prod = productRepo.save(prod);
		
		BeanUtils.copyProperties(prod, product);
		
		return product;
		
	}
	
	public List<ProductModel> getProducts(){
		List<Product> li = productRepo.findAll();
		List<ProductModel> pmList = new ArrayList<>();
		for(Product p : li) {
			ProductModel pm = new ProductModel();
			BeanUtils.copyProperties(p, pm);
			
			pmList.add(pm);
		}
		
		return pmList;
	}
	
	public ProductModel getProduct(int id) {
		Product prod = productRepo.findById(id).get();
		ProductModel pd = new ProductModel();
		
		BeanUtils.copyProperties(prod, pd);
		
		return pd;
	}
	
	public String deleteProduct(int id) {
		productRepo.deleteById(id);
		
		return "Deleted Successfully";
	}
	
	public List<String> getPnames(){
		
		return productRepo.getProductNames();
	}
}
