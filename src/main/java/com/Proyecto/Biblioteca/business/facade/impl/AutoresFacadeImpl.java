package com.Proyecto.Biblioteca.business.facade.impl;

import com.Proyecto.Biblioteca.business.facade.AutoresFacade;
import com.Proyecto.Biblioteca.business.service.AutoresService;
import com.Proyecto.Biblioteca.domain.model.Autores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AutoresFacadeImpl implements AutoresFacade {

    @Autowired
    private AutoresService autoresService;

    @Override
    public List<Autores> obtenerTodosLosAutores() {
        return autoresService.obtenerTodosLosAutores();
    }

    @Override
    public void cambiarEstadoAutor(Long id, String estado) {
        autoresService.cambiarEstadoAutor(id, estado);
    }

    @Override
    public Autores obtenerAutorPorId(Long id) {
        return autoresService.obtenerAutorPorId(id);
    }

    @Override
    public void guardarAutor(Autores autor) {
        autoresService.guardarAutor(autor);
    }
}
