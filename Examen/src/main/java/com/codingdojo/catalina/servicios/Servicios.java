package com.codingdojo.catalina.servicios;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.catalina.modelos.Task;
import com.codingdojo.catalina.modelos.Usuario;
import com.codingdojo.catalina.repositorios.RepositorioTasks;
import com.codingdojo.catalina.repositorios.RepositorioUsuarios;

@Service
public class Servicios {

	@Autowired
	private RepositorioUsuarios ru;
	
	@Autowired
	private RepositorioTasks rt;

	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		String contrasena = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!contrasena.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
		}
		
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = ru.findByEmail(email);
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "El correo ingresado ya se encuentra registrado.");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String contra_encriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
			nuevoUsuario.setPassword(contra_encriptada);
			return ru.save(nuevoUsuario);
		}
		
	}
	public Usuario login(String email, String password) {
		Usuario usuarioInicioSesion = ru.findByEmail(email); 
		if(usuarioInicioSesion == null) {
			return null;
		}
		
		if(BCrypt.checkpw(password, usuarioInicioSesion.getPassword())) {
			return usuarioInicioSesion;
		}
		
		return null;
		
	}
	
	public List<Usuario> todosLosUsuarios(){
		return ru.findAll();
	}
	
	public List<Task> todasLasTasks(){
		return rt.findAll();
	}
	
	public Task guardarTask(Task nuevaTask) {
		return rt.save(nuevaTask);
	}
	
	public Task encontrarTask(Long id) {
		return rt.findById(id).orElse(null);
	}
	
	public void deleteTask(Long id) {
		rt.deleteById(id);
	}
}
