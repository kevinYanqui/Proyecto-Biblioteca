package com.Proyecto.Biblioteca.business.service.impl;

import com.Proyecto.Biblioteca.business.service.PrestamosService;
import com.Proyecto.Biblioteca.domain.model.Prestamo;
import com.Proyecto.Biblioteca.persistence.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamosServiceImpl implements PrestamosService {
    @Autowired
    private PrestamoRepository prestamosRepository;

    @Override
    public List<Prestamo> obtenerTodosLosPrestamos() {
        return prestamosRepository.findAll();
    }
}
