package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Hobby;

@Repository
public interface RepositorioHobbies extends CrudRepository<Hobby,Long>{
	List<Hobby> findAll();
}
