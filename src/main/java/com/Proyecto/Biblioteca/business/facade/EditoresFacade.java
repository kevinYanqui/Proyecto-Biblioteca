package com.Proyecto.Biblioteca.business.facade;

import com.Proyecto.Biblioteca.domain.model.Editores;

import java.util.List;

public interface EditoresFacade {
    List<Editores> obtenerTodosLosEditores();
    void cambiarEstadoEditores(String id, String estado);
    Editores obtenerEditoresPorId(String id);
    void guardarEditores(Editores editores);
}
