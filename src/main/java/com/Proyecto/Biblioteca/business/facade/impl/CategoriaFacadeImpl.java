package com.Proyecto.Biblioteca.business.facade.impl;

import com.Proyecto.Biblioteca.business.facade.CategoriaFacade;
import com.Proyecto.Biblioteca.business.service.CategoriaService;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaFacadeImpl implements CategoriaFacade {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaService.obtenerTodasLasCategorias();
    }

    @Override
    public void cambiarEstadoCategoria(String id, String estado) {
        categoriaService.cambiarEstadoCategoria(id, estado);
    }

    @Override
    public Categoria obtenerCategoriaPorId(String id) {
        return categoriaService.obtenerCategoriaPorId(id);
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
    }
}
