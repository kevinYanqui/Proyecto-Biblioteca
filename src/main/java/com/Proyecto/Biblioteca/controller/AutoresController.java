package com.Proyecto.Biblioteca.controller;

import com.Proyecto.Biblioteca.model.Autores;
import com.Proyecto.Biblioteca.service.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        List<Autores> autores = autoresService.obtenerTodosLosAutores();
        model.addAttribute("autores", autores);
        return "fAutores";
    }

    @GetMapping("/cambiarEstado")
    public String cambiarEstado(@RequestParam("id") String id, @RequestParam("estado") String estado) {
        autoresService.cambiarEstado(id, estado);
        return "redirect:/autores";
    }

    @GetMapping("/nuevoAutor")
    public String mostrarFormularioNuevoAutor(Model model) {
        Autores autor = new Autores();
        model.addAttribute("autor", autor);
        return "fNuevoAutores";
    }

    @PostMapping("/guardarNuevoAutor")
    public String guardarNuevoAutor(@ModelAttribute("autor") Autores autor) {
        autoresService.actualizarAutor(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editarAutor")
    public String editarAutor(@RequestParam("id") String id, Model model) {
        Autores autor = autoresService.obtenerAutorPorId(id);
        model.addAttribute("autor", autor);
        return "fEditarAutores";
    }

    @PostMapping("/guardarAutor")
    public String guardarAutor(@ModelAttribute("autor") Autores autor) {
        autoresService.actualizarAutor(autor);
        return "redirect:/autores";
    }
}