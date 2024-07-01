package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/empleado")
    public String showLoginForm() {
        return "fEmpleado";
    }
}
