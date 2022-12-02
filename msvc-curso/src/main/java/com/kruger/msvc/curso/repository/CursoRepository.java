package com.kruger.msvc.curso.repository;


import org.springframework.data.repository.CrudRepository;

import com.kruger.msvc.curso.entity.Curso;



public interface CursoRepository extends CrudRepository<Curso, Long> {
}
