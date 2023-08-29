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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="languages")
public class Language {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=20, message="El nombre debe tener entre 2 y 20 letras")
	private String name;
	
	@NotNull
	@Size(min=2, max=20, message="El nombre debe tener entre 2 y 20 letras")
	private String creator;

	@NotEmpty
	private String currentVersion;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern="yyy-MM-dd")
	private Date updatedAt;

	public Language() {
		super();
	}

	public Language(@NotNull @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 letras") String name,
			@NotNull @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 letras") String creador,
			@NotEmpty String currentVersion) {
		super();
		this.name = name;
		this.creator = creador;
		this.currentVersion = currentVersion;
	}

	public Language(Long id,
			@NotNull @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 letras") String name,
			@NotNull @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 letras") String creador,
			@NotEmpty String currentVersion) {
		super();
		this.id = id;
		this.name = name;
		this.creator = creador;
		this.currentVersion = currentVersion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creador) {
		this.creator = creador;
	}

	public String getCurrentVersion() {
		return currentVersion;
	}

	public void setCurrentVersion(String currentVersion) {
		this.currentVersion = currentVersion;
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
