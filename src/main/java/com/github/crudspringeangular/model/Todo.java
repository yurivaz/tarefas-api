package com.github.crudspringeangular.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

//Entidade do Banco de Dados 
@Entity
@Getter
@Setter //Em tempo de compilação do lombok gera os Getter and Setter
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gerando a chave primaria
	private Long id;
	
	@Column
	private String descricao;
	
	@Column
	private Boolean tarefaFeita;
	
	@Column
	@JsonFormat(pattern ="dd/MM/yyyy HH:mm")
	private LocalDateTime cadastro; // Api LocalDateTime veio no Java 8
	
	@Column
	private LocalDateTime tarefaFeitaData;
	
	@PrePersist
	public void beforeSave() { //Metodo que vai ser executado antes do metodo save
		
		setCadastro(LocalDateTime.now());
		
	}
	
	
	
	
	

	
	
	
	
	
	

}
