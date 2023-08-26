package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Usuario;
import com.example.demo.services.Services;

@RestController
public class APIController {
	
	@Autowired
	private Services servicio;
	
	@GetMapping("/api/usuarios")
	public List<Usuario> apiMuestraUsuarios(){
		return servicio.todosUsuarios();
	}
	
	@PostMapping("/api/usuarios")
	public Usuario apiCrearUsuario(@RequestParam(value="name") String name,
								   @RequestParam(value="lastName") String lastName,
								   @RequestParam(value="email") String email,
								   @RequestParam(value="password") String pwd) {
		Usuario nuevoUsuario = new Usuario(name,lastName,email,pwd);
		return servicio.guardarUsuario(nuevoUsuario);
	}
	
	@DeleteMapping("/api/usuarios/{id}")
	public void apiBorrar(@PathVariable("id") Long id) {
		servicio.deleteUsuario(id);
	}
	
	@GetMapping("/api/usuarios/{id}")
	public Usuario apiMostrar(@PathVariable("id") Long id) {
		return servicio.buscarUsuario(id);
	}

	@PutMapping("/api/usuarios/{id}")
	public Usuario apiEditarUsuario(@PathVariable("id") Long id,
								   @RequestParam(value="name") String name,
								   @RequestParam(value="lastName") String lastName,
								   @RequestParam(value="email") String email,
								   @RequestParam(value="password") String pwd) {
		Usuario nuevoUsuario = new Usuario(id,name,lastName,email,pwd);
		return servicio.guardarUsuario(nuevoUsuario);
	}
}
