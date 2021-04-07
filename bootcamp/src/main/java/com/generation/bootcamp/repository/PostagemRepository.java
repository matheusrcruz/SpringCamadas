package com.generation.bootcamp.repository;

import com.generation.bootcamp.model.Postagem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository //Camada de repository Comunicação direta com banco
public interface PostagemRepository extends JpaRepository<Postagem, Long>{//inteface PostagemRpository estendendo atributos de JPA
	public List <Postagem> findAllByTituloContainingIgnoreCase(String titulo); /*Busca tudo que pelo estiver mo atributo titulo, tudo que estiver contido e ignora case sensitive */

}
