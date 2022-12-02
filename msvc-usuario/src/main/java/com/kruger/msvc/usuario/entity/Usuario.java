package com.kruger.msvc.usuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="usuarios")//Es opcional, pero se coloca por convencion en plural
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//la base genera el id de forma automatica e incremental
	private Long id;
	
	//@Column(name = "nombre") cuando tienen el mismo nombre se omite
	@NotEmpty
	private String nombre;
	
	@Column(unique = true)//El correo debe ser unico
	@Email
	@NotBlank
	private String email;
	
	@NotEmpty
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

}
