package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Etiqueta;

@Repository
public interface RepositorioEtiquetas extends CrudRepository<Etiqueta,Long>{
	
	List<Etiqueta> findAll();
	
	Etiqueta findByTema(String tema);
}
