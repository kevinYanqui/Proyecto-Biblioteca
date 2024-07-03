package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.CategoriaFacade;
import com.Proyecto.Biblioteca.domain.model.Categoria;
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
public class CategoriaController {

    @Autowired
    private CategoriaFacade categoriaFacade;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaFacade.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        model.addAttribute("username", username);
        return "fCategorias";
    }

    @GetMapping("/cambiarEstadoCategoria")
    public String cambiarEstadoCategoria(@RequestParam("id") String id, @RequestParam("estado") String estado) {
        categoriaFacade.cambiarEstadoCategoria(id, estado);
        return "redirect:/categorias";
    }

    @GetMapping("/nuevaCategoria")
    public String mostrarFormularioNuevaCategoria(Model model) {
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        return "fNuevoCategoria";
    }

    @PostMapping("/guardarNuevaCategoria")
    public String guardarNuevaCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaFacade.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editarCategoria")
    public String mostrarFormularioEditarCategoria(@RequestParam("id") String id, Model model) {
        Categoria categoria = categoriaFacade.obtenerCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "fEditarCategoria";
    }

    @PostMapping("/actualizarCategoria")
    public String actualizarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaFacade.guardarCategoria(categoria);
        return "redirect:/categorias";
    }
}
