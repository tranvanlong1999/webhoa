package com.shopmilk.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopmilk.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
	@Query(nativeQuery = true, value = "select * from user where mail = ?1")
	User findUserByEmail(String email);
}
