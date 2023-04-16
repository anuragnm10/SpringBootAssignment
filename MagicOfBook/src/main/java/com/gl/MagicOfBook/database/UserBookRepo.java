package com.gl.MagicOfBook.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.gl.MagicOfBook.entity.UserBook;

public interface UserBookRepo extends CrudRepository<UserBook, Integer>{

	@Query(value = "SELECT * FROM user_book WHERE user_id = ?1 and readLater=true", nativeQuery = true)
    UserBook findByReadlater(Integer userid);
	
	@Query(value = "SELECT * FROM user_book WHERE user_id = ?1 and liked=true", nativeQuery = true)
    UserBook findByLiked(Integer userid);
	
}
