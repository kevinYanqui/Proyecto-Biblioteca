package com.Proyecto.Biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_pre", nullable = false, length = 6)
    private Long codigoPre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_usu_lector")
    private Usuario codigoUsuLector;

    @Column(name = "estado_prestamo", length = 50)
    private String estadoPrestamo;

    @Column(name = "fecha_prestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "fechalimite_devolucion")
    private LocalDate fechalimiteDevolucion;

    public Long getCodigoPre() {
        return codigoPre;
    }

    public void setCodigoPre(Long codigoPre) {
        this.codigoPre = codigoPre;
    }

    public Usuario getCodigoUsuLector() {
        return codigoUsuLector;
    }

    public void setCodigoUsuLector(Usuario codigoUsuLector) {
        this.codigoUsuLector = codigoUsuLector;
    }

    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechalimiteDevolucion() {
        return fechalimiteDevolucion;
    }

    public void setFechalimiteDevolucion(LocalDate fechalimiteDevolucion) {
        this.fechalimiteDevolucion = fechalimiteDevolucion;
    }

}