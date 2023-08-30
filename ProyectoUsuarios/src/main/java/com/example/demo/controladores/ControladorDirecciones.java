package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Direccion;
import com.example.demo.models.Usuario;
import com.example.demo.services.Services;

import jakarta.validation.Valid;

@Controller
public class ControladorDirecciones {
	
	@Autowired
	private Services servicio;
	
	@GetMapping("/direcciones/nueva")
	public String nuevaDireccion(@ModelAttribute("direccion") Direccion nueva, Model model) {
			List<Usuario> listaUsuarios = servicio.usuariosSinDireccion();
		model.addAttribute("usuarios",listaUsuarios);
		return "/direcciones/nueva.jsp";
	}
	
	@PostMapping("/direcciones/crear")
	public String crearDireccion(@Valid @ModelAttribute("direccion") Direccion nueva,
								 BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Usuario> listaUsuarios = servicio.usuariosSinDireccion();
			model.addAttribute("usuarios",listaUsuarios);
			return "/direcciones/nueva";
		} else {
			servicio.guardarDireccion(nueva);
			return "redirect:/dashboard";
		}
	}

}
