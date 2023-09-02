package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Contact;
import com.example.demo.models.Student;
import com.example.demo.services.Services;

import jakarta.validation.Valid;

@Controller
public class ContactsController {

	@Autowired
	private Services service;
	
	@GetMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact newContact, Model model) {
		List<Student> studentList = service.findStudentsWithoutContact();
		model.addAttribute("students", studentList);
		return "/contacts/new.jsp";
	}
	
	@PostMapping("/contacts/create")
	public String createContact(@Valid @ModelAttribute("contact") Contact newContact, BindingResult result,
								Model model) {
		if(result.hasErrors()) {
			List<Student> studentList = service.findStudentsWithoutContact();
			model.addAttribute("students", studentList);
			return "/contacts/new.jsp";
		}else {
			service.saveContact(newContact);
			return "redirect:/students";
		}
	}
}
