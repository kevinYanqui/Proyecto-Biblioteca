package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> obtenerTodosLosUsuarios();
    void cambiarEstadoUsuario(Long id, String estado);
    Usuario obtenerUsuarioPorId(Long id);
    void guardarUsuario(Usuario usuario);
    Optional<Usuario> buscarPorNombreUsuario(String nombresSesisonUsu);
}
