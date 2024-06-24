package com.Proyecto.Biblioteca.service.impl;

import com.Proyecto.Biblioteca.model.Autores;
import com.Proyecto.Biblioteca.repository.AutoresRepository;
import com.Proyecto.Biblioteca.service.AutoresService;
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
    public void cambiarEstado(String id, String estado) {
        Autores autor = autoresRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        autor.setEstadoAut(estado);
        autoresRepository.save(autor);
    }
    @Override
    public Autores obtenerAutorPorId(String id) {
        return autoresRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
    }
    @Override
    public void actualizarAutor(Autores autor) {
        autoresRepository.save(autor);
    }
}
