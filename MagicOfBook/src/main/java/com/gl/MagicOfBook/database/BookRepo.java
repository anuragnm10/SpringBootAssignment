package com.gl.MagicOfBook.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gl.MagicOfBook.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer>{
	
	Book findById(int id);
	List<Book> findByAuthor(String author);
	List<Book> findByBookname(String bookname);
	List<Book> findByPublication(String publication);
	
	@Query(value = "Select * from book where price<=?1", nativeQuery = true)
	List<Book> findByPrice(double price);
	
	@Query(value = "Select * from book order by price", nativeQuery = true)
	List<Book> findByPriceSorted();

}
