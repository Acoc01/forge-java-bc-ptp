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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Song;
import com.example.demo.services.SongService;

import jakarta.validation.Valid;

@Controller
public class SongsController {
	
	@Autowired
	private SongService service;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = service.findAll();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/create")
	public String createSong(@Valid @ModelAttribute("song")Song song,
							 BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}else {
			service.saveSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/songs/{id}")
	public String showSong(@PathVariable("id") Long id, Model model) {
		Song song = service.findById(id);
		model.addAttribute("song", song);
		return "details.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		service.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> top = service.findTop10();
		model.addAttribute("songs", top);
		return "topTen.jsp";
	}
	
	@GetMapping("/search/{word}")
	public String searchByArtist(@PathVariable("word") String word, Model model) {
		List<Song> songs = service.findByArtist(word);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@PostMapping("/search")
	public String searchAction(@RequestParam(value="word") String word) {
		return "redirect:/search/"+word;
	}
}
