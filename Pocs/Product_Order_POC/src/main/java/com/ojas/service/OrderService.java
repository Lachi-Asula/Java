package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.Order;
import com.ojas.entity.Product;
import com.ojas.model.OrderModel;
import com.ojas.repository.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	public String addOrder(OrderModel order) {
		List<Product> pros = order.getProducts();
	//	pros.forEach(System.out::println);
		
		int quant = order.getQuantity();
		double tAmount = 0;
		
		for(Product p : pros) {
			tAmount += p.getProductprice();
		}
		
		tAmount *= quant;
		
		order.setTotalamount(tAmount);
		
		Order ord = new Order();
		BeanUtils.copyProperties(order, ord);
		
		orderRepo.save(ord);
		
		return "Order Added Successfully";
	}
	
	public List<Order> getOrderList(){
		List<Order> li = orderRepo.findAll();
		
		return li;
	}
	
	public OrderModel getOrder(int id) {
		Order od = orderRepo.findById(id).get();
		//List<Product> list = new ArrayList<Product>();
		
		OrderModel om = new OrderModel();
		
		BeanUtils.copyProperties(od, om);
		
		return om;
	}
	
	public String deleteOrder(int id) {
		orderRepo.deleteById(id);
		
		return "Order Deleted Successfully";
	}
}
