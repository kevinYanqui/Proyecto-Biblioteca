package com.Proyecto.Biblioteca.controller;

import com.Proyecto.Biblioteca.model.Categoria;
import com.Proyecto.Biblioteca.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);
        return "fCategorias";
    }

    @GetMapping("/cambiarEstadoCategoria")
    public String cambiarEstadoCategoria(@RequestParam("id") String id, @RequestParam("estado") String estado) {
        categoriaService.cambiarEstadoCategoria(id, estado);
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
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editarCategoria")
    public String mostrarFormularioEditarCategoria(@RequestParam("id") String id, Model model) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        model.addAttribute("categoria", categoria);
        return "fEditarCategoria";
    }

    @PostMapping("/actualizarCategoria")
    public String actualizarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }
}
