package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ControladorPokemon {
	
	@GetMapping("/pokemones")
	public String pokemones() {
		String uri = "https://pokeapi.co/api/v2/pokemon/?limit=60";
		RestTemplate restTemplate = new RestTemplate();
		Object respuesta = restTemplate.getForObject(uri, Object.class);
	}

}
