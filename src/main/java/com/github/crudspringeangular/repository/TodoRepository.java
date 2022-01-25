package com.github.crudspringeangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.crudspringeangular.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	
	

}
