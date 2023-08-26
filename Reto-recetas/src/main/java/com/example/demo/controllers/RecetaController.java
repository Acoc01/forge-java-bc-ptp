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

import com.example.demo.models.Receta;
import com.example.demo.services.Services;

import jakarta.validation.Valid;

@Controller
public class RecetaController {
	@Autowired
	private Services servicio;
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Receta> recetas = servicio.todasRecetas();
		model.addAttribute("recetas", recetas);
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("receta") Receta receta) {
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("receta") Receta receta,
						BindingResult result) {
		if(result.hasErrors()) {
			return "nuevo.jsp";
		}else {
			servicio.guardarReceta(receta);
			return "redirect:/dashboard";
		}
	}

	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id") Long id, Model model) {
		Receta usuarioBuscado = servicio.buscarReceta(id);
		model.addAttribute("receta",usuarioBuscado);
		return "mostrar.jsp";
	}
}
