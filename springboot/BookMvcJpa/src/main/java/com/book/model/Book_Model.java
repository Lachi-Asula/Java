package com.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book_Model {
	
	private int book_id;
	private String book_name;
	private String book_author;
	private double book_price;
}
