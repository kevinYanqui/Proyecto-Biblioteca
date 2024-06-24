package com.Proyecto.Biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "editores")
public class Editores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_edi", nullable = false, length = 6)
    private Long codigoEdi;

    @Column(name = "nom_edi", length = 50)
    private String nomEdi;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @Column(name = "estado_edi", length = 50)
    private String estadoEdi;

    public Long getCodigoEdi() {
        return codigoEdi;
    }

    public void setCodigoEdi(Long codigoEdi) {
        this.codigoEdi = codigoEdi;
    }

    public String getNomEdi() {
        return nomEdi;
    }

    public void setNomEdi(String nomEdi) {
        this.nomEdi = nomEdi;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoEdi() {
        return estadoEdi;
    }

    public void setEstadoEdi(String estadoEdi) {
        this.estadoEdi = estadoEdi;
    }

}