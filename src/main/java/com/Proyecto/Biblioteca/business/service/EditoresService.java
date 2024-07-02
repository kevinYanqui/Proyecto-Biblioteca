package com.Proyecto.Biblioteca.business.service;

import com.Proyecto.Biblioteca.domain.model.Editores;

import java.util.List;

public interface EditoresService {
    List<Editores> obtenerTodosLosEditores();
    void cambiarEstadoEditores(String id, String estado);
    Editores obtenerEditoresPorId(String id);
    void guardarEditores(Editores edtores);
}
