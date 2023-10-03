package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UserCourse;

@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, Long>{
	UserCourse findByUserIdAndCourseId(Long uid, Long cid);
	
//	List<Object[]> findUsersAndJoinDatesByCourseId(Long uid, Long cid);
}
