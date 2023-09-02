package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Salon;

@Repository
public interface RepositorioSalones extends CrudRepository<Salon,Long>{

	List<Salon> findAll();
}
