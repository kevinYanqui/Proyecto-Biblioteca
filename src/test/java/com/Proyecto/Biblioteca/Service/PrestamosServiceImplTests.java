package com.Proyecto.Biblioteca.Service;

import com.Proyecto.Biblioteca.business.service.impl.PrestamosServiceImpl;
import com.Proyecto.Biblioteca.domain.model.Prestamo;
import com.Proyecto.Biblioteca.persistence.repository.PrestamoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PrestamosServiceImplTests {

    @Mock
    private PrestamoRepository prestamosRepository;

    @InjectMocks
    private PrestamosServiceImpl prestamosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerTodosLosPrestamos() {
        // Arrange
        Prestamo prestamo1 = new Prestamo();
        prestamo1.setIdPrestamo(1L);
        prestamo1.setUsuario("Usuario1");
        prestamo1.setAutor("Autor1");
        prestamo1.setFechaPrestamo(LocalDateTime.now());
        prestamo1.setFechaDevolucion(LocalDateTime.now().plusDays(7));

        Prestamo prestamo2 = new Prestamo();
        prestamo2.setIdPrestamo(2L);
        prestamo2.setUsuario("Usuario2");
        prestamo2.setAutor("Autor2");
        prestamo2.setFechaPrestamo(LocalDateTime.now());
        prestamo2.setFechaDevolucion(LocalDateTime.now().plusDays(14));

        List<Prestamo> listaPrestamos = Arrays.asList(prestamo1, prestamo2);

        when(prestamosRepository.findAll()).thenReturn(listaPrestamos);

        // Act
        List<Prestamo> result = prestamosService.obtenerTodosLosPrestamos();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Usuario1", result.get(0).getUsuario());
        assertEquals("Usuario2", result.get(1).getUsuario());
    }
}
