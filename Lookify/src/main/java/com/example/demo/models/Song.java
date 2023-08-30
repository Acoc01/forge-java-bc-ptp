package com.example.demo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Songs")
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max=255, message="El titulo debe tener al menos 5 caracteres")
	private String title;
	
	@NotNull
	@Size(min=5, max=255, message="Debe tener al menos 5 caracteres")
	private String artist;
	
	@NotNull
	@Min(1)
	@Max(10)
	private Integer rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date updatedAt;

	public Song() {
		super();
	}

	public Song(@NotNull @Size(min = 5, max = 255, message = "El titulo debe tener al menos 5 caracteres") String title,
			@NotNull @Size(min = 5, max = 255, message = "Debe tener al menos 5 caracteres") String artist,
			@NotNull @Min(1) @Max(10) Integer rating, Date createdAt, Date updatedAt) {
		super();
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Song(Long id,
			@NotNull @Size(min = 5, max = 255, message = "El titulo debe tener al menos 5 caracteres") String title,
			@NotNull @Size(min = 5, max = 255, message = "Debe tener al menos 5 caracteres") String artist,
			@NotNull @Min(1) @Max(10) Integer rating, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
