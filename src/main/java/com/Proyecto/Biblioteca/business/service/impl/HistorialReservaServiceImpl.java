package com.Proyecto.Biblioteca.business.service.impl;

import com.Proyecto.Biblioteca.domain.model.HistorialReserva;
import com.Proyecto.Biblioteca.persistence.repository.HistorialReservaRepository;
import com.Proyecto.Biblioteca.business.service.HistorialReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistorialReservaServiceImpl implements HistorialReservaService {

    @Autowired
    private HistorialReservaRepository historialReservaRepository;

    @Override
    public List<HistorialReserva> findByUsuario(String username) {
        return historialReservaRepository.findByUsuario(username);
    }
}