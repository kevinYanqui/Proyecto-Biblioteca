package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.Autores;

import java.util.List;

public interface AutoresService {
    List<Autores> obtenerTodosLosAutores();
    void cambiarEstadoAutor(String id, String estado);
    Autores obtenerAutorPorId(String id);
    void guardarAutor(Autores autor);
}
