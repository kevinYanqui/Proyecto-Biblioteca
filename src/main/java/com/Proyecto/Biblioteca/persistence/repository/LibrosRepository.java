package com.Proyecto.Biblioteca.persistence.repository;

import com.Proyecto.Biblioteca.domain.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Long> {
    List<Libros> findByTituloLibContaining(String titulo);
    List<Libros> findByCodigoAut_NombresAutContaining(String autor);
    List<Libros> findByCodigoEdi_NomEdiContaining(String editor);
}
