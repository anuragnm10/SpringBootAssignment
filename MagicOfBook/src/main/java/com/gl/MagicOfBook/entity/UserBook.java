package com.gl.MagicOfBook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_book")
public class UserBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "userid")
	private User user;
	
	@OneToOne
	@JoinColumn(name="book_id", referencedColumnName = "id")
	private Book book;
	
	@Column(name="read_later")
	private boolean readLater;
	private boolean liked;
}
