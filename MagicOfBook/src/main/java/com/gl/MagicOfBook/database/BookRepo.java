package com.gl.MagicOfBook.database;

import org.springframework.data.repository.CrudRepository;

import com.gl.MagicOfBook.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{
	
	Book findById(int id);

}
