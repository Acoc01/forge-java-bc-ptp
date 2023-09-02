package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojosController {

	@Autowired
	private DojoService service;
	
	@GetMapping("/dojos")
	public String index(Model model) {
		List<Dojo> allDojos = service.findAllDojos();
		model.addAttribute("dojos", allDojos);
		return "dashboard.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoDetails(@PathVariable("id") Long id, Model model) {
		Dojo dojo = service.findDojo(id);
		model.addAttribute("dojo", dojo);
		
		return "/dojos/details.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo newDojo) {
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo newDojo, BindingResult res) {
		if(res.hasErrors()) {
			return "/dojos/new.jsp";
		}else {
			service.saveDojo(newDojo);
			return "redirect:/dojos";
		}
	}
}
