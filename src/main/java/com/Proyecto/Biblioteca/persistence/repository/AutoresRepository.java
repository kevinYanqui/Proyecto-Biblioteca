package com.Proyecto.Biblioteca.persistence.repository;

import com.Proyecto.Biblioteca.domain.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autores, Long> {
}
