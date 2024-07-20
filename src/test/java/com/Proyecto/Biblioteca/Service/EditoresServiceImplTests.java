package com.Proyecto.Biblioteca.Service;

import com.Proyecto.Biblioteca.business.service.impl.EditoresServiceImpl;
import com.Proyecto.Biblioteca.domain.model.Editores;
import com.Proyecto.Biblioteca.persistence.repository.EditoresRepository;
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

public class EditoresServiceImplTests {

    @Mock
    private EditoresRepository editoresRepository;

    @InjectMocks
    private EditoresServiceImpl editoresService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGuardarEditores() {
        // Arrange
        Editores editor = new Editores();
        editor.setCodigoEdi(1L);
        editor.setNomEdi("Editorial ABC");
        editor.setDireccion("Calle Falsa 123");
        editor.setEstadoEdi("Activo");

        when(editoresRepository.save(editor)).thenReturn(editor);

        // Act
        editoresService.guardarEditores(editor);

        // Assert
        verify(editoresRepository, times(1)).save(editor);
    }

    @Test
    public void testObtenerEditoresPorId() {
        // Arrange
        Editores editor = new Editores();
        editor.setCodigoEdi(1L);
        editor.setNomEdi("Editorial ABC");
        editor.setDireccion("Calle Falsa 123");
        editor.setEstadoEdi("Activo");

        when(editoresRepository.findById(String.valueOf(1L))).thenReturn(Optional.of(editor));

        // Act
        Editores result = editoresService.obtenerEditoresPorId(String.valueOf(1L));

        // Assert
        assertNotNull(result);
        assertEquals("Editorial ABC", result.getNomEdi());
        assertEquals("Calle Falsa 123", result.getDireccion());
    }

    @Test
    public void testCambiarEstadoEditores() {
        // Arrange
        Editores editor = new Editores();
        editor.setCodigoEdi(1L);
        editor.setEstadoEdi("Activo");

        when(editoresRepository.findById(String.valueOf(1L))).thenReturn(Optional.of(editor));

        // Act
        editoresService.cambiarEstadoEditores(String.valueOf(1L), "Inactivo");

        // Assert
        verify(editoresRepository, times(1)).save(editor);
        assertEquals("Inactivo", editor.getEstadoEdi());
    }

    @Test
    public void testObtenerTodosLosEditores() {
        // Arrange
        Editores editor1 = new Editores();
        editor1.setCodigoEdi(1L);
        editor1.setNomEdi("Editorial ABC");

        Editores editor2 = new Editores();
        editor2.setCodigoEdi(2L);
        editor2.setNomEdi("Editorial XYZ");

        List<Editores> listaEditores = Arrays.asList(editor1, editor2);

        when(editoresRepository.findAll()).thenReturn(listaEditores);

        // Act
        List<Editores> result = editoresService.obtenerTodosLosEditores();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Editorial ABC", result.get(0).getNomEdi());
        assertEquals("Editorial XYZ", result.get(1).getNomEdi());
    }
}
