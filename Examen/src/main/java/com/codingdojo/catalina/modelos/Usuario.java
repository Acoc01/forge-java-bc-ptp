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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotEmpty(message="El campo de nombre es obligatorio")
	@Size(min=2, message="El nombre debe tener al menos 2 caracteres")
	private String nombre;
	
	@NotEmpty(message="El campo de email es obligatorio")
	@Email(message="Favor de ingresar email válido")
	private String email;
	
	@NotEmpty(message="El campo de password es obligatorio")
	@Size(min=8, message="El password debe tener al menos 8 caracteres")
	private String password;
	
	@Transient 
	@NotEmpty(message="El campo de password es obligatorio")
	@Size(min=8, message="El password debe tener al menos 8 caracteres")
	private String confirmacion;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Task> tasksCreadas;
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(
//			name="usuarios_hacen_task",
//			joinColumns = @JoinColumn(name="usuario_id"),
//			inverseJoinColumns = @JoinColumn(name="task_id")
//			)
	@OneToMany(mappedBy="assignee", fetch=FetchType.LAZY)
	private List<Task> tasksProximas; //Task que el usuario hará
	

	public Usuario() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
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
	

	public List<Task> getTasksCreadas() {
		return tasksCreadas;
	}

	public void setTasksCreadas(List<Task> tasksCreadas) {
		this.tasksCreadas = tasksCreadas;
	}

	public List<Task> getTasksProximas() {
		return tasksProximas;
	}

	public void setTasksProximas(List<Task> tasksProximas) {
		this.tasksProximas = tasksProximas;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
}
