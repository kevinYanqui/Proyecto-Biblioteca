package com.Proyecto.Biblioteca.persistence.repository;

import com.Proyecto.Biblioteca.domain.model.Editores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoresRepository extends JpaRepository<Editores, String> {
}
