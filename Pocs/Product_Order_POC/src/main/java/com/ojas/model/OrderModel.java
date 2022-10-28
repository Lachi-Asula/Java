package com.ojas.model;

import java.util.List;

import com.ojas.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

	private int orderid;
	private List<Product> products;
	private int quantity;
	private double totalamount;
	
}
