package com.Proyecto.Biblioteca.persistence.repository;

import com.Proyecto.Biblioteca.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
