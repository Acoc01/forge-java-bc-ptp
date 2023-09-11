package com.example.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Etiqueta;
import com.example.demo.models.Pregunta;
import com.example.demo.models.Respuesta;
import com.example.demo.repositories.RepositorioEtiquetas;
import com.example.demo.repositories.RepositorioPreguntas;
import com.example.demo.repositories.RepositorioRespuestas;

@Service
public class Servicios {

	@Autowired
	private RepositorioPreguntas repoPreguntas;
	
	@Autowired
	private RepositorioRespuestas repoRespuestas;
	
	@Autowired
	private RepositorioEtiquetas repoEtiquetas;
	
	public List<Pregunta> todasPreguntas(){
		return repoPreguntas.findAll();
	}
	
	public Pregunta guardarPregunta(Pregunta nuevaPregunta) {
		return repoPreguntas.save(nuevaPregunta);
	}
	
	public Respuesta guardarRespuesta(Respuesta nuevaRespuesta) {
		return repoRespuestas.save(nuevaRespuesta);
	}
	
	public Etiqueta encuentraEtiqueta(String etiqueta) {
		return repoEtiquetas.findByTema(etiqueta);
	}
	
	public Etiqueta guardarEtiqueta(Etiqueta nuevaEtiqueta) {
		return repoEtiquetas.save(nuevaEtiqueta);
	}
	
	public Pregunta encuentraPregunta(Long id) {
		return repoPreguntas.findById(id).orElse(null);
	}
}
