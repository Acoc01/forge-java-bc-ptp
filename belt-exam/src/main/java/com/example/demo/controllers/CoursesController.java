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

import com.example.demo.models.Course;
import com.example.demo.models.User;
import com.example.demo.services.CourseServices;
import com.example.demo.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CoursesController {
	@Autowired
	private CourseServices services;
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/courses")
	public String dashboard(HttpSession session, Model model) {
		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null) {
			return "redirect:/";
		}
		
		List<Course> allCourses = services.allCourses();
		model.addAttribute("courses",allCourses);
		User loggedUser = userServices.findUser(tempUser.getId());
		model.addAttribute("user",loggedUser);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/courses/new")
	public String newCourse(HttpSession session, @ModelAttribute("course") Course newCourse,
							Model model) {
		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null) 
			return "redirect:/";
		
		model.addAttribute("user",tempUser);
		return "newCourse.jsp";	
	}
	
	@PostMapping("/courses/create")
	public String createCourse(@Valid @ModelAttribute("course") Course newCourse,
							   BindingResult result, HttpSession session, Model model) {
		
		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null)
			return "redirect:/";
		
		if(result.hasErrors()){
			model.addAttribute("user",tempUser);
			return "newCourse.jsp";
		} else {
			services.saveCourse(newCourse);
			return "redirect:/courses";
		}
		
	}
	
	@GetMapping("/course/{id}")
	public String courseDetails(@PathVariable("id") Long courseId, 
								HttpSession session, Model model) {

		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null)
			return "redirect:/";
		
		Course thisCourse = services.findCourse(courseId);
		
		model.addAttribute("course", thisCourse);
		model.addAttribute("students",thisCourse.getStudents());
		model.addAttribute("user",tempUser);
		
//		List<Object[]> signUpDate = services.findSignUpDate(tempUser.getId(),courseId );
//		model.addAttribute("students",signUpDate);
		
		return "details.jsp";
		
	}
	
	@GetMapping("/quitar/{id}")
	public String remove(@PathVariable("id") Long courseId,
						 HttpSession session) {
		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null) {
			return "redirect:/";
		}
		
		userServices.removeCourse(tempUser.getId(), courseId);
		return "redirect:/courses";
	}
	
	@DeleteMapping("/course/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		services.deleteCourse(id);
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/{id}/edit")
	public String editCourse(@PathVariable("id") Long courseId,
							HttpSession session,
							@ModelAttribute("course") Course course,
							Model model) {
		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null) {
			return "redirect:/";
		}
		
		Course thisCourse = services.findCourse(courseId);
		model.addAttribute("course", thisCourse);
		return "editar.jsp";
		
		
	}
	
	@PutMapping("/course/{id}/edit")
	public String updateCourse(@Valid @ModelAttribute("course") Course course,
							 BindingResult result, Model model,
							 HttpSession session) {
		User tempUser = (User)session.getAttribute("userInSession");
		if(tempUser == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			services.saveCourse(course);
			return "redirect:/courses";
		}
	}
	
}
