package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaseController {
	@GetMapping("/")
	public String home() {
		System.out.println("Home");
		return "index.jsp";
	}
	@PostMapping("/")
	public String home(@RequestParam(value="nombre") String name, @RequestParam(value="ubicacion") String location,
						@RequestParam(value="favorito") String fav, @RequestParam(value="comentario",required=false) String comment,
						HttpSession session) {
		session.setAttribute("surveyName",name);
		session.setAttribute("surveyLocation",location);
		session.setAttribute("surveyFav",fav);
		session.setAttribute("surveyComment",comment);
		return "redirect:/result";
	}
	
	@GetMapping("/result")
	public String result(HttpSession session) {
//		Object name = session.getAttribute("surveyName");
//		Object location = session.getAttribute("surveyLocation");
//		Object favorite = session.getAttribute("surveyFav");
//		Object comment = session.getAttribute("surveyComment");
//		
//		String sName = (String)name;
//		String sLocation = (String)location;
//		String sFav = (String)favorite;
//		String sComment = (String)comment;
//		
//		model.addAttribute("survey")
		return "info.jsp";
	}
}
