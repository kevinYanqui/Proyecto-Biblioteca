package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.UsuarioService;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/registro")
public class RegistrationController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/admin")
    public String mostrarFormularioRegistroAdmin(Model model) {
        Usuario usuario = new Usuario();
        usuario.setTipoUsu("Administrador");
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    @GetMapping("/usuario")
    public String mostrarFormularioRegistroUsuario(Model model) {
        Usuario usuario = new Usuario();
        usuario.setTipoUsu("Lector");
        model.addAttribute("usuario", usuario);
        return "registro";
    }

    @PostMapping("/admin")
    public String registrarUsuarioAdmin(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Optional<Usuario> existingUser = usuarioService.buscarPorNombreUsuario(usuario.getNombresSesisonUsu());
        if (existingUser.isPresent()) {
            model.addAttribute("error", "El nombre de usuario ya existe.");
            return "registro";
        }
        usuario.setTipoUsu("Administrador");
        usuario.setEstadoUsuario("Habilitado");
        LocalDate fechaActual = LocalDate.now();
        String fechaRegistro = fechaActual.toString();
        usuario.setFechaRegistroUsu(LocalDate.parse(fechaRegistro));
        usuario.setPswSesesionUs(passwordEncoder.encode(usuario.getPswSesesionUs()));
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login";
    }

    @PostMapping("/usuario")
    public String registrarUsuarioLector(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Optional<Usuario> existingUser = usuarioService.buscarPorNombreUsuario(usuario.getNombresSesisonUsu());
        if (existingUser.isPresent()) {
            model.addAttribute("error", "El nombre de usuario ya existe.");
            return "registro";
        }
        usuario.setTipoUsu("Lector");
        usuario.setEstadoUsuario("Habilitado");
        LocalDate fechaActual = LocalDate.now();
        String fechaRegistro = fechaActual.toString();
        usuario.setFechaRegistroUsu(LocalDate.parse(fechaRegistro));
        usuario.setPswSesesionUs(passwordEncoder.encode(usuario.getPswSesesionUs()));
        usuarioService.guardarUsuario(usuario);
        return "redirect:/login";
    }
}
