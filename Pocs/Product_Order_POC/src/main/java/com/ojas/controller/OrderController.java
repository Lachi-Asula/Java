package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.entity.Order;
import com.ojas.model.OrderModel;
import com.ojas.model.ProductModel;
import com.ojas.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderServ;
	
	@PostMapping("/addOrder")
	public String addOrder(@RequestBody OrderModel order) {
		
		return orderServ.addOrder(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getOrderList(){
		
		return orderServ.getOrderList();
	}
	
	@GetMapping("/getOrder/{id}")
	public OrderModel getOrder(@PathVariable int id) {
		
		return orderServ.getOrder(id);
	}
	
	@GetMapping("/deleteOrder/{id}")
	public String deleteOrder(@PathVariable int id) {
	
		return orderServ.deleteOrder(id);
	}
	
}
