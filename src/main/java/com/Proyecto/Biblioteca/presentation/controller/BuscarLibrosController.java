package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.domain.model.Libros;
import com.Proyecto.Biblioteca.business.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuscarLibrosController {

    @Autowired
    private LibrosService librosService;

    @GetMapping("/buscarLibros")
    public String buscarLibros(@RequestParam(name = "query", required = false) String query,
                               @RequestParam(name = "filtro", required = false) String filtro, Model model) {
        List<Libros> libros;

        if (query == null || query.isEmpty()) {
            libros = librosService.obtenerTodosLosLibros();
        } else {
            switch (filtro) {
                case "Título":
                    libros = librosService.buscarLibrosPorTitulo(query);
                    break;
                case "Autor":
                    libros = librosService.buscarLibrosPorAutor(query);
                    break;
                case "Editor":
                    libros = librosService.buscarLibrosPorEditor(query);
                    break;
                default:
                    libros = librosService.obtenerTodosLosLibros();
            }
        }

        model.addAttribute("libros", libros);
        return "buscarLibros";
    }
}
