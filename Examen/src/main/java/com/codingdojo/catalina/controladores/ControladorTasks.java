package com.codingdojo.catalina.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.catalina.modelos.Task;
import com.codingdojo.catalina.modelos.Usuario;
import com.codingdojo.catalina.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorTasks {

	@Autowired
	private Servicios servicio;
	
	@GetMapping("/tasks")
	public String dashboard(HttpSession session, Model model) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		List<Task> listaDeTasks = servicio.todasLasTasks();
		
		model.addAttribute("tasks",listaDeTasks);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/tasks/new")
	public String crear(HttpSession session, @ModelAttribute("nuevaTask") Task nuevaTask,
						Model model) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}

		List<Usuario> listaUsuarios = servicio.todosLosUsuarios();
		model.addAttribute("usuarios",listaUsuarios);

		model.addAttribute("host", usuarioTemporal);
		
		return "crear.jsp";
		
	}
	
	@PostMapping("/crear")
	public String nuevaTarea(HttpSession session, 
							@Valid @ModelAttribute("nuevaTask") Task nuevaTask,
							BindingResult result,
							Model model) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			List<Usuario> listaUsuarios = servicio.todosLosUsuarios();
			model.addAttribute("usuarios",listaUsuarios);

			model.addAttribute("host", usuarioTemporal);
			
			return "crear.jsp";
		}else {
			servicio.guardarTask(nuevaTask);
			return "redirect:/tasks";
		}
		
	}
	
	@GetMapping("/tasks/{id}")
	public String verTask(HttpSession session, @PathVariable("id") Long taskId,
						 Model model) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		Task miTask = servicio.encontrarTask(taskId);
		model.addAttribute("task", miTask);
		
		return "ver.jsp";
		
	}
	
	@GetMapping("/tasks/{id}/edit")
	public String editarTask(HttpSession session, @PathVariable("id") Long taskId,
							 @ModelAttribute("task") Task task, Model model) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		List<Usuario> todosLosUsuarios = servicio.todosLosUsuarios();
		Task miTask = servicio.encontrarTask(taskId);
		model.addAttribute("task", miTask);
		model.addAttribute("usuarios", todosLosUsuarios);
		
		return "editar.jsp";
		
	}
	
	@PutMapping("/edit/{id}")
	public String actualizarTask(HttpSession session, @Valid @ModelAttribute("task") Task task,
								BindingResult result, Model model, @PathVariable("id") Long taskId) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			List<Usuario> todosLosUsuarios = servicio.todosLosUsuarios();
			model.addAttribute("usuarios", todosLosUsuarios);
			return "editar.jsp";
		} else {
			servicio.guardarTask(task);
			return "redirect:/tasks";
		}
		
	}
	
	@DeleteMapping("/tasks/delete/{id}")
	public String deleteTask(HttpSession session, @PathVariable("id") Long taskId) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		servicio.deleteTask(taskId);
		return "redirect:/tasks";

		
	}
}
