package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Direccion;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.RepositorioDirecciones;
import com.example.demo.repositories.RepositorioUsuarios;

@Service
public class Services {

	@Autowired //No es una instancia
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioDirecciones repoDir;
	
	public List<Usuario> todosUsuarios(){
		return repoUsuarios.findAll();
	}
	
	public Usuario guardarUsuario(Usuario newUser) {
		return repoUsuarios.save(newUser);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void deleteUsuario(Long id) {
		repoUsuarios.deleteById(id); //It doesn't matter if id isn't valid
	}

	public List<Usuario> findByName(String word){
		return repoUsuarios.findByNameContaining(word);
	}
	
	public List<Usuario> top10(){
		return repoUsuarios.findTop10ByOrderByNameAsc();
	}
	
	public Direccion guardarDireccion(Direccion nuevaDireccion) {
		return repoDir.save(nuevaDireccion);
	}
	
	public List<Usuario> usuariosSinDireccion(){
		return repoUsuarios.findByDireccionIdIsNull();
	}
}
