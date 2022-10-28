package com.ojas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

	private int orderid;
	private String productname;
	private int quantity;
	private double totalamount;
	
}
