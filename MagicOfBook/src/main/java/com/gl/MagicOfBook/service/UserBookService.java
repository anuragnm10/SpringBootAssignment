package com.gl.MagicOfBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.MagicOfBook.database.UserBookRepo;

@Service
public class UserBookService {
	
	@Autowired
	private UserBookRepo userbookRepo;
	
	
	
}
