package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long>{

	Usuario findByEmail(String email);
}
