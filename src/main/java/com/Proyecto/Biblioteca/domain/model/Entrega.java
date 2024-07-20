package com.Proyecto.Biblioteca.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "entrega")
public class Entrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_ent", nullable = false, length = 6)
    private Long codigoEnt;

    @ManyToOne
    @JoinColumn(name = "codigo_pre", nullable = false)
    private Prestamo codigoPre;

    @ManyToOne
    @JoinColumn(name = "codigo_usu_emp", nullable = false)
    private Usuario codigoUsuEmp;

    @Column(name = "fecha_ent")
    private LocalDate fechaEnt;

    public Long getCodigoEnt() {
        return codigoEnt;
    }

    public void setCodigoEnt(Long codigoEnt) {
        this.codigoEnt = codigoEnt;
    }

    public Prestamo getCodigoPre() {
        return codigoPre;
    }

    public void setCodigoPre(Prestamo codigoPre) {
        this.codigoPre = codigoPre;
    }

    public Usuario getCodigoUsuEmp() {
        return codigoUsuEmp;
    }

    public void setCodigoUsuEmp(Usuario codigoUsuEmp) {
        this.codigoUsuEmp = codigoUsuEmp;
    }

    public LocalDate getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(LocalDate fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

}