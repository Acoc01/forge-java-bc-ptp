package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Licencia;
import com.example.demo.models.Persona;
import com.example.demo.services.Servicios;

import jakarta.validation.Valid;

@Controller
public class ControladorLicencias {

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/licencias/new")
	public String nuevaLicencia(@ModelAttribute("licencia") Licencia newLicencia,
								Model model) {
		List<Persona> listaPersonas = servicio.personaSinDireccion();
		model.addAttribute("personas",listaPersonas);
		return "/licencias/new.jsp";
	}
	
	@PostMapping("/licencias/create")
	public String nuevaLicencia(@Valid @ModelAttribute("licencia") Licencia newLicencia,
								BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Persona> listaPersonas = servicio.personaSinDireccion();
			model.addAttribute("personas",listaPersonas);
			return "/licencias/new.jsp";
		}else {
			servicio.guardarLicencia(newLicencia);
			return "redirect:/personas";
		}
	}
}
