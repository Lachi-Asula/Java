package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ojas.model.ProductModel;
import com.ojas.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productServ;
	
	@GetMapping("/productPage")
	public String welcome(Model m) {
		m.addAttribute("prod", new ProductModel());
		return "products";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("prod") ProductModel product, Model m) {
		productServ.addProduct(product);
		m.addAttribute("info",productServ.getProducts());
		return "viewProducts";
	}
	
	@GetMapping("/makeOrder")
	public String productNames(Model m) {
		List<String> li = productServ.getPnames();
		m.addAttribute("products", li);
		
		return "order";
	}
	
	@GetMapping("/products")
	public String getProductList(Model m){
		
		m.addAttribute("info",productServ.getProducts());
		
		return "viewProducts";
	}

}
