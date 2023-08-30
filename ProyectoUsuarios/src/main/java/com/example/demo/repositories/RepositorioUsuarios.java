package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {

	List<Usuario> findAll();
	Usuario save(Usuario nuevoUsuario);
	//Dynamic Query
	List<Usuario> findByEmail(String email);
	List<Usuario> findByName(String nombre);
	List<Usuario> findByNameStartingWith(String letras);
	List<Usuario> findByNameContaining(String word);
	List<Usuario> findTop10ByOrderByNameAsc();
	List<Usuario> findByDireccionIdIsNull();
}
