package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.HistorialReserva;
import java.util.List;

public interface HistorialReservaService {
    List<HistorialReserva> findByUsuario(String username);
}
