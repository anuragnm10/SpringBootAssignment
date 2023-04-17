package com.gl.MagicOfBook.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gl.MagicOfBook.entity.UserBook;

public interface UserBookRepo extends CrudRepository<UserBook, Integer>{

	@Query(value = "SELECT * FROM user_book WHERE user_id = ?1 and read_later=true", nativeQuery = true)
    List<UserBook> findByReadlater(Integer userid);
	
	@Query(value = "SELECT * FROM user_book WHERE user_id = ?1 and liked=true", nativeQuery = true)
    List<UserBook> findByLiked(Integer userid);
	
}
