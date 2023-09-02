package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;
import com.example.demo.models.Dormitory;
import com.example.demo.models.Student;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.DormitoryRepository;
import com.example.demo.repositories.StudentRepository;

@Service
public class Services {
	@Autowired
	private ContactRepository rc;
	@Autowired
	private StudentRepository rs;
	@Autowired
	private DormitoryRepository rd;
	
	public List<Student> findAllStudents(){
		return rs.findAll();
	}
	
	public List<Student> findStudentsWithoutContact(){
		return rs.findByContactIdIsNull();
	}
	
	public List<Student> findStudentWithoutDormitory(){
		return rs.findByDormitoryIdIsNull();
	}
	
	public Student saveStudent(Student student) {
		return rs.save(student);
	}
	
	public Student findStudent(Long id) {
		return rs.findById(id).orElse(null);
	}
	
	public Contact saveContact(Contact contact) {
		return rc.save(contact);
	}
	
	public Dormitory saveDorm(Dormitory dorm) {
		return rd.save(dorm);
	}
	
	public Dormitory findDorm(Long id) {
		return rd.findById(id).orElse(null);
	}
	
	public List<Dormitory> findAllDorms(){
		return rd.findAll();
	}
	
	public void addStudentToDorm(Long did, Long sid) {
		Dormitory dorm = findDorm(did);
		Student student = rs.findById(sid).orElse(null);
		
		student.setDormitory(dorm);
		rs.save(student);	
	}
	
	public void deleteStudentFromDorm(Long sid) {
		Student student = rs.findById(sid).orElse(null);
		
		student.setDormitory(null);
		rs.save(student);	
	}
	
}
