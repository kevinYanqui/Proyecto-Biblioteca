package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.Prestamo;

import java.util.List;

public interface PrestamosService {
    List<Prestamo> obtenerTodosLosPrestamos();
}
