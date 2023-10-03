package com.codingdojo.catalina.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.catalina.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario,Long>{
	Usuario findByEmail(String email);
	List<Usuario> findAll();
}
