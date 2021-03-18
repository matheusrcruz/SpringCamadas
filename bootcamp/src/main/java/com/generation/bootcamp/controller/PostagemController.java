package com.generation.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.bootcamp.repository.PostagemRepository;

@RestController //Controller camada responsável por manipular todas as requisições feitas do lado de fora da nossa API
@RequestMapping("/postagens") // Caminho U R i (Final da url)
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired	//ijeção de dependencia já que não posso instacia uma interface o spring cuida disso
	private PostagemRepository repository;

}
