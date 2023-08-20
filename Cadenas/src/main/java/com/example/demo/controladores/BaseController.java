package com.example.demo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
	@GetMapping("/")
	public String home() {
		return "Welcome!";
	}
	
	@GetMapping("/random")
	public String random() {
		return "<h1>Spring boot is great!!</h1>";
	}
}
