package com.Proyecto.Biblioteca.service.impl;


import com.Proyecto.Biblioteca.model.Editores;
import com.Proyecto.Biblioteca.repository.EditoresRepository;
import com.Proyecto.Biblioteca.service.EditoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoresServiceImpl implements EditoresService {
    @Autowired
    private EditoresRepository editoresRepository;

    @Override
    public List<Editores> obtenerTodosLosEditores() {
        return editoresRepository.findAll();
    }

    @Override
    public void cambiarEstadoEditores(String id, String estado) {
        Editores editor = editoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editor no encontrado"));
        editor.setEstadoEdi(estado);
        editoresRepository.save(editor);
    }

    @Override
    public Editores obtenerEditoresPorId(String id) {
        return editoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editor no encontrado"));
    }

    @Override
    public void guardarEditores(Editores editores) {
        editoresRepository.save(editores);
    }
}
