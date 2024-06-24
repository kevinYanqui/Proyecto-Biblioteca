package com.Proyecto.Biblioteca.repository;

import com.Proyecto.Biblioteca.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autores, String> {
}
