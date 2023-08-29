package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Language;

public interface LanguagesRepositorie extends CrudRepository<Language, Long> {
	
	List<Language> findAll();
	Language save(Language newLanguage);

}
