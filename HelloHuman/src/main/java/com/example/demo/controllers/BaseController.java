package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

	@GetMapping("/")
	public String human(@RequestParam(value="nombre", required=false) String name, @RequestParam(value="apellido",required=false) String lastName) {
		if(name == null && lastName == null)
			return "<h1>Hello Human!</h1> Welcome to SpringBoot!";
		return "<h1>Hello "+name+" "+lastName+"!</h1> Welcome to SpringBoot!";
	}
	
}
