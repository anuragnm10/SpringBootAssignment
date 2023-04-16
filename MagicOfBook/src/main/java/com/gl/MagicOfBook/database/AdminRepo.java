package com.gl.MagicOfBook.database;

import org.springframework.data.repository.CrudRepository;

import com.gl.MagicOfBook.entity.Admin;

public interface AdminRepo extends CrudRepository<Admin, Integer>{

	Admin findByEmail(String email);
	
}
