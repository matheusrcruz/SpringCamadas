
package com.generation.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.bootcamp.model.Postagem;
import com.generation.bootcamp.repository.PostagemRepository;



@RestController //Controller camada responsável por manipular todas as requisições feitas do lado de fora da nossa API
@RequestMapping("/postagens") // Caminho U R i (Final da url)
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired	//ijeção de dependencia já que não posso instacia uma interface o spring cuida disso 
	private PostagemRepository repository;
	
	@GetMapping //Mapeando minha entrada 
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}

}
