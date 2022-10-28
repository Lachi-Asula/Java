package com.book.service;

import java.util.List;

import com.book.model.Book_Model;

public interface BookServ_Interface {
	
	Book_Model addBook(Book_Model book);
	List<Book_Model> bookList();
	void deleteBook(int id);
	Book_Model updateBook(int id, Book_Model book);
	Book_Model getBook(int id);
	boolean validateBook(String bookname, String authorname);
}
