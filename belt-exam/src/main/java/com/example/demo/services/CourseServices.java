package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Course;
import com.example.demo.models.UserCourse;
import com.example.demo.repositories.CoursesRepository;
import com.example.demo.repositories.UserCourseRepository;

@Service
public class CourseServices {

	@Autowired
	private CoursesRepository courseRepo;
	
	@Autowired
	private UserCourseRepository cuRepo;
	
	public List<Course> allCourses(){
		return courseRepo.findAll();
	}
	
	public Course saveCourse(Course course) {
		return courseRepo.save(course);
	}
	
	public Course findCourse(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	public void deleteCourse(Long id) {
		courseRepo.deleteById(id);
	}
	
//	public List<Object[]> findSignUpDate(Long uid, Long cid) {
//		return cuRepo.findUsersAndJoinDatesByCourseId(uid,cid);
//	}
	
}
