package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Dormitory;
import com.example.demo.models.Student;
import com.example.demo.services.Services;

import jakarta.validation.Valid;

@Controller
public class DormitoriesController {

	@Autowired
	private Services service;
	
	@GetMapping("/dormitory/new")
	public String newDormitory(@ModelAttribute("dormitory") Dormitory newDormitory) {
		return "/dormitories/new.jsp";
	}
	
	@PostMapping("/dormitory/create")
	public String createDormitory(@Valid @ModelAttribute("dormitory") Dormitory newDormitory, BindingResult res) {
		
		if(res.hasErrors()) {
			return "/dormitories/new.jsp";
		}else {
			service.saveDorm(newDormitory);
			return "redirect:/students";
		}
	}
	
	@GetMapping("/dormitory/{id}")
	public String dormDetails(@PathVariable("id") Long id, Model model, @ModelAttribute("dormitory") Dormitory newDorm) {
		List<Student> studentList = service.findStudentWithoutDormitory();
		model.addAttribute("students", studentList);
		
		Dormitory dorm = service.findDorm(id);
		model.addAttribute("dormitory", dorm);
		return "/dormitories/details.jsp";
	}
	
	@PutMapping("/dormitory/{id}/add")
	public String addStudent(@RequestParam(value="student") Long sid, @PathVariable("id") Long did) {
		service.addStudentToDorm(did, sid);
		return "redirect:/dormitory/"+did;
	}
	
	@DeleteMapping("/dormitory/{id}/remove/{student}")
	public String removeStudent(@PathVariable(value="student") Long sid, @PathVariable("id") Long did) {
		service.deleteStudentFromDorm(sid);
		return "redirect:/dormitory/"+did;
	}
}
