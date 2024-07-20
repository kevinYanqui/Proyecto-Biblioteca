package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.UsuarioFacade;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioFacade usuarioFacade;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioFacade.obtenerTodosLosUsuarios();
    }

    @PutMapping("/{id}/estado")
    public void cambiarEstadoUsuario(@PathVariable("id") Long id, @RequestParam("estado") String estado) {
        usuarioFacade.cambiarEstadoUsuario(id, estado);
    }

    @PostMapping
    public void guardarNuevoUsuario(@RequestBody Usuario usuario) {
        usuarioFacade.guardarUsuario(usuario);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuarioPorUsername(@PathVariable("username") String username) {
        return usuarioFacade.buscarPorNombreUsuario(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        usuario.setCodigoUsu(id);
        usuarioFacade.guardarUsuario(usuario);
    }
}
