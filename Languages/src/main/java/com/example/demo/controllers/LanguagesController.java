package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Language;
import com.example.demo.services.LanguageServices;

import jakarta.validation.Valid;

@Controller
public class LanguagesController {
	
	@Autowired
	private LanguageServices service;
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = service.findAllLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@GetMapping("/languages/{id}")
	public String getLanguage(@PathVariable("id") Long id, Model model) {
		Language newLanguage = service.findLanguage(id);
		model.addAttribute("language", newLanguage);
		return "details.jsp";
	}

	@GetMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, @ModelAttribute("language") Language language,
								Model model) {
		Language newLanguage = service.findLanguage(id);
		model.addAttribute("language", newLanguage);
		return "edit.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language,
						 BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Language> languages = service.findAllLanguages();
			model.addAttribute("languages", languages);
			return "index.jsp";
		}else {
			service.saveLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@PutMapping("/languages/{id}")
	public String edit(@Valid @ModelAttribute("language") Language language,
						BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			service.saveLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		service.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
}
