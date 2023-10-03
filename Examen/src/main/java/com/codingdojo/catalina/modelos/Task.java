package com.codingdojo.catalina.modelos;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty(message="El campo de task es obligatorio")
	@Size(min=5, message="Task debe tener al menos 5 caracteres")
	private String nombre;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="asignado_id")
	private Usuario assignee;
	
	private String priority;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario host;
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//			name="usuarios_hacen_task",
//			joinColumns = @JoinColumn(name="task_id"),
//			inverseJoinColumns = @JoinColumn(name="usuario_id")
//			)
//	private List<Usuario> trabajadores; //Personas que cumplen las task

	public Task() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Usuario getAssignee() {
		return assignee;
	}

	public void setAssignee(Usuario assignee) {
		this.assignee = assignee;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
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
	
	public Usuario getHost() {
		return host;
	}

	public void setHost(Usuario host) {
		this.host = host;
	}

//	public List<Usuario> getTrabajadores() {
//		return trabajadores;
//	}
//
//	public void setTrabajadores(List<Usuario> trabajadores) {
//		this.trabajadores = trabajadores;
//	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
