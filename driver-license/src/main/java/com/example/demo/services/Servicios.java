package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Licencia;
import com.example.demo.models.Persona;
import com.example.demo.repositories.RepositorioLicencias;
import com.example.demo.repositories.RepositorioPersonas;

@Service
public class Servicios {
	@Autowired
	RepositorioPersonas rp;
	
	@Autowired
	RepositorioLicencias rl;
	
	public Persona guardarPersona(Persona np) {
		return rp.save(np);
	}
	
	public Persona encontrarPersona(Long id) {
		return rp.findById(id).orElse(null);
	}
	
	public List<Persona> todasPersonas(){
		return rp.findAll();
	}
	
	public List<Persona> personaSinDireccion(){
		return rp.findByLicenciaIdIsNull();
	}
	
	public Licencia guardarLicencia(Licencia nl) {
		return rl.save(nl);
	}

}
