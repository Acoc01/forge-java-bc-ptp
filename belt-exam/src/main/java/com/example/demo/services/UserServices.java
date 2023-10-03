package com.example.demo.services;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.models.Course;
import com.example.demo.models.User;
import com.example.demo.models.UserCourse;
import com.example.demo.repositories.CoursesRepository;
import com.example.demo.repositories.UserCourseRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class UserServices {

	@Autowired
	private UsersRepository userRepo;
	
	@Autowired
	private CoursesRepository courseRepo;

	@Autowired
	private UserCourseRepository cuRepo;
	
	public User registrar(User nuevoUsuario, BindingResult result) {

		String contrasena = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!contrasena.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Las contraseñas no coinciden");
		}
		
		String email = nuevoUsuario.getEmail();
		User existeUsuario = userRepo.findByEmail(email);
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "El correo ingresado ya se encuentra registrado.");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String contra_encriptada = BCrypt.hashpw(contrasena, BCrypt.gensalt());
			nuevoUsuario.setPassword(contra_encriptada);
			return userRepo.save(nuevoUsuario);
		}
		
	}
	
	public User login(String email, String password) {
		User usuarioInicioSesion = userRepo.findByEmail(email); 
		if(usuarioInicioSesion == null) {
			return null;
		}
		
		if(BCrypt.checkpw(password, usuarioInicioSesion.getPassword())) {
			return usuarioInicioSesion;
		}
		
		return null;
		
	}
	
	public void addCourse(Long userId, Long courseId) {
		User tempUser = userRepo.findById(userId).orElse(null);
		Course tempCourse = courseRepo.findById(courseId).orElse(null);
		
		tempCourse.getStudents().add(tempUser);
		courseRepo.save(tempCourse);
		
//		UserCourse userCourse = new UserCourse();
//		
//		userCourse.setCourse(tempCourse);
//		userCourse.setUser(tempUser);
//		userCourse.setJoinDate(new Date());
//		
//		cuRepo.save(userCourse);
		
	}
	
	public void removeCourse(Long userId, Long courseId) {
		User tempUser = userRepo.findById(userId).orElse(null);
		Course tempCourse = courseRepo.findById(courseId).orElse(null);
		
		tempCourse.getStudents().remove(tempUser);
		courseRepo.save(tempCourse);
	}
	
	public User findUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
}
