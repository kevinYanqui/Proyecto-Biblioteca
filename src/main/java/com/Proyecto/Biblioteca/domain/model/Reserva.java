package com.Proyecto.Biblioteca.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva", nullable = false)
    private Long idReserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_lib", nullable = false)
    private Libros libro;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "autor", nullable = false, length = 50)
    private String autor;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDateTime fechaReserva;

    @PrePersist
    protected void onCreate() {
        if (this.fechaReserva == null) {
            this.fechaReserva = LocalDateTime.now();
        }
    }

    // Getters y setters...

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}
