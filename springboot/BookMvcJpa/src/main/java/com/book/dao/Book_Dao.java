package com.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.entity.Book_Entity;

@Repository
public interface Book_Dao extends JpaRepository<Book_Entity, Integer> {

	@Query("select book_id from Book_Entity where book_name=:bookname and book_author=:authorname")
	public String getBook_id(String bookname, String authorname);
	
	// public Book_Entity findByBook_NameAndBook_Author(String book_name, String book_author);
}
