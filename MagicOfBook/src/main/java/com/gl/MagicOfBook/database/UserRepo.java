package com.gl.MagicOfBook.database;

import org.springframework.data.repository.CrudRepository;

import com.gl.MagicOfBook.entity.User;

public interface UserRepo extends CrudRepository<User, Integer>{
	
	User findByEmail(String email);
}
