package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.User;
import com.example.demo.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserServices services;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User newUser, Model model) {
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
						   BindingResult result, HttpSession session, Model model) {
		
		services.registrar(newUser, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			session.setAttribute("userInSession", newUser);
			return "redirect:/";
		}
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email,
						@RequestParam("password") String password,
						RedirectAttributes redirectAttributes,
						HttpSession session) {
		
		User userLogin = services.login(email, password);
		
		if(userLogin == null) {
			redirectAttributes.addFlashAttribute("error_login", "El correo/password es incorrecto");
			return "redirect:/";
		} else {
			session.setAttribute("userInSession", userLogin);
			return "redirect:/courses";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userInSession");
		return "redirect:/";
	}
	
	@GetMapping("/add/{id}")
	public String addCourse(@PathVariable("id") Long courseId, HttpSession session) {

		User tempUser = (User)session.getAttribute("userInSession");
		
		if(tempUser == null)
			return "redirect:/";
		services.addCourse(tempUser.getId(),courseId);
		return "redirect:/courses";
	}
}
