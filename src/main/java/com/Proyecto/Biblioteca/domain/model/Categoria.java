package com.Proyecto.Biblioteca.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_gen", nullable = false, length = 6)
    private Long codigoGen;

    @Column(name = "nombres_gen", length = 50)
    private String nombresGen;

    @Column(name = "descripcion_gen", length = 100)
    private String descripcionGen;

    @Column(name = "estado_cat", length = 50)
    private String estadoCat;

    public Long getCodigoGen() {
        return codigoGen;
    }

    public void setCodigoGen(Long codigoGen) {
        this.codigoGen = codigoGen;
    }

    public String getNombresGen() {
        return nombresGen;
    }

    public void setNombresGen(String nombresGen) {
        this.nombresGen = nombresGen;
    }

    public String getDescripcionGen() {
        return descripcionGen;
    }

    public void setDescripcionGen(String descripcionGen) {
        this.descripcionGen = descripcionGen;
    }

    public String getEstadoCat() {
        return estadoCat;
    }

    public void setEstadoCat(String estadoCat) {
        this.estadoCat = estadoCat;
    }

}