package com.ojas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private int book_id;
	private String book_name;
	private String author_name;
	private double book_price;
}
