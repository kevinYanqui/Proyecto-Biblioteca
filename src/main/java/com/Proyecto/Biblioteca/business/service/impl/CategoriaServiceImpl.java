package com.Proyecto.Biblioteca.business.service.impl;

import com.Proyecto.Biblioteca.business.service.CategoriaService;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import com.Proyecto.Biblioteca.persistence.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public void cambiarEstadoCategoria(String id, String estado) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        categoria.setEstadoCat(estado);
        categoriaRepository.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(String id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
