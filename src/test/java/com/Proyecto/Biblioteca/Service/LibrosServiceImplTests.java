package com.Proyecto.Biblioteca.Service;

import com.Proyecto.Biblioteca.business.service.impl.LibrosServiceImpl;
import com.Proyecto.Biblioteca.domain.model.Autores;
import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.domain.model.Libros;
import com.Proyecto.Biblioteca.persistence.repository.LibrosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LibrosServiceImplTests {

    @Mock
    private LibrosRepository librosRepository;

    @InjectMocks
    private LibrosServiceImpl librosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarLibro() {
        // Arrange
        Libros libro = new Libros();
        libro.setCodigoLib(1L);
        libro.setTituloLib("El Gran Libro");
        libro.setEstadoLibros("Disponible");

        when(librosRepository.save(libro)).thenReturn(libro);

        // Act
        librosService.guardarLibro(libro);

        // Assert
        verify(librosRepository, times(1)).save(libro);
    }

    @Test
    public void testObtenerLibroPorId() {
        // Arrange
        Libros libro = new Libros();
        libro.setCodigoLib(1L);
        libro.setTituloLib("El Gran Libro");

        when(librosRepository.findById(1L)).thenReturn(Optional.of(libro));

        // Act
        Libros result = librosService.obtenerLibroPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("El Gran Libro", result.getTituloLib());
    }

    @Test
    public void testCambiarEstadoLibro() {
        // Arrange
        Libros libro = new Libros();
        libro.setCodigoLib(1L);
        libro.setEstadoLibros("Disponible");

        when(librosRepository.findById(1L)).thenReturn(Optional.of(libro));

        // Act
        librosService.cambiarEstadoLibro(1L, "No Disponible");

        // Assert
        verify(librosRepository, times(1)).save(libro);
        assertEquals("No Disponible", libro.getEstadoLibros());
    }

    @Test
    public void testObtenerTodosLosLibros() {
        // Arrange
        Libros libro1 = new Libros();
        libro1.setCodigoLib(1L);
        libro1.setTituloLib("El Gran Libro");

        Libros libro2 = new Libros();
        libro2.setCodigoLib(2L);
        libro2.setTituloLib("El Segundo Libro");

        List<Libros> listaLibros = Arrays.asList(libro1, libro2);

        when(librosRepository.findAll()).thenReturn(listaLibros);

        // Act
        List<Libros> result = librosService.obtenerTodosLosLibros();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("El Gran Libro", result.get(0).getTituloLib());
        assertEquals("El Segundo Libro", result.get(1).getTituloLib());
    }

    @Test
    public void testBuscarLibrosPorTitulo() {
        // Arrange
        Libros libro1 = new Libros();
        libro1.setCodigoLib(1L);
        libro1.setTituloLib("El Gran Libro");

        Libros libro2 = new Libros();
        libro2.setCodigoLib(2L);
        libro2.setTituloLib("El Gran Libro II");

        List<Libros> listaLibros = Arrays.asList(libro1, libro2);

        when(librosRepository.findByTituloLibContaining("Gran Libro")).thenReturn(listaLibros);

        // Act
        List<Libros> result = librosService.buscarLibrosPorTitulo("Gran Libro");

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("El Gran Libro", result.get(0).getTituloLib());
        assertEquals("El Gran Libro II", result.get(1).getTituloLib());
    }

    @Test
    public void testBuscarLibrosPorAutor() {
        // Arrange
        Libros libro1 = new Libros();
        libro1.setCodigoLib(1L);
        libro1.setCodigoAut(new Autores());
        libro1.getCodigoAut().setNombresAut("Juan");

        Libros libro2 = new Libros();
        libro2.setCodigoLib(2L);
        libro2.setCodigoAut(new Autores());
        libro2.getCodigoAut().setNombresAut("Juan");

        List<Libros> listaLibros = Arrays.asList(libro1, libro2);

        when(librosRepository.findByCodigoAut_NombresAutContaining("Juan")).thenReturn(listaLibros);

        // Act
        List<Libros> result = librosService.buscarLibrosPorAutor("Juan");

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getCodigoAut().getNombresAut());
    }

    @Test
    public void testBuscarLibrosPorEditor() {
        // Arrange
        Libros libro1 = new Libros();
        libro1.setCodigoLib(1L);
        libro1.setCodigoEdi(new Editores());
        libro1.getCodigoEdi().setNomEdi("Editorial ABC");

        Libros libro2 = new Libros();
        libro2.setCodigoLib(2L);
        libro2.setCodigoEdi(new Editores());
        libro2.getCodigoEdi().setNomEdi("Editorial ABC");

        List<Libros> listaLibros = Arrays.asList(libro1, libro2);

        when(librosRepository.findByCodigoEdi_NomEdiContaining("Editorial ABC")).thenReturn(listaLibros);

        // Act
        List<Libros> result = librosService.buscarLibrosPorEditor("Editorial ABC");

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Editorial ABC", result.get(0).getCodigoEdi().getNomEdi());
    }
}
