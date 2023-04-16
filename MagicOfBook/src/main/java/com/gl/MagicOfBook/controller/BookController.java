package com.gl.MagicOfBook.controller;

import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.MagicOfBook.entity.Book;
import com.gl.MagicOfBook.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("remove/{id}")
	public String removeBook(@PathVariable int id) {
		bookService.deleteById(id);
		return "redirect:/admindash";
	}
	
	@GetMapping("insertbook")
	public String addbookpage() {
		return "addbook";
	}
	
	@PostMapping("add")
	public String addBook(Book book) {
		bookService.insertBook(book);
		return "redirect:/admindash";
	}
	
	@GetMapping("edit/{bookid}")
	public String editbookpage(@PathVariable int bookid, Map<String, Book> map) {
		try {
			Book book = bookService.getBook(bookid);
			map.put("book", book);
		}catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return "editbook";
	}
	
	@PostMapping("edit/updatedtask")
	public String updateTask(Book book) {
		bookService.updateBook(book);
		return "redirect:/admindash";
	}
	
	@GetMapping("edit/logout")
	public String homepg() {
		return "redirect:/admindash/logout";
	}
}
