package com.ojas.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.Order;
import com.ojas.model.OrderModel;
import com.ojas.repository.OrderRepo;
import com.ojas.repository.ProductRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	@Autowired
	private  ProductRepo prodRepo;
	
	public String addOrder(OrderModel order) {
		double price = prodRepo.fingByProductname(order.getProductname());
		price *= order.getQuantity();
		order.setTotalamount(price);
		
		Order ord = new Order();
		BeanUtils.copyProperties(order, ord);
		
		orderRepo.save(ord);
		
		return "Order Added Successfully";
	}
	
	public List<Order> getOrderList(){
		List<Order> li = orderRepo.findAll();
		
		return li;
	}
}
