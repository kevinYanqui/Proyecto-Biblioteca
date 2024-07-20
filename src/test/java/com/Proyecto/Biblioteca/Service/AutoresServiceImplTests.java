package com.Proyecto.Biblioteca.Service;

import com.Proyecto.Biblioteca.business.service.impl.AutoresServiceImpl;
import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.persistence.repository.AutoresRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AutoresServiceImplTests {

    @Mock
    private AutoresRepository autoresRepository;

    @InjectMocks
    private AutoresServiceImpl autoresService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarAutor() {
        // Arrange
        Autores autor = new Autores();
        autor.setCodigoAut(1L);
        autor.setNombresAut("Juan");
        autor.setApeAut("Perez");
        autor.setEstadoAut("Activo");

        when(autoresRepository.save(autor)).thenReturn(autor);

        // Act
        autoresService.guardarAutor(autor);

        // Assert
        verify(autoresRepository, times(1)).save(autor);
    }

    @Test
    public void testObtenerAutorPorId() {
        // Arrange
        Autores autor = new Autores();
        autor.setCodigoAut(1L);
        autor.setNombresAut("Juan");
        autor.setApeAut("Perez");
        autor.setEstadoAut("Activo");

        when(autoresRepository.findById((1L))).thenReturn(Optional.of(autor));

        // Act
        Autores result = autoresService.obtenerAutorPorId((1L));

        // Assert
        assertNotNull(result);
        assertEquals("Juan", result.getNombresAut());
        assertEquals("Perez", result.getApeAut());
    }

    @Test
    public void testCambiarEstadoAutor() {
        // Arrange
        Autores autor = new Autores();
        autor.setCodigoAut(1L);
        autor.setEstadoAut("Activo");

        when(autoresRepository.findById(1L)).thenReturn(Optional.of(autor));

        // Act
        autoresService.cambiarEstadoAutor((1L), "Inactivo");

        // Assert
        verify(autoresRepository, times(1)).save(autor);
        assertEquals("Inactivo", autor.getEstadoAut());
    }
}
