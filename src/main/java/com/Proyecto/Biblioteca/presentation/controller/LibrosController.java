package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.LibrosFacade;
import com.Proyecto.Biblioteca.domain.model.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibrosController {
    @Autowired
    private LibrosFacade librosFacade;

    @GetMapping
    public List<Libros> listarLibros() {
        return librosFacade.obtenerTodosLosLibros();
    }

    @PutMapping("/{id}/estado")
    public void cambiarEstadoLibro(@PathVariable("id") Long id, @RequestParam("estado") String estado) {
        librosFacade.cambiarEstadoLibro(id, estado);
    }

    @PostMapping
    public void guardarNuevoLibro(@RequestBody Libros libro) {
        librosFacade.guardarLibro(libro);
    }

    @GetMapping("/{id}")
    public Libros obtenerLibroPorId(@PathVariable("id") Long id) {
        return librosFacade.obtenerLibroPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarLibro(@PathVariable("id") Long id, @RequestBody Libros libro) {
        libro.setCodigoLib(id);
        librosFacade.guardarLibro(libro);
    }
}
