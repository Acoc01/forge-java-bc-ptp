package com.example.demo.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class ControladorBase {

	//@RequestMapping(value="/", method=RequestMethod.GET);
	//URLs deben de ser unicas, nombre de metodo debe ser unico, si se puede
	//usar sobrecarga
	@GetMapping("/")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/despliega")
	public String despliegaUsuraios() {
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		String respuesta = "";
		
		for(int i = 0; i < usuarios.length; ++i) {
			respuesta += "<h2>"+usuarios[i]+"</h2>";
		}
		
		return respuesta;
	}
	
	@GetMapping("/hello")// hello?nombre=asdasd
	public String helloNombre(@RequestParam(value="nombre") String name) {
		return "<h1>Hola "+name+"!";
	}
	
	@GetMapping("/hello2")
	public String helloNombre(@RequestParam(value="nombre") String name, @RequestParam(value="apellido") String lastName) {
		return "<h1>Hola "+name+" "+lastName+"!";
	}
	
	@GetMapping("/hello/{nombre}")
	public String helloPath(@PathVariable("nombre") String name) {
		return "<h1>Hola "+name+"!";
	}
	
	@GetMapping("repite/{palabra}/{numero}")
	public String repite(@PathVariable("palabra") String word, @PathVariable("numero") int number) {
		String res = "";
		for(int i = 0; i < number; ++i) {
			if(i != number-1)res+=(word+" ");
			if(i == number-1)res+=word;
		}
		return res;
	}
	
}
