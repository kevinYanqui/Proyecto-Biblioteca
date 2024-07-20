package com.Proyecto.Biblioteca.Service;

import com.Proyecto.Biblioteca.business.service.impl.CategoriaServiceImpl;
import com.Proyecto.Biblioteca.domain.model.Categoria;
import com.Proyecto.Biblioteca.persistence.repository.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoriaServiceImplTests {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaServiceImpl categoriaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarCategoria() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setCodigoGen(1L);
        categoria.setNombresGen("Ficción");
        categoria.setDescripcionGen("Libros de ficción");
        categoria.setEstadoCat("Activo");

        when(categoriaRepository.save(categoria)).thenReturn(categoria);

        // Act
        categoriaService.guardarCategoria(categoria);

        // Assert
        verify(categoriaRepository, times(1)).save(categoria);
    }

    @Test
    public void testObtenerCategoriaPorId() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setCodigoGen(1L);
        categoria.setNombresGen("Ficción");
        categoria.setDescripcionGen("Libros de ficción");
        categoria.setEstadoCat("Activo");

        when(categoriaRepository.findById(String.valueOf(1L))).thenReturn(Optional.of(categoria));

        // Act
        Categoria result = categoriaService.obtenerCategoriaPorId(String.valueOf(1L));

        // Assert
        assertNotNull(result);
        assertEquals("Ficción", result.getNombresGen());
        assertEquals("Libros de ficción", result.getDescripcionGen());
    }

    @Test
    public void testCambiarEstadoCategoria() {
        // Arrange
        Categoria categoria = new Categoria();
        categoria.setCodigoGen(1L);
        categoria.setEstadoCat("Activo");

        when(categoriaRepository.findById(String.valueOf(1L))).thenReturn(Optional.of(categoria));

        // Act
        categoriaService.cambiarEstadoCategoria(String.valueOf(1L), "Inactivo");

        // Assert
        verify(categoriaRepository, times(1)).save(categoria);
        assertEquals("Inactivo", categoria.getEstadoCat());
    }
}
