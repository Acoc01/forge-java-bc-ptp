package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Contact;
import com.example.demo.models.Student;
import com.example.demo.repositories.ContactRepository;
import com.example.demo.repositories.StudentRepository;

@Service
public class Services {
	@Autowired
	private ContactRepository rc;
	@Autowired
	private StudentRepository rs;
	
	public List<Student> findAllStudents(){
		return rs.findAll();
	}
	
	public List<Student> findStudentsWithoutContact(){
		return rs.findByContactIdIsNull();
	}
	
	public Student saveStudent(Student student) {
		return rs.save(student);
	}
	
	public Contact saveContact(Contact contact) {
		return rc.save(contact);
	}
}
