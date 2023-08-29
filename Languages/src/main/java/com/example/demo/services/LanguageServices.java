package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Language;
import com.example.demo.repositories.LanguagesRepositorie;

@Service
public class LanguageServices {
	
	@Autowired
	private LanguagesRepositorie repoLanguages;
	
	public List<Language> findAllLanguages(){
		return repoLanguages.findAll();
	}
	
	public Language saveLanguage(Language newLanguage) {
		return repoLanguages.save(newLanguage);
	}
	
	public Language findLanguage(Long id) {
		return repoLanguages.findById(id).orElse(null);
	}

	public void deleteLanguage(Long id) {
		repoLanguages.deleteById(id);
	}
}
