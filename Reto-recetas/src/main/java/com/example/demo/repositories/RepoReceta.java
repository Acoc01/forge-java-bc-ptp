package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Receta;

@Repository
public interface RepoReceta extends CrudRepository<Receta, Long>{
	//Obtener todas las recetas
	List<Receta> findAll();
	//Guardar una receta para crearla
	Receta save(Receta nuevaReceta);
}
