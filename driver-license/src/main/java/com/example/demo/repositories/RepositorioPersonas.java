package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Persona;

@Repository
public interface RepositorioPersonas extends CrudRepository<Persona,Long>{
	List<Persona> findAll();
	List<Persona> findByLicenciaIdIsNull();
}
