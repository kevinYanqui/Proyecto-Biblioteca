package com.Proyecto.Biblioteca.business.service.impl;

import com.Proyecto.Biblioteca.business.service.UsuarioService;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import com.Proyecto.Biblioteca.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void cambiarEstadoUsuario(Long id, String estado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setEstadoUsuario(estado);
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    @Override
    public Optional<Usuario> buscarPorNombreUsuario(String nombresSesisonUsu) {
        return usuarioRepository.findByNombresSesisonUsu(nombresSesisonUsu);
    }
}
