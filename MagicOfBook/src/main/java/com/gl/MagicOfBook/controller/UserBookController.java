package com.gl.MagicOfBook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gl.MagicOfBook.entity.User;
import com.gl.MagicOfBook.entity.UserBook;
import com.gl.MagicOfBook.service.BookService;
import com.gl.MagicOfBook.service.UserBookService;

@Controller
public class UserBookController {

	@Autowired
	private BookService bookservice;
	@Autowired
	private UserBookService userbookservice;
	
	@GetMapping("rdltr")
	public String readlater(Map<String, List<UserBook>> map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserBook> userbook = userbookservice.getReadLaterBooks(user.getUserid());
		map.put("userbook", userbook);
		return "rdlater";
	}
	
	@GetMapping("like")
	public String liked(Map<String, List<UserBook>> map, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<UserBook> userbook = userbookservice.getLikedBooks(user.getUserid());
		map.put("userbook", userbook);
		return "liked";
	}
	
	@GetMapping("/removelike/{userbookid}")
	public String removeLiked(@PathVariable int userbookid) {
		userbookservice.delete(userbookid);
		return "redirect:/like";
	}
	
	@GetMapping("/removereadlater/{userbookid}")
	public String removeReadlater(@PathVariable int userbookid) {
		userbookservice.delete(userbookid);
		return "redirect:/rdltr";
	}
	
	
	
}
