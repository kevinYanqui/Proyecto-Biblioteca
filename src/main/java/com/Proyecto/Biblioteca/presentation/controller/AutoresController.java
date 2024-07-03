package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.AutoresFacade;
import com.Proyecto.Biblioteca.domain.model.Autores;
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
public class AutoresController {

    @Autowired
    private AutoresFacade autoresFacade;

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        List<Autores> autores = autoresFacade.obtenerTodosLosAutores();
        model.addAttribute("autores", autores);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "fAutores";
    }

    @GetMapping("/cambiarEstadoAutor")
    public String cambiarEstadoAutor(@RequestParam("id") String id, @RequestParam("estado") String estado) {
        autoresFacade.cambiarEstadoAutor(id, estado);
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
        autoresFacade.guardarAutor(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editarAutor")
    public String mostrarFormularioEditarAutor(@RequestParam("id") String id, Model model) {
        Autores autor = autoresFacade.obtenerAutorPorId(id);
        model.addAttribute("autor", autor);
        return "fEditarAutores";
    }

    @PostMapping("/actualizarAutor")
    public String actualizarAutor(@ModelAttribute("autor") Autores autor) {
        autoresFacade.guardarAutor(autor);
        return "redirect:/autores";
    }
}
