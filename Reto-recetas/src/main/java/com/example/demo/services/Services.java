package com.example.demo.services; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Receta;
import com.example.demo.repositories.RepoReceta;

@Service
public class Services {
	@Autowired
	private RepoReceta repoReceta;
	
	public List<Receta> todasRecetas(){
		return repoReceta.findAll();
	}
	
	public Receta guardarReceta(Receta newReceto) {
		return repoReceta.save(newReceto);
	}
	
	public Receta buscarReceta(Long id) {
		return repoReceta.findById(id).orElse(null);
	}
}
