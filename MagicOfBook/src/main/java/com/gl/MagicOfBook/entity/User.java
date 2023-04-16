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
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String name;
	private String email;
	private String password;
	
}
