package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_Administrador")) {
            return "redirect:/empleado";
        }
        if (roles.contains("ROLE_Lector")) {
            return "redirect:/";
        }
        return "redirect:/login?error=true";
    }

    @GetMapping("/perfilEmpleado")
    public String perfilEmpleado(Authentication authentication, Model model) {
        String username = authentication.getName();
        model.addAttribute("username", username);
        return "empleado";
    }

    @GetMapping("/")
    public String index(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean isLoggedIn = auth != null && auth.isAuthenticated() && !auth.getName().equals("anonymousUser");
        model.addAttribute("isLoggedIn", isLoggedIn);
        return "index";
    }
}
