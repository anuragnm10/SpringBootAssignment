package com.gl.MagicOfBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.MagicOfBook.database.UserBookRepo;
import com.gl.MagicOfBook.entity.UserBook;

@Service
public class UserBookService {
	
	@Autowired
	private UserBookRepo userbookRepo;
	
	public void insertUserBook(UserBook userbook) throws Exception{
		try{
			userbookRepo.save(userbook);
		} catch( Exception e) {
			throw new Exception("Failed to add to read later");
		}
	}
	
	public List<UserBook> getReadLaterBooks(int userid){
		List<UserBook> readlaterBooks = userbookRepo.findByReadlater(userid);
		return readlaterBooks;
	}
	
	public List<UserBook> getLikedBooks(int userid){
		List<UserBook> likedBooks = userbookRepo.findByLiked(userid);
		return likedBooks;
	}
	
	public void delete(int ubid) {
		userbookRepo.deleteById(ubid);
	}
}
