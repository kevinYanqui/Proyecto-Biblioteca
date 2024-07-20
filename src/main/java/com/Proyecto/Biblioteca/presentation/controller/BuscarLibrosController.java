package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.LibrosService;
import com.Proyecto.Biblioteca.domain.model.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class BuscarLibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping("/buscar")
    public List<Libros> buscarLibros(@RequestParam(name = "query", required = false) String query,
                                     @RequestParam(name = "filtro", required = false) String filtro) {
        if (query == null || query.isEmpty()) {
            return librosService.obtenerTodosLosLibros();
        } else {
            switch (filtro) {
                case "Título":
                    return librosService.buscarLibrosPorTitulo(query);
                case "Autor":
                    return librosService.buscarLibrosPorAutor(query);
                case "Editor":
                    return librosService.buscarLibrosPorEditor(query);
                default:
                    return librosService.obtenerTodosLosLibros();
            }
        }
    }
}
