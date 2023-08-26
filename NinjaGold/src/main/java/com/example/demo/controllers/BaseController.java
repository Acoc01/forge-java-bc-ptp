package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller//Indicamos que es un controlador
public class BaseController {
	//Creamos la ruta /gold
	@GetMapping("/gold")
	public String index() {
		return "index.jsp";//Devolvemos el index.jsp como la vista seleccionada de esta ruta
	}
	
	//Creamos una ruta que envia un formulario con POST
	//Recibimos una sesion para poder almacenar tanto el historial de actividades como
	//el oro actual del juego.
	//Tambien recibe un parametro que en este caso lo recibe como un parametro de query 
	//desde el url indicando el lugar al que el ninja accedio.
	
	@PostMapping("/granja")
	public String granja(HttpSession session, @RequestParam(value="lugar") String lugar) {
		int gold = 0; //Indica el oro actual
		ArrayList<String> historial = new ArrayList<String>(); // Array con historial de actividades
		
		//Revisamos si existe la variable gold en la sesion
		if(session.getAttribute("gold") == null) {
			//Como gold era null, no existe asi que creamos uno con valor inicial 0
			session.setAttribute("gold", 0);
			//Hacemos lo mismo con el historial, ya que esto indica que no existia
			session.setAttribute("historial",historial);
		} else {
			//Si existe, hacemos casting de Object a Integer del atributo "gold"
			gold = (int)session.getAttribute("gold");
			//Realizamos lo mismo para el historial
			historial = (ArrayList<String>) session.getAttribute("historial");
		}
		
		//Variables que nos ayudaran a definir el intervalo de la ganancia o perdida
		int min = 10;
		int max = 20;
		int random = new Random().nextInt(max-min+1) + min;
		gold += random; // Actualizamos el oro
		
		session.setAttribute("gold", gold);//Actualizamos el oro de la sesion
		
		//Ahora definimos el formato de la fecha para las actividades
		Date fecha = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm");
		String fechaFormateada = format.format(fecha);
		
		String message = "";

		//Si perdimos oro...
		if(random < 0) {
			message = "Entraste a: "+lugar+"y perdiste: "+random+" monedas. "+fechaFormateada;
		} else {
			message = "Entraste a: "+lugar+"y ganaste: "+random+" monedas. "+fechaFormateada;
		}
		
		//Guardamos el mensaje en el historial de actividades
		historial.add(message);
		//Actualizamos el array de actividades de la sesion
		session.setAttribute("historial", historial);
		
		return("redirect:/gold");
	}
	@PostMapping("/cueva")
	public String cueva(HttpSession session, @RequestParam(value="lugar") String lugar) {
		int gold = 0; //Indica el oro actual
		ArrayList<String> historial = new ArrayList<String>(); // Array con historial de actividades
		
		//Revisamos si existe la variable gold en la sesion
		if(session.getAttribute("gold") == null) {
			//Como gold era null, no existe asi que creamos uno con valor inicial 0
			session.setAttribute("gold", 0);
			//Hacemos lo mismo con el historial, ya que esto indica que no existia
			session.setAttribute("historial",historial);
		} else {
			//Si existe, hacemos casting de Object a Integer del atributo "gold"
			gold = (int)session.getAttribute("gold");
			//Realizamos lo mismo para el historial
			historial = (ArrayList<String>) session.getAttribute("historial");
		}
		
		//Variables que nos ayudaran a definir el intervalo de la ganancia o perdida
		int min = 5;
		int max = 10;
		int random = new Random().nextInt(max-min+1) + min;
		gold += random; // Actualizamos el oro
		
		session.setAttribute("gold", gold);//Actualizamos el oro de la sesion
		
		//Ahora definimos el formato de la fecha para las actividades
		Date fecha = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm");
		String fechaFormateada = format.format(fecha);
		
		String message = "";

		//Si perdimos oro...
		if(random < 0) {
			message = "Entraste a: "+lugar+"y perdiste: "+random+" monedas. "+fechaFormateada;
		} else {
			message = "Entraste a: "+lugar+"y ganaste: "+random+" monedas. "+fechaFormateada;
		}
		
		//Guardamos el mensaje en el historial de actividades
		historial.add(message);
		//Actualizamos el array de actividades de la sesion
		session.setAttribute("historial", historial);
		
		return("redirect:/gold");
	}
	@PostMapping("/casa")
	public String casa(HttpSession session, @RequestParam(value="lugar") String lugar) {
		int gold = 0; //Indica el oro actual
		ArrayList<String> historial = new ArrayList<String>(); // Array con historial de actividades
		
		//Revisamos si existe la variable gold en la sesion
		if(session.getAttribute("gold") == null) {
			//Como gold era null, no existe asi que creamos uno con valor inicial 0
			session.setAttribute("gold", 0);
			//Hacemos lo mismo con el historial, ya que esto indica que no existia
			session.setAttribute("historial",historial);
		} else {
			//Si existe, hacemos casting de Object a Integer del atributo "gold"
			gold = (int)session.getAttribute("gold");
			//Realizamos lo mismo para el historial
			historial = (ArrayList<String>) session.getAttribute("historial");
		}
		
		//Variables que nos ayudaran a definir el intervalo de la ganancia o perdida
		int min = 2;
		int max = 5;
		int random = new Random().nextInt(max-min+1) + min;
		gold += random; // Actualizamos el oro
		
		session.setAttribute("gold", gold);//Actualizamos el oro de la sesion
		
		//Ahora definimos el formato de la fecha para las actividades
		Date fecha = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm");
		String fechaFormateada = format.format(fecha);
		
		String message = "";

		//Si perdimos oro...
		if(random < 0) {
			message = "Entraste a: "+lugar+"y perdiste: "+random+" monedas. "+fechaFormateada;
		} else {
			message = "Entraste a: "+lugar+"y ganaste: "+random+" monedas. "+fechaFormateada;
		}
		
		//Guardamos el mensaje en el historial de actividades
		historial.add(message);
		//Actualizamos el array de actividades de la sesion
		session.setAttribute("historial", historial);
		
		return("redirect:/gold");
	}
	@PostMapping("/casino")
	public String casino(HttpSession session, @RequestParam(value="lugar") String lugar) {
		int gold = 0; //Indica el oro actual
		ArrayList<String> historial = new ArrayList<String>(); // Array con historial de actividades
		
		//Revisamos si existe la variable gold en la sesion
		if(session.getAttribute("gold") == null) {
			//Como gold era null, no existe asi que creamos uno con valor inicial 0
			session.setAttribute("gold", 0);
			//Hacemos lo mismo con el historial, ya que esto indica que no existia
			session.setAttribute("historial",historial);
		} else {
			//Si existe, hacemos casting de Object a Integer del atributo "gold"
			gold = (int)session.getAttribute("gold");
			//Realizamos lo mismo para el historial
			historial = (ArrayList<String>) session.getAttribute("historial");
		}
		
		//Variables que nos ayudaran a definir el intervalo de la ganancia o perdida
		int min = -50;
		int max = 50;
		int random = new Random().nextInt(max-min+1) + min;
		gold += random; // Actualizamos el oro
		
		session.setAttribute("gold", gold);//Actualizamos el oro de la sesion
		
		//Ahora definimos el formato de la fecha para las actividades
		Date fecha = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm");
		String fechaFormateada = format.format(fecha);
		
		String message = "";

		//Si perdimos oro...
		if(random < 0) {
			message = "Entraste a: "+lugar+"y perdiste: "+random+" monedas. "+fechaFormateada;
		} else {
			message = "Entraste a: "+lugar+"y ganaste: "+random+" monedas. "+fechaFormateada;
		}
		
		//Guardamos el mensaje en el historial de actividades
		historial.add(message);
		//Actualizamos el array de actividades de la sesion
		session.setAttribute("historial", historial);
		if(gold < 0) {
			return "redirect:/carcel";
		}
		return("redirect:/gold");
	}
	@PostMapping("/spa")
	public String spa(HttpSession session, @RequestParam(value="lugar") String lugar) {
		int gold = 0; //Indica el oro actual
		ArrayList<String> historial = new ArrayList<String>(); // Array con historial de actividades
		
		//Revisamos si existe la variable gold en la sesion
		if(session.getAttribute("gold") == null) {
			//Como gold era null, no existe asi que creamos uno con valor inicial 0
			session.setAttribute("gold", 0);
			//Hacemos lo mismo con el historial, ya que esto indica que no existia
			session.setAttribute("historial",historial);
		} else {
			//Si existe, hacemos casting de Object a Integer del atributo "gold"
			gold = (int)session.getAttribute("gold");
			//Realizamos lo mismo para el historial
			historial = (ArrayList<String>) session.getAttribute("historial");
		}
		
		//Variables que nos ayudaran a definir el intervalo de la ganancia o perdida
		int min = 5;
		int max = 20;
		int random = new Random().nextInt(max-min+1) + min;
		gold -= random; // Actualizamos el oro
		
		session.setAttribute("gold", gold);//Actualizamos el oro de la sesion
		
		//Ahora definimos el formato de la fecha para las actividades
		Date fecha = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm");
		String fechaFormateada = format.format(fecha);
		
		String message = "";

		//Si perdimos oro...
		message = "Entraste a: "+lugar+"y perdiste: "+random+" monedas. "+fechaFormateada;
		
		//Guardamos el mensaje en el historial de actividades
		historial.add(message);
		//Actualizamos el array de actividades de la sesion
		session.setAttribute("historial", historial);
		if(gold < 0) {
			return "redirect:/carcel";
		}
		return("redirect:/gold");
	}
	
	@GetMapping("/carcel")
	public String carcel(HttpSession session) {
		return "carcel.jsp";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}
}

