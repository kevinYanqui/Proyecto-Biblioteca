package com.Proyecto.Biblioteca.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "devolucion")
public class Devolucion {
    @Id
    @Column(name = "codigo_pre", nullable = false, length = 6)
    private Long codigoPre;

    @MapsId
    @OneToOne
    @JoinColumn(name = "codigo_pre", nullable = false)
    private Prestamo prestamo;

    @Column(name = "codigo_dev", nullable = false, length = 6)
    private Long codigoDev;

    @ManyToOne
    @JoinColumn(name = "codigo_usu_emp", nullable = false)
    private Usuario codigoUsuEmp;

    @Column(name = "fecha_dev")
    private LocalDate fechaDev;

    public Long getCodigoPre() {
        return codigoPre;
    }

    public void setCodigoPre(Long codigoPre) {
        this.codigoPre = codigoPre;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Long getCodigoDev() {
        return codigoDev;
    }

    public void setCodigoDev(Long codigoDev) {
        this.codigoDev = codigoDev;
    }

    public Usuario getCodigoUsuEmp() {
        return codigoUsuEmp;
    }

    public void setCodigoUsuEmp(Usuario codigoUsuEmp) {
        this.codigoUsuEmp = codigoUsuEmp;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(LocalDate fechaDev) {
        this.fechaDev = fechaDev;
    }

}