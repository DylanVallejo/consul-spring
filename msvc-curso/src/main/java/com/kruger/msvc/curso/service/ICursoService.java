package com.kruger.msvc.curso.service;



import java.util.List;
import java.util.Optional;

import com.kruger.msvc.curso.entity.Curso;



public interface ICursoService {
    List<Curso> listar();
    Optional<Curso> porId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);
}
