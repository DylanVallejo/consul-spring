package com.kruger.msvc.usuario.service;

import java.util.List;
import java.util.Optional;

import com.kruger.msvc.usuario.entity.Usuario;

public interface IUsuarioService {

	List<Usuario> listar();
	Optional<Usuario> listarPorId(Long id);
	Usuario guardar(Usuario usuario);
	void eliminar(Long id);
	
	Optional<Usuario> listarPorEmail(String email);
	
}
