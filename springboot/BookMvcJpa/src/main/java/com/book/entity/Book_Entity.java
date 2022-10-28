package com.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="book")
public class Book_Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="BOOK_ID")
	private int book_id;
	
	@Column(name="BOOK_NAME")
	private String book_name;
	
	@Column(name="BOOK_AUTHOR")
	private String book_author;
	
	@Column(name="BOOK_PRICE")
	private double book_price;
}
