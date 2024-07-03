package com.Proyecto.Biblioteca.business.facade.impl;

import com.Proyecto.Biblioteca.business.facade.EditoresFacade;
import com.Proyecto.Biblioteca.business.service.EditoresService;
import com.Proyecto.Biblioteca.domain.model.Editores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EditoresFacadeImpl implements EditoresFacade {

    @Autowired
    private EditoresService editoresService;

    @Override
    public List<Editores> obtenerTodosLosEditores() {
        return editoresService.obtenerTodosLosEditores();
    }

    @Override
    public void cambiarEstadoEditores(String id, String estado) {
        editoresService.cambiarEstadoEditores(id, estado);
    }

    @Override
    public Editores obtenerEditoresPorId(String id) {
        return editoresService.obtenerEditoresPorId(id);
    }

    @Override
    public void guardarEditores(Editores editores) {
        editoresService.guardarEditores(editores);
    }
}
