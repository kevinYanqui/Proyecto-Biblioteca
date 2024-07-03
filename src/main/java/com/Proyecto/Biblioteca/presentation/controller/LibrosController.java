package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.LibrosFacade;
import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.domain.model.Libros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    private LibrosFacade librosFacade;

    @GetMapping("/libros")
    public String listarLibros(Model model) {
        List<Libros> libros = librosFacade.obtenerTodosLosLibros();
        model.addAttribute("libros", libros);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "fLibros";
    }

    @GetMapping("/cambiarEstadoLibro")
    public String cambiarEstadoLibro(@RequestParam("id") Long id, @RequestParam("estado") String estado) {
        librosFacade.cambiarEstadoLibro(id, estado);
        return "redirect:/libros";
    }

    @GetMapping("/nuevoLibro")
    public String mostrarFormularioNuevoLibro(Model model) {
        Libros libro = new Libros();
        model.addAttribute("libro", libro);

        List<Autores> autores = librosFacade.obtenerTodosLosAutores();
        model.addAttribute("autores", autores);

        List<Editores> editores = librosFacade.obtenerTodosLosEditores();
        model.addAttribute("editores", editores);

        List<Categoria> categorias = librosFacade.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        return "fNuevoLibros";
    }

    @PostMapping("/guardarNuevoLibro")
    public String guardarNuevoLibro(@ModelAttribute("libro") Libros libro) {
        librosFacade.guardarLibro(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editarLibro")
    public String mostrarFormularioEditarLibro(@RequestParam("id") Long id, Model model) {
        Libros libro = librosFacade.obtenerLibroPorId(id);
        model.addAttribute("libro", libro);

        List<Autores> autores = librosFacade.obtenerTodosLosAutores();
        model.addAttribute("autores", autores);

        List<Editores> editores = librosFacade.obtenerTodosLosEditores();
        model.addAttribute("editores", editores);

        List<Categoria> categorias = librosFacade.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        return "fEditarLibros";
    }

    @PostMapping("/actualizarLibro")
    public String actualizarLibro(@ModelAttribute("libro") Libros libro) {
        librosFacade.guardarLibro(libro);
        return "redirect:/libros";
    }
}
