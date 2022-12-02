package com.kruger.msvc.usuario.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.msvc.usuario.entity.Usuario;
import com.kruger.msvc.usuario.service.IUsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorId(@PathVariable Long id){
		Optional<Usuario> usuario = service.listarPorId(id);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {
		if(result.hasErrors()) {
			return validar(result);
		}
		if(!usuario.getEmail().isEmpty() && service.listarPorEmail(usuario.getEmail()).isPresent()) {
			return ResponseEntity.badRequest()
					.body(Collections.singletonMap("Error", "Usuario existente con ese correo"));
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){		
		if(result.hasErrors()) {
			return validar(result);
		}
		Optional<Usuario> usuarioEncontrado = service.listarPorId(id);
		if(usuarioEncontrado.isPresent()) {
			Usuario usuarioModificar = usuarioEncontrado.get();
			if(!usuario.getEmail().equalsIgnoreCase(usuarioModificar.getEmail()) && service.listarPorEmail(usuario.getEmail()).isPresent()) {
				return ResponseEntity.badRequest()
						.body(Collections.singletonMap("Error", "Correo a modificar debe ser diferente"));
			}
			usuarioModificar.setNombre(usuario.getNombre());
			usuarioModificar.setEmail(usuario.getEmail());
			usuarioModificar.setPassword(usuario.getPassword());
			return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioModificar));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		//validar si el usuario existe en la base
		Optional<Usuario> usuarioBuscado = service.listarPorId(id);
		if(usuarioBuscado.isPresent()) {
			service.eliminar(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();		
	}
	
	private ResponseEntity<?> validar(BindingResult result) {
		Map<String, String> errores = new HashMap<>();
		result.getFieldErrors().forEach(error->{
			errores.put(error.getField(), "El campo: "+error.getField() +" "+error.getDefaultMessage());
		});
		return ResponseEntity.badRequest().body(errores);
	}

}
