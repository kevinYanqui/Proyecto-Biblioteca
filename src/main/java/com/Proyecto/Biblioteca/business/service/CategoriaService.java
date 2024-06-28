package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    void cambiarEstadoCategoria(String id, String estado);
    Categoria obtenerCategoriaPorId(String id);
    void guardarCategoria(Categoria categoria);
}
