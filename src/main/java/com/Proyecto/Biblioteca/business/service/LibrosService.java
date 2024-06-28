package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.Libros;

import java.util.List;

public interface LibrosService {
    List<Libros> obtenerTodosLosLibros();
    void cambiarEstadoLibro(Long id, String estado);
    Libros obtenerLibroPorId(Long id);
    void guardarLibro(Libros libro);
}
