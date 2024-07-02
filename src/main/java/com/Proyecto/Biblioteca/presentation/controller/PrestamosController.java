package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.PrestamosService;
import com.Proyecto.Biblioteca.domain.model.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PrestamosController {
    @Autowired
    private PrestamosService prestamosService;

    @GetMapping("/prestamosUsu")
    public String empleado(Model model) {
        List<Prestamo> prestamos = prestamosService.obtenerTodosLosPrestamos();
        model.addAttribute("prestamos", prestamos);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "fPrestamosUsu";
    }
}
