package com.generation.bootcamp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.bootcamp.model.Usuario;

//Persistencia com banco ou seja base de dados

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//pode retorna null
	public Optional<Usuario>findByUsuario(String usuario);
	

}
