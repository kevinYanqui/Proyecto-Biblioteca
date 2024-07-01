package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.domain.model.Reserva;
import com.Proyecto.Biblioteca.domain.model.Libros;
import com.Proyecto.Biblioteca.business.service.LibrosService;
import com.Proyecto.Biblioteca.persistence.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ReservasController {

    @Autowired
    private LibrosService librosService;

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping("/reservarLibro")
    public String reservarLibro(@RequestParam Long id, Principal principal) {
        Libros libro = librosService.obtenerLibroPorId(id);
        Reserva reserva = new Reserva();
        reserva.setLibro(libro);
        reserva.setUsuario(principal.getName());
        reserva.setAutor(libro.getCodigoAut().getNombresAut()); // Asignar el nombre del autor del libro
        reservaRepository.save(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/reservas")
    public String verReservas(Model model, Principal principal) {
        List<Reserva> reservas = reservaRepository.findByUsuario(principal.getName());
        model.addAttribute("reservas", reservas);
        return "reservas";
    }

    @PostMapping("/cancelarReserva")
    public String cancelarReserva(@RequestParam Long id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas";
    }

    @PostMapping("/completarReserva")
    public String completarReserva(RedirectAttributes redirectAttributes, Principal principal) {
        // Aquí puedes realizar las acciones necesarias para completar la reserva.
        // Por ejemplo, podrías mover las reservas a una tabla de historial.

        redirectAttributes.addFlashAttribute("mensaje", "Reserva realizada con éxito");
        return "redirect:/reservas";
    }

    @GetMapping("/historial")
    public String verHistorial(Model model, Principal principal) {
        List<Reserva> historial = reservaRepository.findByUsuario(principal.getName());
        model.addAttribute("reservas", historial);
        return "historial";
    }
}
