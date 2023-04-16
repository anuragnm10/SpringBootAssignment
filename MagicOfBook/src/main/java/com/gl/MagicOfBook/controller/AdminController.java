package com.gl.MagicOfBook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.MagicOfBook.entity.Book;
import com.gl.MagicOfBook.service.BookService;

@Controller
@RequestMapping("/admindash")
public class AdminController {

	@Autowired
	private BookService bookservice;
	
	@GetMapping()
	public String homepageBooks(Map<String, List<Book>> map) {
		List<Book> books = bookservice.getAllBooks();
		map.put("books", books);
		return "admindashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		session.invalidate();
		return "redirect:/login";
	}
	
}
