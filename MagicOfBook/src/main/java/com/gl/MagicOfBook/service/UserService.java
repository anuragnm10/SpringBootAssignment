package com.gl.MagicOfBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.MagicOfBook.database.AdminRepo;
import com.gl.MagicOfBook.database.UserRepo;
import com.gl.MagicOfBook.entity.Admin;
import com.gl.MagicOfBook.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	public User getUserbyEmail(String email) throws Exception{
		try {
			User user = userRepo.findByEmail(email);
			return user;
		} catch(Exception e) {
			throw new Exception("Invalid credentials!");
		}
	}
	public Admin getAdminbyEmail(String email) throws Exception{
		try {
			Admin admin = adminRepo.findByEmail(email);
			return admin;
		} catch(Exception e) {
			throw new Exception("Invalid credentials!");
		}
	}
	
	public void insertUser(User user) throws Exception {
		try {
			userRepo.save(user);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void insertAdmin(Admin admin) throws Exception {
		try {
			adminRepo.save(admin);
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public boolean validateForAdmin(Admin admin, String password) throws Exception {
		
		try {
			if(admin.getPassword().equals(password)) {
				return true;
			}
		}catch(Exception e){
			throw new Exception("Invalid credentials!");
		}
		
		return false;
	}
		
public boolean validateForUser(User user, String password) throws Exception {
		
		try {
			if(user.getPassword().equals(password)) {
				return true;
			}
		}catch(Exception e){
			throw new Exception("Invalid credentials!");
		}
		
		return false;
	}
}
