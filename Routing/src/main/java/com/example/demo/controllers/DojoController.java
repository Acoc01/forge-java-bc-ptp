package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@GetMapping("/dojo")
	public String home() {
			return "¡El Dojo es increible!";
	}
	@GetMapping("/{nombre}")
	public String dojo(@PathVariable(value="nombre") String name) {
		if(name.equals("burbank-dojo")) {
			return "El Dojo Burbank está localizado al sur de California";
		}else if(name.equals("san-jose")) {
			return "El Dojo SJ es el cuartel general";
		}
		return "No es valido";
	}

}
