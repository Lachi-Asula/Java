package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.ProductEntity;
import com.ojas.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome To Spring Boot Application";
	}
	
	@PostMapping("/add")
	public ProductEntity addProduct(@RequestBody ProductEntity product) {
		return productServ.addProduct(product);
	}
	
	@GetMapping("/list")
	public List<ProductEntity> getList(){
		return productServ.getList();
	}
	
	@GetMapping("/getProduct/{id}")
	public ProductEntity getProduct(@PathVariable int id) {
		return productServ.getProduct(id);
	}
	
	
}
