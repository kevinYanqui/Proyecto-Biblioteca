package com.Proyecto.Biblioteca.persistence.repository;

import com.Proyecto.Biblioteca.domain.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByUsuario(String usuario);
}
