package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.business.service.EditoresService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EditoresService editoresService;

    @GetMapping("/editores")
    public String listarEditores(Model model) {
        List<Editores> editores = editoresService.obtenerTodosLosEditores();
        model.addAttribute("editores", editores);
        return "fEditores";
    }

    @GetMapping("/cambiarEstadoEditor")
    public String cambiarEstadoEditor(@RequestParam("id") String id, @RequestParam("estado") String estado) {
        editoresService.cambiarEstadoEditores(id, estado);
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
        editoresService.guardarEditores(editor);
        return "redirect:/editores";
    }

    @GetMapping("/editarEditor")
    public String mostrarFormularioEditarEditor(@RequestParam("id") String id, Model model) {
        Editores editor = editoresService.obtenerEditoresPorId(id);
        model.addAttribute("editor", editor);
        return "fEditarEditores";
    }

    @PostMapping("/actualizarEditor")
    public String actualizarEditor(@ModelAttribute("editor") Editores editor) {
        editoresService.guardarEditores(editor);
        return "redirect:/editores";
    }
}
