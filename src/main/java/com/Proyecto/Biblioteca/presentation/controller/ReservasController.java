package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.service.LibrosService;
import com.Proyecto.Biblioteca.domain.model.HistorialReserva;
import com.Proyecto.Biblioteca.domain.model.Libros;
import com.Proyecto.Biblioteca.domain.model.Prestamo;
import com.Proyecto.Biblioteca.domain.model.Reserva;
import com.Proyecto.Biblioteca.persistence.repository.HistorialReservaRepository;
import com.Proyecto.Biblioteca.persistence.repository.PrestamoRepository;
import com.Proyecto.Biblioteca.persistence.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {

    @Autowired
    private LibrosService librosService;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HistorialReservaRepository historialReservaRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @PostMapping("/reservarLibro")
    public ResponseEntity<Map<String, Object>> reservarLibro(@RequestBody Map<String, Object> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Long> ids = (List<Long>) request.get("reservas");
            String username = (String) request.get("username");

            for (Long id : ids) {
                Libros libro = librosService.obtenerLibroPorId(id);
                Reserva reserva = new Reserva();
                reserva.setLibro(libro);
                reserva.setUsuario(username);
                reserva.setAutor(libro.getCodigoAut().getNombresAut());
                reserva.setFechaReserva(LocalDateTime.now());
                reservaRepository.save(reserva);
            }

            response.put("success", true);
            response.put("message", "Libros reservados exitosamente");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> verReservas() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<Reserva> reservas = reservaRepository.findByUsuario(username);
        return ResponseEntity.ok(reservas);
    }

    @DeleteMapping("/cancelarReserva")
    public ResponseEntity<Void> cancelarReserva(@RequestParam Long id) {
        reservaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/completarReserva")
    public ResponseEntity<Void> completarReserva() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<Reserva> reservas = reservaRepository.findByUsuario(username);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fechaDevolucion = now.plusWeeks(2);

        for (Reserva reserva : reservas) {
            Prestamo prestamo = new Prestamo();
            prestamo.setLibro(reserva.getLibro());
            prestamo.setUsuario(reserva.getUsuario());
            prestamo.setAutor(reserva.getAutor());
            prestamo.setFechaPrestamo(now);
            prestamo.setFechaDevolucion(fechaDevolucion);
            prestamoRepository.save(prestamo);
        }

        reservaRepository.deleteAll(reservas);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/historial")
    public ResponseEntity<List<HistorialReserva>> verHistorial() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        List<HistorialReserva> historial = historialReservaRepository.findByUsuario(username);
        return ResponseEntity.ok(historial);
    }
}
