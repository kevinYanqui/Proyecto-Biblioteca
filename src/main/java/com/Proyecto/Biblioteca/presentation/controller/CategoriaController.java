package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.CategoriaFacade;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaFacade categoriaFacade;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaFacade.obtenerTodasLasCategorias();
    }

    @PutMapping("/{id}/estado")
    public void cambiarEstadoCategoria(@PathVariable("id") String id, @RequestParam("estado") String estado) {
        categoriaFacade.cambiarEstadoCategoria(id, estado);
    }

    @PostMapping
    public void guardarNuevaCategoria(@RequestBody Categoria categoria) {
        categoriaFacade.guardarCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoriaPorId(@PathVariable("id") String id) {
        return categoriaFacade.obtenerCategoriaPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarCategoria(@PathVariable("id") String id, @RequestBody Categoria categoria) {
        categoria.setCodigoGen(Long.valueOf(id));
        categoriaFacade.guardarCategoria(categoria);
    }
}
