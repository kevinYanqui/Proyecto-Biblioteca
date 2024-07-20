package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.EditoresFacade;
import com.Proyecto.Biblioteca.domain.model.Editores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editores")
public class EditoresController {
    @Autowired
    private EditoresFacade editoresFacade;

    @GetMapping
    public List<Editores> listarEditores() {
        return editoresFacade.obtenerTodosLosEditores();
    }

    @PutMapping("/{id}/estado")
    public void cambiarEstadoEditor(@PathVariable("id") String id, @RequestParam("estado") String estado) {
        editoresFacade.cambiarEstadoEditores(id, estado);
    }

    @PostMapping
    public void guardarNuevoEditor(@RequestBody Editores editor) {
        editoresFacade.guardarEditores(editor);
    }

    @GetMapping("/{id}")
    public Editores obtenerEditorPorId(@PathVariable("id") String id) {
        return editoresFacade.obtenerEditoresPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarEditor(@PathVariable("id") String id, @RequestBody Editores editor) {
        editor.setCodigoEdi(Long.valueOf(id));
        editoresFacade.guardarEditores(editor);
    }
}
