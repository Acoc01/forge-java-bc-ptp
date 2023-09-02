package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Dojo;
import com.example.demo.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository repo;
	
	public List<Dojo> findAllDojos(){
		return repo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Dojo saveDojo(Dojo dojo) {
		return repo.save(dojo);
	}
}
