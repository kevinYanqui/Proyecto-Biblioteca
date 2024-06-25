package com.Proyecto.Biblioteca.service;

import com.Proyecto.Biblioteca.model.Autores;

import java.util.List;

public interface AutoresService {
    List<Autores> obtenerTodosLosAutores();
    void cambiarEstadoAutor(String id, String estado);
    Autores obtenerAutorPorId(String id);
    void guardarAutor(Autores autor);
}
