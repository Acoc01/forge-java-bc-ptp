package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository repo;
	
	public List<Song> findAll(){
		return repo.findAll();
	}
	
	public List<Song> findByArtist(String artist){
		return repo.findByArtist(artist);
	}
	
	public Song saveSong(Song newSong) {
		return repo.save(newSong);
	}
	
	public void deleteSong(Long id) {
		repo.deleteById(id);
	}
	
	public List<Song> findTop10(){
		return repo.findTop10ByOrderByRatingDesc();
	}
	
	public Song findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
}
