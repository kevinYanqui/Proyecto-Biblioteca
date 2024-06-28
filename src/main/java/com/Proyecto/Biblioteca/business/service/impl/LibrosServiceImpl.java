package com.Proyecto.Biblioteca.business.service.impl;

import com.Proyecto.Biblioteca.business.service.LibrosService;
import com.Proyecto.Biblioteca.domain.model.Libros;
import com.Proyecto.Biblioteca.persistence.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrosServiceImpl implements LibrosService {

    @Autowired
    private LibrosRepository librosRepository;

    @Override
    public List<Libros> obtenerTodosLosLibros() {
        return librosRepository.findAll();
    }

    @Override
    public void cambiarEstadoLibro(Long id, String estado) {
        Libros libro = librosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        libro.setEstadoLibros(estado);
        librosRepository.save(libro);
    }

    @Override
    public Libros obtenerLibroPorId(Long id) {
        return librosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    @Override
    public void guardarLibro(Libros libro) {
        librosRepository.save(libro);
    }
}
