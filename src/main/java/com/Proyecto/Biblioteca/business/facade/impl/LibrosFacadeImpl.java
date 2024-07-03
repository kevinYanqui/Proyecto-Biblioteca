package com.Proyecto.Biblioteca.business.facade.impl;

import com.Proyecto.Biblioteca.business.facade.LibrosFacade;
import com.Proyecto.Biblioteca.business.service.AutoresService;
import com.Proyecto.Biblioteca.business.service.CategoriaService;
import com.Proyecto.Biblioteca.business.service.EditoresService;
import com.Proyecto.Biblioteca.business.service.LibrosService;
import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.domain.model.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibrosFacadeImpl implements LibrosFacade {

    @Autowired
    private LibrosService librosService;

    @Autowired
    private AutoresService autoresService;

    @Autowired
    private EditoresService editoresService;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<Libros> obtenerTodosLosLibros() {
        return librosService.obtenerTodosLosLibros();
    }

    @Override
    public void cambiarEstadoLibro(Long id, String estado) {
        librosService.cambiarEstadoLibro(id, estado);
    }

    @Override
    public Libros obtenerLibroPorId(Long id) {
        return librosService.obtenerLibroPorId(id);
    }

    @Override
    public void guardarLibro(Libros libro) {
        librosService.guardarLibro(libro);
    }

    @Override
    public List<Autores> obtenerTodosLosAutores() {
        return autoresService.obtenerTodosLosAutores();
    }

    @Override
    public List<Editores> obtenerTodosLosEditores() {
        return editoresService.obtenerTodosLosEditores();
    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaService.obtenerTodasLasCategorias();
    }
}
