package com.Proyecto.Biblioteca.business.facade;

import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.domain.model.Libros;

import java.util.List;

public interface LibrosFacade {
    List<Libros> obtenerTodosLosLibros();
    void cambiarEstadoLibro(Long id, String estado);
    Libros obtenerLibroPorId(Long id);
    void guardarLibro(Libros libro);

    List<Autores> obtenerTodosLosAutores();
    List<Editores> obtenerTodosLosEditores();
    List<Categoria> obtenerTodasLasCategorias();
}
