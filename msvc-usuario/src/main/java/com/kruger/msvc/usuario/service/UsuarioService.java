package com.kruger.msvc.usuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kruger.msvc.usuario.entity.Usuario;
import com.kruger.msvc.usuario.repository.UsuarioRepository;

//Anotacion como un componente de servicio
@Service
public class UsuarioService implements IUsuarioService{

	//Inyectamos la interface con todos los metodos JPA
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {		
		return (List<Usuario>)repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> listarPorId(Long id) {		
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Usuario guardar(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public Optional<Usuario> listarPorEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmail(email);
	}

}
