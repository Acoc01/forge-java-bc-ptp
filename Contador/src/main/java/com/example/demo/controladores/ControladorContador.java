package com.example.demo.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorContador {
	@GetMapping("/")
	public String index(HttpSession session) {
		Object contadorObjeto = session.getAttribute("contador");
		if(contadorObjeto == null) {
			session.setAttribute("contador", 1);
		} else {
			Integer contador = (Integer) contadorObjeto;
			contador++;
			session.setAttribute("contador", contador);
		}
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession session) {
		Object contadorObjeto = session.getAttribute("contador");
		if(contadorObjeto == null) {
			session.setAttribute("contador", 0);
		} 
		return "counter.jsp";
	}
	
	@GetMapping("/counter2")
	public String counter2(HttpSession session) {
		Object contadorObjeto = session.getAttribute("contador");
		if(contadorObjeto == null) {
			session.setAttribute("contador", 1);
		}else {
			Integer contador = (Integer) contadorObjeto;
			contador+=2;
			session.setAttribute("contador", contador);
		}
		return "counter.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}
}
