package com.Proyecto.Biblioteca.Service;

import com.Proyecto.Biblioteca.business.service.impl.UsuarioServiceImpl;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import com.Proyecto.Biblioteca.persistence.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UsuarioServiceImplTests {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testObtenerTodosLosUsuarios() {
        // Arrange
        Usuario usuario1 = new Usuario();
        usuario1.setCodigoUsu(1L);
        usuario1.setNombresUsu("Juan");
        usuario1.setEstadoUsuario("Activo");

        Usuario usuario2 = new Usuario();
        usuario2.setCodigoUsu(2L);
        usuario2.setNombresUsu("Ana");
        usuario2.setEstadoUsuario("Inactivo");

        List<Usuario> listaUsuarios = Arrays.asList(usuario1, usuario2);

        when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

        // Act
        List<Usuario> result = usuarioService.obtenerTodosLosUsuarios();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Juan", result.get(0).getNombresUsu());
        assertEquals("Ana", result.get(1).getNombresUsu());
    }

    @Test
    public void testCambiarEstadoUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setCodigoUsu(1L);
        usuario.setEstadoUsuario("Activo");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Act
        usuarioService.cambiarEstadoUsuario(1L, "Inactivo");

        // Assert
        assertEquals("Inactivo", usuario.getEstadoUsuario());
        verify(usuarioRepository).save(usuario);
    }

    @Test
    public void testObtenerUsuarioPorId() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setCodigoUsu(1L);
        usuario.setNombresUsu("Juan");

        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Act
        Usuario result = usuarioService.obtenerUsuarioPorId(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Juan", result.getNombresUsu());
    }

    @Test
    public void testGuardarUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setCodigoUsu(1L);
        usuario.setNombresUsu("Juan");

        // Act
        usuarioService.guardarUsuario(usuario);

        // Assert
        verify(usuarioRepository).save(usuario);
    }

    @Test
    public void testBuscarPorNombreUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setCodigoUsu(1L);
        usuario.setNombresSesisonUsu("juan123");

        when(usuarioRepository.findByNombresSesisonUsu("juan123")).thenReturn(Optional.of(usuario));

        // Act
        Optional<Usuario> result = usuarioService.buscarPorNombreUsuario("juan123");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("juan123", result.get().getNombresSesisonUsu());
    }
}
