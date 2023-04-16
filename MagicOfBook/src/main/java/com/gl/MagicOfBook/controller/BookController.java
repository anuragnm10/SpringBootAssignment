package com.gl.MagicOfBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.MagicOfBook.database.BookRepo;
import com.gl.MagicOfBook.entity.Book;

@Controller
public class BookController {

	@Autowired
	private BookRepo bookRepo;
	
	@GetMapping("remove/{id}")
	public String removeBook(@PathVariable int id) {
		bookRepo.deleteById(id);
		return "redirect:/admindash";
	}
	
	@GetMapping("insertbook")
	public String addbookpage() {
		return "addbook";
	}
	
	@PostMapping("add")
	public String addBook(Book book) {
		bookRepo.save(book);
		return "redirect:/admindash";
	}
	
}
