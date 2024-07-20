package com.Proyecto.Biblioteca.business.service.impl;

import com.Proyecto.Biblioteca.business.service.AutoresService;
import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.persistence.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoresServiceImpl implements AutoresService {

    @Autowired
    private AutoresRepository autoresRepository;

    @Override
    public List<Autores> obtenerTodosLosAutores() {
        return autoresRepository.findAll();
    }

    @Override
    public void cambiarEstadoAutor(Long id, String estado) {
        Autores autor = autoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        autor.setEstadoAut(estado);
        autoresRepository.save(autor);
    }

    @Override
    public Autores obtenerAutorPorId(Long id) {
        return autoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }

    @Override
    public void guardarAutor(Autores autor) {
        autoresRepository.save(autor);
    }
}

