package com.Proyecto.Biblioteca.business.facade;

import com.Proyecto.Biblioteca.domain.model.Autores;

import java.util.List;

public interface AutoresFacade {
    List<Autores> obtenerTodosLosAutores();
    void cambiarEstadoAutor(String id, String estado);
    Autores obtenerAutorPorId(String id);
    void guardarAutor(Autores autor);
}
