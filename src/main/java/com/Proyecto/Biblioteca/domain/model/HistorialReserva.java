package com.Proyecto.Biblioteca.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "historial_reservas")
public class HistorialReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_reserva", nullable = false)
    private Long idHistorialReserva;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_lib", nullable = false)
    private Libros libro;

    @Column(name = "usuario", nullable = false, length = 50)
    private String usuario;

    @Column(name = "autor", nullable = false, length = 50)
    private String autor;

    // Getters y setters...

    public Long getIdHistorialReserva() {
        return idHistorialReserva;
    }

    public void setIdHistorialReserva(Long idHistorialReserva) {
        this.idHistorialReserva = idHistorialReserva;
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
}
