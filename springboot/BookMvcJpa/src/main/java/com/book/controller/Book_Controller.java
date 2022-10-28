package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.model.Book_Model;
import com.book.service.Book_Service;

@Controller
public class Book_Controller {

	static int temp = 0;
	
	@Autowired
	private Book_Service bookServ;
	
	@GetMapping("/")
	@ResponseBody
	public String welcome() {
		
		return "welcome";
	}
	
	@GetMapping("/reg")
	public String bookReg(Model m) {
		m.addAttribute("book", new Book_Model());
		
		return "BookReg";
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@PostMapping("/validate")
	public String validateBook(@RequestParam String bookname, @RequestParam String authorname,Model m) {
		String res = "";
		if(bookServ.validateBook(bookname, authorname)) {
			List<Book_Model> books = bookServ.bookList();
			m.addAttribute("books", books);
			res = "viewbooks";
		}
		else {
			m.addAttribute("err","Incorrect Detailes");
			res = "login";
		}
		
		return res;
	}
	
	@PostMapping("/addBook")
	public String addBook(@ModelAttribute Book_Model book) {
		Book_Model b = bookServ.addBook(book);
		
		return "success";
	}
	
	@GetMapping("/viewBooks")
	public String viewBooks(Model m) {
		List<Book_Model> books = bookServ.bookList();
		m.addAttribute("books", books);
		
		return "viewbooks";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable int id, Model m) {
		bookServ.deleteBook(id);
		
		List<Book_Model> books = bookServ.bookList();
		m.addAttribute("books", books);
		
		return "viewbooks";
	}
	
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable int id, Model m) {
		Book_Model bm = bookServ.getBook(id);
		m.addAttribute("book", bm);
		temp = id;
		return "editupdate";
	}
	
	@PostMapping("/BookMvcJpa/updateBook")
	public String updateBook(@ModelAttribute Book_Model book, Model m) {
		bookServ.updateBook(temp, book);
		
		List<Book_Model> books = bookServ.bookList();
		m.addAttribute("books", books);
		
		return "viewbooks";
	}
}
