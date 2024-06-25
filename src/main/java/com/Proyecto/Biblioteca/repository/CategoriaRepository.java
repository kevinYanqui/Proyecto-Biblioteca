package com.Proyecto.Biblioteca.repository;

import com.Proyecto.Biblioteca.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
