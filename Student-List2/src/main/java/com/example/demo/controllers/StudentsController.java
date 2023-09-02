package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Dormitory;
import com.example.demo.models.Student;
import com.example.demo.services.Services;

import jakarta.validation.Valid;

@Controller
public class StudentsController {
	@Autowired
	private Services service;
	
	@GetMapping("/students")
	public String index(Model model) {
		List<Student> studentsList = service.findAllStudents();
		model.addAttribute("students", studentsList);
		
		List<Dormitory> allDorms = service.findAllDorms();
		model.addAttribute("dorms", allDorms);
		return "dashboard.jsp";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student newStudent) {
		return "/students/new.jsp";
	}
	
	@PostMapping("/students/create")
	public String createStudent(@Valid @ModelAttribute("student") Student newStudent, BindingResult result) {
		if(result.hasErrors()) {
			return "/students/new.jsp";
		}else {
			service.saveStudent(newStudent);
			return "redirect:/students";
		}
	}
}
