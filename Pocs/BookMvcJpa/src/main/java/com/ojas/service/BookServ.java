package com.ojas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.BookDao;
import com.ojas.entity.BookEntity;
import com.ojas.model.Book;

@Service
public class BookServ implements BookInterface {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book addBook(Book book) {
		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);
		
		bookDao.save(bookEntity);
		
		return book;
	}

	@Override
	public List<Book> viewBooks() {
		List<BookEntity> li = bookDao.findAll();
		List<Book> bookList = new ArrayList<>();
		
		for(BookEntity bt : li) {
			Book b = new Book();
			BeanUtils.copyProperties(bt, b);
			bookList.add(b);
		}
		
		return bookList;
	}

	@Override
	public void deleteBook(int id) {
		
		bookDao.deleteById(id);

	}

	@Override
	public Book updateBook(int id, Book book) {
		Book b = new Book();
		BookEntity be = getBook(id);
		be.setBook_name(book.getBook_name());
		be.setAuthor_name(book.getAuthor_name());
		be.setBook_price(book.getBook_price());
		
		bookDao.save(be);
		
		BeanUtils.copyProperties(be, b);
		
		return b;
	}

	@Override
	public BookEntity getBook(int id) {
		BookEntity be = bookDao.findById(id).get();
		
		return be;
	}

}
