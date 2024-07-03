package com.Proyecto.Biblioteca.business.facade.impl;

import com.Proyecto.Biblioteca.business.facade.UsuarioFacade;
import com.Proyecto.Biblioteca.business.service.UsuarioService;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UsuarioFacadeImpl implements UsuarioFacade {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @Override
    public void cambiarEstadoUsuario(Long id, String estado) {
        usuarioService.cambiarEstadoUsuario(id, estado);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setPswSesesionUs(passwordEncoder.encode(usuario.getPswSesesionUs()));
        usuarioService.guardarUsuario(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorNombreUsuario(String nombresSesisonUsu) {
        return usuarioService.buscarPorNombreUsuario(nombresSesisonUsu);
    }
}
