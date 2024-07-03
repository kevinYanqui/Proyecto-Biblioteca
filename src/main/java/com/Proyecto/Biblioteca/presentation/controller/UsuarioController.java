package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.UsuarioFacade;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    private UsuarioFacade usuarioFacade;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioFacade.obtenerTodosLosUsuarios();
        model.addAttribute("usuarios", usuarios);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "fUsuarios";
    }

    @GetMapping("/cambiarEstadoUsuario")
    public String cambiarEstadoUsuario(@RequestParam("id") Long id, @RequestParam("estado") String estado) {
        usuarioFacade.cambiarEstadoUsuario(id, estado);
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
        usuarioFacade.guardarUsuario(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editarUsuario")
    public String mostrarFormularioEditarUsuario(Model model) {
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        Usuario usuario = usuarioFacade.buscarPorNombreUsuario(username).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        model.addAttribute("usuario", usuario);
        return "fEditarEmpleado";
    }

    @PostMapping("/actualizarUsuario")
    public String actualizarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        Usuario usuarioExistente = usuarioFacade.obtenerUsuarioPorId(usuario.getCodigoUsu());
        usuario.setTipoUsu(usuarioExistente.getTipoUsu());
        usuario.setDocumentodeidentidad(usuarioExistente.getDocumentodeidentidad());
        usuario.setFachaNacUsu(usuarioExistente.getFachaNacUsu());
        usuario.setFechaRegistroUsu(usuarioExistente.getFechaRegistroUsu());
        usuario.setEstadoUsuario(usuarioExistente.getEstadoUsuario());
        usuario.setPswSesesionUs(usuarioExistente.getPswSesesionUs());
        usuarioFacade.guardarUsuario(usuario);
        return "redirect:/empleado";
    }
}
