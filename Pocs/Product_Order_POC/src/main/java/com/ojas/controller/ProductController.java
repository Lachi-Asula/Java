package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.model.ProductModel;
import com.ojas.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productServ;
	
	@GetMapping("/wel")
	public String welcome() {
		
		return "Welcome to Product_Order Application";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody ProductModel product) {
		productServ.addProduct(product);
		
		return "Product Added Successfully";
	}
	
	@GetMapping("/getProduct/{id}")
	public ProductModel getProduct(@PathVariable int id) {
		
		return productServ.getProduct(id);
	}
	
	@GetMapping("/products")
	public List<ProductModel> getProductList(){
		
		return productServ.getProducts();
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id) {
		
		return productServ.deleteProduct(id);
	}
}
