package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.AutoresFacade;
import com.Proyecto.Biblioteca.domain.model.Autores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutoresController {

    @Autowired
    private AutoresFacade autoresFacade;

    @GetMapping
    public List<Autores> listarAutores() {
        return autoresFacade.obtenerTodosLosAutores();
    }

    @PutMapping("/{id}/estado")
    public void cambiarEstadoAutor(@PathVariable("id") Long id, @RequestParam("estado") String estado) {
        autoresFacade.cambiarEstadoAutor(id, estado);
    }

    @PostMapping
    public void guardarNuevoAutor(@RequestBody Autores autor) {
        autoresFacade.guardarAutor(autor);
    }

    @GetMapping("/{id}")
    public Autores obtenerAutorPorId(@PathVariable("id") Long id) {
        return autoresFacade.obtenerAutorPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarAutor(@PathVariable("id") String id, @RequestBody Autores autor) {
        autor.setCodigoAut(Long.valueOf(id));
        autoresFacade.guardarAutor(autor);
    }
}
