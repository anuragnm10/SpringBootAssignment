package com.gl.MagicOfBook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.MagicOfBook.database.BookRepo;
import com.gl.MagicOfBook.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public void insertBook(Book book) {
		bookRepo.save(book);
	}

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		bookRepo.findAll().forEach(books::add);
		return books;
	}

	public Book getBook(int bookid) {
		Book book = bookRepo.findById(bookid);
		return book;
	}

	public boolean deleteById(int id) {
		if (bookRepo.existsById(id)) {
			bookRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public void updateBook(Book book) {
		bookRepo.save(book);
	}

	public List<Book> getBook(String query, String category) {
		List<Book> books = new ArrayList<>();
		if (category.equals("author")) {
			books = bookRepo.findByAuthor(query);
		} else if (category.equals("booktitle")) {
			books = bookRepo.findByBookname(query);
		} else if (category.equals("publication")) {
			books = bookRepo.findByPublication(query);
		} else if (category.equals("id")) {
			Book book = bookRepo.findById(Integer.parseInt(query));
			books.add(book);
		} else if (category.equals("price")) {
			books = bookRepo.findByPrice(Double.parseDouble(query));
		}

		return books;
	}
}
