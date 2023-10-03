package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Estado;
import com.example.demo.models.Evento;
import com.example.demo.models.Mensaje;
import com.example.demo.models.Usuario;
import com.example.demo.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorEventos {
	
	@Autowired
	private Servicios servicios;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model,
							@ModelAttribute("nuevoEvento") Evento nuevoEvento) {
		
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		
		
		String miEstado = usuarioTemporal.getEstado();
		
		List<Evento> eventosMiEstado = servicios.eventosEnMiEstado(miEstado);
		model.addAttribute("eventosMiEstado", eventosMiEstado);
		
		List<Evento> eventosOtroEstado = servicios.eventosOtroEstado(miEstado);
		model.addAttribute("eventosOtroEstado", eventosOtroEstado);
		
		Usuario miUsuario = servicios.encontrarUsuario(usuarioTemporal.getId());
		model.addAttribute("usuario", miUsuario);
		
		model.addAttribute("estados", Estado.Estados);
		
		return "dashboard.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(HttpSession session,
						@Valid @ModelAttribute("nuevoEvento") Evento nuevoEvento,
						BindingResult result,
						Model model) {
		/*====== REVISAMOS SESION ======*/
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		/*====== REVISAMOS SESION ======*/
		
		if(result.hasErrors()) {
			model.addAttribute("estados", Estado.Estados);
			String miEstado = usuarioTemporal.getEstado(); //Obtenemos el estado del usuario en sesión
			
			List<Evento> eventosMiEstado = servicios.eventosEnMiEstado(miEstado);
			model.addAttribute("eventosMiEstado", eventosMiEstado); //crea una "variable" y la envía al jsp
			
			List<Evento> eventosOtroEstado = servicios.eventosOtroEstado(miEstado);
			model.addAttribute("eventosOtroEstado", eventosOtroEstado);
			
			Usuario miUsuario = servicios.encontrarUsuario(usuarioTemporal.getId());
			model.addAttribute("usuario", miUsuario);
			return "dashboard.jsp";
		} else {
			servicios.guardarEvento(nuevoEvento);
			return "redirect:/dashboard";
		}
	
	}
	
	@GetMapping("/unir/{id}")
	public String unir(@PathVariable("id") Long eventoId,
					   HttpSession session) {
		/*====== REVISAMOS SESION ======*/
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		/*====== REVISAMOS SESION ======*/
		
		servicios.unirEvento(usuarioTemporal.getId(), eventoId);
		return "redirect:/dashboard";
	}

	@GetMapping("/quitar/{id}")
	public String quitar(@PathVariable("id") Long eventoId,
						 HttpSession session) {
		/*====== REVISAMOS SESION ======*/
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		/*====== REVISAMOS SESION ======*/
		
		servicios.quitarEvento(usuarioTemporal.getId(), eventoId);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/evento/{id}")
	public String evento(@PathVariable("id") Long eventoId,
						 HttpSession session,
						 Model model,
						 @ModelAttribute("mensaje") Mensaje mensaje) {
		/*====== REVISAMOS SESION ======*/
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		/*====== REVISAMOS SESION ======*/
		
		Evento evento = servicios.encontrarEvento(eventoId);
		model.addAttribute("evento", evento); //Variable
		
		return "evento.jsp";
		
	}
	
	@PostMapping("/crearmensaje")
	public String crearmensaje(@Valid @ModelAttribute("mensaje") Mensaje mensaje,
							   BindingResult result,
							   HttpSession session,
							   Model model) {
		/*====== REVISAMOS SESION ======*/
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		/*====== REVISAMOS SESION ======*/
		
		if(result.hasErrors()) {
			model.addAttribute("evento", mensaje.getEvento());
			return "evento.jsp";
		} else {
			servicios.guardarMensaje(mensaje);
			// localhost:8080/evento/3
			return "redirect:/evento/"+mensaje.getEvento().getId();
		}
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,
						 @ModelAttribute("evento") Evento evento,
						 Model model,
						 HttpSession session) {
		Usuario usuarioTemporal = (Usuario)session.getAttribute("usuarioEnSesion");
		if(usuarioTemporal == null) {
			return "redirect:/";
		}
		Evento eventoBuscado = servicios.encontrarEvento(id);
		model.addAttribute("estados", Estado.Estados);
		model.addAttribute("evento", eventoBuscado);
		
		return "editar.jsp";
		
	}
	
	@PutMapping("/evento/{id}/edit")
	public String actualizar(@Valid @ModelAttribute("evento") Evento evento,
							 BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("estados", Estado.Estados);
			return "editar.jsp";
		} else {
			servicios.guardarEvento(evento);
			return "redirect:/dashboard";
		}
	}

}
