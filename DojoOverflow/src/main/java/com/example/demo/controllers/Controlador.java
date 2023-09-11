package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Etiqueta;
import com.example.demo.models.Pregunta;
import com.example.demo.models.Respuesta;
import com.example.demo.services.Servicios;

import jakarta.validation.Valid;

@Controller
public class Controlador {
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/")
	public String inicio() {
		return "redirect:/preguntas";
	}
	
	@GetMapping("/preguntas")
	public String preguntas(Model model) {
		List<Pregunta> preguntas = servicio.todasPreguntas();
		model.addAttribute("preguntas", preguntas);
		return "index.jsp";
	}

	@GetMapping("/nueva")
	public String nueva(@ModelAttribute("pregunta") Pregunta pregunta) {
		return "nueva.jsp";
	}
	
	@PostMapping("/crear")
	public String crearPregunta(@Valid @ModelAttribute("pregunta") Pregunta pregunta,
								BindingResult res, @RequestParam(value="textoEtiquetas") String text) {
		if(res.hasErrors()) {
			return "nueva.jsp";
		} else {
			String[] listaEtiquetas = text.trim().split(",");
			List<Etiqueta> etiquetas = new ArrayList<>();
			
			for(String tema:listaEtiquetas) {
				Etiqueta eti = servicio.encuentraEtiqueta(tema);
				tema.trim();
				
				if(eti==null) {
					Etiqueta nuevaEtiqueta = new Etiqueta();
					nuevaEtiqueta.setTema(tema);
					servicio.guardarEtiqueta(nuevaEtiqueta);
					etiquetas.add(nuevaEtiqueta);
				} else {
					etiquetas.add(eti);
				}
			}
			pregunta.setEtiquetas(etiquetas);
			servicio.guardarPregunta(pregunta);
			return "redirect:/";
		}
	}
	
	@GetMapping("/preguntas/{id}")
	public String pregunta(@PathVariable("id") Long id, Model model,
						   @ModelAttribute("respuesta") Respuesta respuesta) {
		Pregunta preguntita = servicio.encuentraPregunta(id);
		model.addAttribute("pregunta", preguntita);
		return "pregunta.jsp";
	}
	
	@PostMapping("/respuesta")
	public String respuesta(@Valid @ModelAttribute("respuesta") Respuesta respuesta,
							BindingResult res) {
		if(res.hasErrors()) {
			return "pregunta.jsp";
		} else {
			servicio.guardarRespuesta(respuesta);
			return "redirect:/preguntas/"+respuesta.getPregunta().getId();
		}
	}
}
