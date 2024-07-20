package com.Proyecto.Biblioteca.business.facade;

import com.Proyecto.Biblioteca.domain.model.Autores;

import java.util.List;

public interface AutoresFacade {
    List<Autores> obtenerTodosLosAutores();
    void cambiarEstadoAutor(Long id, String estado);
    Autores obtenerAutorPorId(Long id);
    void guardarAutor(Autores autor);
}
