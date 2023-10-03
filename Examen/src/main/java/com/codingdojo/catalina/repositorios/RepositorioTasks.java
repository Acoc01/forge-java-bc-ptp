package com.codingdojo.catalina.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.catalina.modelos.Task;

@Repository
public interface RepositorioTasks extends CrudRepository<Task, Long> {

	List<Task> findAll();
}
