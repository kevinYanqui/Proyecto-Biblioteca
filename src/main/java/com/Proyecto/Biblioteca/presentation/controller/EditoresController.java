package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.EditoresFacade;
import com.Proyecto.Biblioteca.domain.model.Editores;
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
public class EditoresController {
    @Autowired
    private EditoresFacade editoresFacade;

    @GetMapping("/editores")
    public String listarEditores(Model model) {
        List<Editores> editores = editoresFacade.obtenerTodosLosEditores();
        model.addAttribute("editores", editores);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "fEditores";
    }

    @GetMapping("/cambiarEstadoEditor")
    public String cambiarEstadoEditor(@RequestParam("id") String id, @RequestParam("estado") String estado) {
        editoresFacade.cambiarEstadoEditores(id, estado);
        return "redirect:/editores";
    }

    @GetMapping("/nuevoEditor")
    public String mostrarFormularioNuevoEditor(Model model) {
        Editores editor = new Editores();
        model.addAttribute("editor", editor);
        return "fNuevoEditores";
    }

    @PostMapping("/guardarNuevoEditor")
    public String guardarNuevoEditor(@ModelAttribute("editor") Editores editor) {
        editoresFacade.guardarEditores(editor);
        return "redirect:/editores";
    }

    @GetMapping("/editarEditor")
    public String mostrarFormularioEditarEditor(@RequestParam("id") String id, Model model) {
        Editores editor = editoresFacade.obtenerEditoresPorId(id);
        model.addAttribute("editor", editor);
        return "fEditarEditores";
    }

    @PostMapping("/actualizarEditor")
    public String actualizarEditor(@ModelAttribute("editor") Editores editor) {
        editoresFacade.guardarEditores(editor);
        return "redirect:/editores";
    }
}
