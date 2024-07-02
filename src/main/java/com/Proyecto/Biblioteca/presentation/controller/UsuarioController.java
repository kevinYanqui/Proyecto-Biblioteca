package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.domain.model.Usuario;
import com.Proyecto.Biblioteca.business.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "fUsuarios";
    }

    @GetMapping("/cambiarEstadoUsuario")
    public String cambiarEstadoUsuario(@RequestParam("id") Long id, @RequestParam("estado") String estado) {
        usuarioService.cambiarEstadoUsuario(id, estado);
        return "redirect:/usuarios";
    }

    @GetMapping("/nuevoUsuario")
    public String mostrarFormularioNuevoUsuario(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "fNuevoUsuarios";
    }

    @PostMapping("/guardarNuevoUsuario")
    public String guardarNuevoUsuario(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }
}

