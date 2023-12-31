package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long>{
	User findByEmail(String email);
}
