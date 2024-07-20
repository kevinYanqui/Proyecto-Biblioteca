package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.PrestamosService;
import com.Proyecto.Biblioteca.domain.model.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrestamosController {
    @Autowired
    private PrestamosService prestamosService;

    @GetMapping("/api/prestamos")
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamosService.obtenerTodosLosPrestamos();
    }

    @GetMapping("/api/username")
    public String obtenerUsername() {
        return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }
}
