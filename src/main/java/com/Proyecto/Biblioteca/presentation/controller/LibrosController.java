package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.domain.model.Libros;
import com.Proyecto.Biblioteca.business.service.AutoresService;
import com.Proyecto.Biblioteca.business.service.CategoriaService;
import com.Proyecto.Biblioteca.business.service.EditoresService;
import com.Proyecto.Biblioteca.business.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LibrosController {

    @Autowired
    private LibrosService librosService;
    @Autowired
    private AutoresService autoresService;
    @Autowired
    private EditoresService editoresService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/libros")
    public String listarLibros(Model model) {
        List<Libros> libros = librosService.obtenerTodosLosLibros();
        model.addAttribute("libros", libros);
        return "fLibros";
    }

    @GetMapping("/cambiarEstadoLibro")
    public String cambiarEstadoLibro(@RequestParam("id") Long id, @RequestParam("estado") String estado) {
        librosService.cambiarEstadoLibro(id, estado);
        return "redirect:/libros";
    }

    @GetMapping("/nuevoLibro")
    public String mostrarFormularioNuevoLibro(Model model) {
        Libros libro = new Libros();
        model.addAttribute("libro", libro);

        List<Autores> autores = autoresService.obtenerTodosLosAutores();
        model.addAttribute("autores", autores);

        List<Editores> editores = editoresService.obtenerTodosLosEditores();
        model.addAttribute("editores", editores);

        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        return "fNuevoLibros";
    }

    @PostMapping("/guardarNuevoLibro")
    public String guardarNuevoLibro(@ModelAttribute("libro") Libros libro) {
        librosService.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editarLibro")
    public String mostrarFormularioEditarLibro(@RequestParam("id") Long id, Model model) {
        Libros libro = librosService.obtenerLibroPorId(id);
        model.addAttribute("libro", libro);

        List<Autores> autores = autoresService.obtenerTodosLosAutores();
        model.addAttribute("autores", autores);

        List<Editores> editores = editoresService.obtenerTodosLosEditores();
        model.addAttribute("editores", editores);

        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        return "fEditarLibros";
    }

    @PostMapping("/actualizarLibro")
    public String actualizarLibro(@ModelAttribute("libro") Libros libro) {
        librosService.guardarLibro(libro);
        return "redirect:/libros";
    }
}
