package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	@GetMapping("/")
	public String Home() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String dateView(Model model) {
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("EEEE, dd MMM, yyyy");
		String formated_date = format.format(today);
		
		model.addAttribute("todayDate", formated_date);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String timeView(Model model) {
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		String hour = format.format(today);
		model.addAttribute("todayHour",hour);
		return "time.jsp";
	}
}
