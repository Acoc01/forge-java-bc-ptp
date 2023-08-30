package com.example.demo.controladores;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.Usuario;
import com.example.demo.services.Services;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	@Autowired
	private Services servicio;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/usuarios")
	public String usuarios(Model model) {
		model.addAttribute("titulo", "Titulo para Usuarios");
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso"};
		model.addAttribute("listaUsuarios", usuarios);
		
		HashMap<String, String> paises = new HashMap<String, String>();
		
		paises.put("Mexico", "CDMX");
		paises.put("Estados Unidos", "Washington DC");
		paises.put("El Salvador", "San Salvador");
		
		model.addAttribute("paises",paises);
		return "usuarios.jsp";
	}
	
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario.jsp";
	}
	
	@PostMapping("/registrarme")
	public String registrarme(@RequestParam(value="nombre") String name,
							  @RequestParam(value="email") String mail,
							  RedirectAttributes flash,
							  HttpSession session) {
		System.out.println("El nombre fue:"+name);
		System.out.println("El email fue:"+mail);
		
		//Validacion
		if(name.equals("")) {
			flash.addFlashAttribute("errorNombre", "Por favor proporciona tu nombre");
			return "redirect:/formulario";
		}
		//Guardamos en sesion
		session.setAttribute("nombreUsuario", name);
		return "redirect:/bienvenida";
	}
	
	@GetMapping("/bienvenida")
	public String bienvenida(HttpSession session){
		Object nombreEnSesion = session.getAttribute("nombreUsuario");
		if(nombreEnSesion != null) {
			String nombre = (String)nombreEnSesion;
			System.out.println("El nombre guardado es: "+nombre);
		}else {
			System.out.println("No se ha registrado");
		}
		return "bienvenida.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Usuario> usuarios = servicio.todosUsuarios();
		model.addAttribute("usuarios",usuarios);
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("usuario") Usuario user) {
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario user,
						BindingResult result) {
		if(result.hasErrors()) {
			return "nuevo.jsp";
		}else {
			servicio.guardarUsuario(user);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id") Long id, Model model) {
		Usuario usuarioBuscado = servicio.buscarUsuario(id);
		model.addAttribute("usuario",usuarioBuscado);
		return "mostrar.jsp";
	}
	
	@DeleteMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") Long id) {
		servicio.deleteUsuario(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, @ModelAttribute("usuario") Usuario usuario, Model model) {
		Usuario usuarioBuscado = servicio.buscarUsuario(id);
		model.addAttribute("usuario", usuarioBuscado);
		
		return "editar.jsp";
	}
	
	@PutMapping("/actualizar/{id}")
	public String actualizar( @Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			servicio.guardarUsuario(usuario);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/buscar/{palabra}")
	public String buscar(@PathVariable("palabra") String palabra, Model model) {
		List<Usuario> usuariosConPalabra = servicio.findByName(palabra);
		model.addAttribute("usuarios", usuariosConPalabra);
		model.addAttribute("palabra", palabra);
		return "buscar.jsp";
	}
	
	@PostMapping("/busqueda")
	public String busqueda(@RequestParam(value="palabra") String word) {
		return "redirect:/buscar/"+word;
	}
	
	@GetMapping("/top10")
	public String top(Model model) {
		List<Usuario> usuarioTop = servicio.top10();
		model.addAttribute("usuarios", usuarioTop);
		return "top10.jsp";
	}
	
	
}
