package com.kruger.msvc.usuario.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.kruger.msvc.usuario.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	
	Optional<Usuario> findByEmail(String email);

}
