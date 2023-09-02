package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Licencia;

@Repository
public interface RepositorioLicencias extends CrudRepository<Licencia,Long>{

}
