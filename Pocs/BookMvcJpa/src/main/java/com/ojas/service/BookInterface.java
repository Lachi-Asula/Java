package com.ojas.service;

import java.util.List;

import com.ojas.entity.BookEntity;
import com.ojas.model.Book;

public interface BookInterface {

	Book addBook(Book book);
	List<Book> viewBooks();
	void deleteBook(int id);
	Book updateBook(int id, Book book);
	BookEntity getBook(int id);
}
