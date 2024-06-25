package com.Proyecto.Biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "generador")
public class Generador {
    @Id
    @Column(name = "parametro", nullable = false, length = 30)
    private String parametro;

    @Column(name = "ultimo")
    private Integer ultimo;

    @Column(name = "abreviatura", length = 5)
    private String abreviatura;

    @Column(name = "caracteres")
    private Integer caracteres;

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public Integer getUltimo() {
        return ultimo;
    }

    public void setUltimo(Integer ultimo) {
        this.ultimo = ultimo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Integer getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(Integer caracteres) {
        this.caracteres = caracteres;
    }

}