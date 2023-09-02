package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Dojo;
import com.example.demo.models.Ninja;
import com.example.demo.services.DojoService;
import com.example.demo.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjasController {

	@Autowired
	private NinjaService service;
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja newNinja, Model model) {
		List<Dojo> allDojos = dojoService.findAllDojos();
		model.addAttribute("dojos", allDojos);
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja newNinja, BindingResult res, Model model) {
		if(res.hasErrors()) {
			List<Dojo> allDojos = dojoService.findAllDojos();
			model.addAttribute("dojos", allDojos);
			return "/ninjas/new.jsp";
		} else {
			service.saveNinja(newNinja);
			return "redirect:/dojos";
		}
	}
}
