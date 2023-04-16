package com.gl.MagicOfBook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String bookname;
	private String genre;
	private String author;
	private String publication;
	private double price;
	
}
