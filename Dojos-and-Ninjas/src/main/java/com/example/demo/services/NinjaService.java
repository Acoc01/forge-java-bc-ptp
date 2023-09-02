package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Ninja;
import com.example.demo.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository repo;
	
	public List<Ninja> findAll(){
		return repo.findAll();
	}
	
	public Ninja saveNinja(Ninja ninja) {
		return repo.save(ninja);
	}
}
