package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
public class BaseController {
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	@PostMapping("/")
	public String home(@RequestParam(value="code") String password, RedirectAttributes flash, HttpSession session) {
		if(password.equals("bushido"))
			return "redirect:/code";
		System.out.println(password);
		flash.addFlashAttribute("errorCode", "You must train harder!");
		return "redirect:/";
	}
	@GetMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
