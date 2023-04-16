package com.gl.MagicOfBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.MagicOfBook.entity.Admin;
import com.gl.MagicOfBook.entity.User;
import com.gl.MagicOfBook.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userservice;
	
	@GetMapping("/adminregister")
	public String aRegisterPage() {
		return "adregister";
	}
	@GetMapping("/userregister")
	public String uRegisterPage() {
		return "usregister";
	}
	
	@PostMapping("/userregister")
	public String uRegister(User user) {
		try {
			userservice.insertUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:login";
	}
	
	@PostMapping("/adminregister")
	public String aRegister(Admin admin) {
		try {
			userservice.insertAdmin(admin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "redirect:login";
	}
}
