package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Hobby;
import com.example.demo.models.Usuario;
import com.example.demo.services.Services;

@Controller
public class ControladorHobbies {
	@Autowired
	private Services servicio;
	
	@GetMapping("/asignar/{id}")
	public String asignar(@PathVariable Long id, Model model) {
		Usuario miUsuario = servicio.buscarUsuario(id);
		model.addAttribute("usuario", miUsuario);
		List<Hobby> hobbies = servicio.todosHobbies();
		model.addAttribute("hobbies", hobbies);
		return "/hobbies/asignar.jsp";
	}
	
	@GetMapping("/asignarHobby/{usuario_id}/{hobby_id}")
	public String asignarHobby(@PathVariable("usuario_id")Long uid,
							   @PathVariable("hobby_id")Long hid) {
		servicio.guardarUsuarioHobby(uid, hid);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/quitarHobby/{usuario_id}/{hobby_id}")
	public String quitarHobby(@PathVariable("usuario_id") Long uid,
							  @PathVariable("hobby_id") Long hid) {
		servicio.quitarUsuarioHobby(uid, hid);
		return "redirect:/dashboard";
	}

}
