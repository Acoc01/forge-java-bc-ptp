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

import com.example.demo.models.Persona;
import com.example.demo.services.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorPersonas {
	@Autowired
	private Servicios servicio;
	//Index
	@GetMapping("/personas")
	public String index(Model model) {
		List<Persona> personas = servicio.todasPersonas();
		model.addAttribute("personas", personas);
		return "dashboard.jsp";
	}
	//Show person details
	@GetMapping("/personas/{id}")
	public String mostrarPersona(@PathVariable("id") Long id, Model model) {
		Persona personita = servicio.encontrarPersona(id);
		model.addAttribute("persona", personita);
		return "/personas/details.jsp";
	}
	
	//Create new person (form)
	@GetMapping("/personas/new")
	public String nuevaPersona(@ModelAttribute("persona") Persona newPerson) {
		return "/personas/new.jsp";
	}
	//Create new person (method)
	@PostMapping("/personas/create")
	public String crearPersona(@Valid @ModelAttribute("persona") Persona newPerson,
							   BindingResult result) {
		if(result.hasErrors()) {
			return "/personas/new.jsp";
		}else {
			servicio.guardarPersona(newPerson);
			return "redirect:/personas";
		}
	}
}
