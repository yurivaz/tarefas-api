package com.github.crudspringeangular.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.crudspringeangular.model.Todo;
import com.github.crudspringeangular.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {
	
	@Autowired
	private TodoRepository repository;
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo);
		
	}
	
	//Metodo para retornar todos os dados do banco
	@GetMapping
	public List<Todo>getAll(){
		return repository.findAll();
	}
	
	//url/api/todos/o id selecionado no json
	@GetMapping("{id}")
	public Todo getById(@PathVariable Long id) {
		return repository.
				findById(id).
				orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)); // caso ele não encontre o ID o a api vai lançar essa excpetion
	}
	
	//Metodo que vai deletar registro
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	//Vai atualizar o curso
	@PatchMapping("{id}/tarefafeita")
	public Todo marcarConcluido(@PathVariable Long id) {
		return repository.findById(id).map(todo ->{
			todo.setTarefaFeita(true);
			todo.setTarefaFeitaData(LocalDateTime.now());
			repository.save(todo);
			return todo;
		}).orElse(null);
		
	}
	
	

}
