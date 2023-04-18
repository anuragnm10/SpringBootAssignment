package com.gl.MagicOfBook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.MagicOfBook.entity.Book;
import com.gl.MagicOfBook.entity.User;
import com.gl.MagicOfBook.entity.UserBook;
import com.gl.MagicOfBook.service.BookService;
import com.gl.MagicOfBook.service.UserBookService;

@Controller
public class UserController {
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	private UserBookService userbookservice;

	@GetMapping("/userdash")
	public String userpageBooks(Map<String, List<Book>> map, HttpSession session) {
		List<Book> books = bookservice.getAllBooks();
		map.put("books", books);
		return "userdashboard";
	}
	
	@GetMapping("userdash/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("admin");
		session.invalidate();
		return "redirect:/login";
	}
	
	@GetMapping("userdash/readlater/{bookid}")
	public String addToReadlater(@PathVariable int bookid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookservice.getBook(bookid);
		boolean readlater = true;
		UserBook userbook = new UserBook();
		userbook.setUser(user);
		userbook.setBook(book);
		userbook.setReadLater(readlater);
		try {
			userbookservice.insertUserBook(userbook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/rdltr";
	}
	
	
	@GetMapping("userdash/liked/{bookid}")
	public String addTolikedbook(@PathVariable int bookid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookservice.getBook(bookid);
		boolean readlater = true;
		UserBook userbook = new UserBook();
		userbook.setUser(user);
		userbook.setBook(book);
		userbook.setLiked(readlater);
		try {
			userbookservice.insertUserBook(userbook);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/like";
	}
	
	@GetMapping("search")
	public String search(@RequestParam("query") String query, @RequestParam("category") String category, Map<String, List<Book>> map) {
	    List<Book> books = bookservice.getBook(query, category);
	    map.put("books", books);
	    return "userdashboard";
	 }
}
