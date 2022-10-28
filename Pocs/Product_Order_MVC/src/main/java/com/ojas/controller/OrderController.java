package com.ojas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ojas.model.OrderModel;
import com.ojas.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderServ;
	
	@GetMapping("/addOrder")
	public String addOrder(@ModelAttribute OrderModel order, Model m) {
		
		System.out.println("Controller");
		orderServ.addOrder(order);
		m.addAttribute("info",orderServ.getOrderList());
		
		return "viewOrders";
	}
	
	@GetMapping("/orders")
	public String getOrderList(Model m){
		
		m.addAttribute("info",orderServ.getOrderList());
		
		return "viewOrders";
	}
	
}
