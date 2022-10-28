package com.ojas.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ojas.entity.BookEntity;
import com.ojas.model.Book;
import com.ojas.service.BookServ;

@Controller
public class BookController {
	
	static int temp = 0;
	
	@Autowired
	private BookServ bookServ;
	
	@RequestMapping("/")
	public String welcome() {
		
		return "welcome";
	}
	
	@GetMapping("/reg")
	private String bookReg(Model m) {
		m.addAttribute("book", new Book());
		
		return "registration";
	}
	
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute Book book, Model m) {
		Book b = bookServ.addBook(book);		
		
		List<Book> li = bookServ.viewBooks();
		m.addAttribute("list", li);
		
		return "viewBooks";
	}
	
	@GetMapping("/list")
	public String getBookList(Model m) {
	
		List<Book> li = bookServ.viewBooks();
		m.addAttribute("list", li);
		
		return "viewBooks";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editBook(@PathVariable int id, Model m) {
		temp = id;
		
		BookEntity be = bookServ.getBook(id); 
		Book book = new Book();
		BeanUtils.copyProperties(be, book);
		
		m.addAttribute("book", book);
		
		return "editBook";
	}
	
	@PostMapping("/BookMvcJpa/update")
	public String updateBook(@ModelAttribute Book book, Model m) {
		Book b = bookServ.updateBook(temp, book);
		
		List<Book> li = bookServ.viewBooks();
		m.addAttribute("list", li);
		
		return "viewBooks";
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteBook(@PathVariable int id, Model m) {
		bookServ.deleteBook(id);
		List<Book> li = bookServ.viewBooks();
		m.addAttribute("list", li);
		
		return "viewBooks";
	}
	
	@GetMapping("/getBook/{id}")
	public String getBook(@PathVariable int id) {
		BookEntity book = bookServ.getBook(id);
		
		return "success";
	}
}
