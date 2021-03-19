
package com.generation.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.bootcamp.model.Postagem;
import com.generation.bootcamp.repository.PostagemRepository;



@RestController //Controller camada responsável por manipular todas as requisições feitas do lado de fora da nossa API
@RequestMapping("/postagens") // Caminho U R i (Final da url)
@CrossOrigin("*")//Independente do front-end vier nossa api tem que aceitar.



public class PostagemController {
	
	@Autowired	//injeção de dependencia já que não posso instacia uma interface o spring cuida disso 
	private PostagemRepository repository;
	
	@GetMapping //Mapeando minha entrada 
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")//Get espera o user passar o Id para acontecer a ação desejada
	public ResponseEntity<Postagem> GetById(@PathVariable long id){ //REECEBER O valor passo na uri id{1}
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))//Se existente traga a resposta
				.orElse(ResponseEntity.notFound().build());//Se não Retorne o error
	}
	

	@GetMapping("/titulo/{titulo}")
	
	public ResponseEntity<List<Postagem>> GetByTTitulo(@PathVariable String titulo){ //estamos pegando um atributo dentro da URI
		
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		
	}
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem){
		
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		
	}
	
	
	
	
}
