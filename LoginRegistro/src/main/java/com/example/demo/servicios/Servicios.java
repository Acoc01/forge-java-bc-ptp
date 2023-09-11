package com.example.demo.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.modelos.Usuario;
import com.example.demo.repositorios.RepositorioUsuarios;

@Service
public class Servicios {
	
	@Autowired
	private RepositorioUsuarios ru;

	public Usuario regustrar(Usuario nuevoUsuario, BindingResult result) {
		String contrasena = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!contrasena.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Las passwords no coinciden");
		}
		
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = ru.findByEmail(email);
		
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "El correo ingresado ya se encuentra registrado");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String contraEncriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
			nuevoUsuario.setPassword(contraEncriptada);
			return ru.save(nuevoUsuario);
		}
	}
}
