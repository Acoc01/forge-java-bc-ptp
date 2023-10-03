package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Mensaje;

@Repository
public interface RepositorioMensajes extends CrudRepository<Mensaje, Long> {

}
