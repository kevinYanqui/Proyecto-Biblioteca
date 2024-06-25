package com.Proyecto.Biblioteca.service;

import com.Proyecto.Biblioteca.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    void cambiarEstadoCategoria(String id, String estado);
    Categoria obtenerCategoriaPorId(String id);
    void guardarCategoria(Categoria categoria);
}
