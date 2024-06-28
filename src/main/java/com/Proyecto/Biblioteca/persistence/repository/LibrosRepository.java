package com.Proyecto.Biblioteca.persistence.repository;

import com.Proyecto.Biblioteca.domain.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libros, Long> {
}
