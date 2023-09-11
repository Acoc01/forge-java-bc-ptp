package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Respuesta;

@Repository
public interface RepositorioRespuestas extends CrudRepository<Respuesta,Long>{

}
