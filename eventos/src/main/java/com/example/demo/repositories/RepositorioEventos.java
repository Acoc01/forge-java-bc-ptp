package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Evento;

@Repository
public interface RepositorioEventos extends CrudRepository<Evento, Long>	{

	List<Evento> findByEstado(String estado);
	
	List<Evento> findByEstadoIsNot(String estado);
}
