package com.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.Book_Dao;
import com.book.entity.Book_Entity;
import com.book.model.Book_Model;

@Service
public class Book_Service implements BookServ_Interface {

	@Autowired
	private Book_Dao bookDao;

	@Override
	public Book_Model addBook(Book_Model book) {
		Book_Entity be = new Book_Entity();
		BeanUtils.copyProperties(book, be);
		
		bookDao.save(be);
		
		return book;
	}

	@Override
	public List<Book_Model> bookList() {
		List<Book_Entity> li = bookDao.findAll();
		List<Book_Model> bmList = new ArrayList<>();
		
		for(Book_Entity bk : li) {
			Book_Model bm = new Book_Model();
			BeanUtils.copyProperties(bk, bm);
			
			bmList.add(bm);
		}
		
		return bmList;
	}

	@Override
	public void deleteBook(int id) {
		
		bookDao.deleteById(id);
	}

	@Override
	public Book_Model updateBook(int id, Book_Model book) {
		Book_Model bm = getBook(id);
		bm.setBook_name(book.getBook_name());
		bm.setBook_author(book.getBook_author());
		bm.setBook_price(book.getBook_price());
		
		Book_Entity be = new Book_Entity();
		
		BeanUtils.copyProperties(bm, be);
		bookDao.save(be);
		
		return bm;
	}

	@Override
	public Book_Model getBook(int id) {
		Book_Entity be = bookDao.getById(id);
		Book_Model bm = new Book_Model();
		
		BeanUtils.copyProperties(be, bm);
		
		return bm;
	}

	@Override
	public boolean validateBook(String bookname, String authorname) {
		String id = bookDao.getBook_id(bookname, authorname);

		if(id != null) {
			System.out.println("id: " + id);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
