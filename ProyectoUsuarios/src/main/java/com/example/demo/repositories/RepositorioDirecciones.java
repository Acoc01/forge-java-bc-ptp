package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Direccion;

@Repository
public interface RepositorioDirecciones extends CrudRepository<Direccion,Long>{
	
	List<Direccion> findAll();
}
