package com.gl.MagicOfBook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.MagicOfBook.entity.Admin;
import com.gl.MagicOfBook.entity.User;
import com.gl.MagicOfBook.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userservice;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/loginpage")
	public String loginPost(@RequestParam String email, @RequestParam String password, HttpSession session) {
		try {
			User user = userservice.getUserbyEmail(email);
			Admin admin = userservice.getAdminbyEmail(email);
			if(admin != null) {
				if(userservice.validateForAdmin(admin, password)) {
					session.setAttribute("admin", admin);
					return "redirect:admindash";
				}else {
					return "login";
				}
			}else {
				if(userservice.validateForUser(user, password)) {
					session.setAttribute("user", user);
					return "redirect:userdash";
				}else {
					return "login";
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "login";
	}
}
