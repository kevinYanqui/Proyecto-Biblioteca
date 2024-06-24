package com.Proyecto.Biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_aut", nullable = false, length = 6)
    private Long codigoAut;

    @Column(name = "nombres_aut", length = 50)
    private String nombresAut;

    @Column(name = "ape_aut", length = 50)
    private String apeAut;

    @Column(name = "estado_aut", length = 50)
    private String estadoAut;

    public Long getCodigoAut() {
        return codigoAut;
    }

    public void setCodigoAut(Long codigoAut) {
        this.codigoAut = codigoAut;
    }

    public String getNombresAut() {
        return nombresAut;
    }

    public void setNombresAut(String nombresAut) {
        this.nombresAut = nombresAut;
    }

    public String getApeAut() {
        return apeAut;
    }

    public void setApeAut(String apeAut) {
        this.apeAut = apeAut;
    }

    public String getEstadoAut() {
        return estadoAut;
    }

    public void setEstadoAut(String estadoAut) {
        this.estadoAut = estadoAut;
    }

}