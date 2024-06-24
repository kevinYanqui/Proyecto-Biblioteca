package com.Proyecto.Biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_lib", nullable = false, length = 6)
    private Long codigoLib;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_aut", nullable = false)
    private Autores codigoAut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_edi", nullable = false)
    private Editores codigoEdi;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_gen", nullable = false)
    private Categoria codigoGen;

    @Column(name = "estado_libros", length = 50)
    private String estadoLibros;

    @Column(name = "ejemplares_lib")
    private Integer ejemplaresLib;

    @Column(name = "titulo_lib", length = 50)
    private String tituloLib;

    @Column(name = "decripcion_lib", length = 200)
    private String decripcionLib;

    @Column(name = "imagen_lib", length = 50)
    private String imagenLib;

    @Column(name = "observaciones", length = 200)
    private String observaciones;

    @Column(name = "stock")
    private Integer stock;

    public Long getCodigoLib() {
        return codigoLib;
    }

    public void setCodigoLib(Long codigoLib) {
        this.codigoLib = codigoLib;
    }

    public Autores getCodigoAut() {
        return codigoAut;
    }

    public void setCodigoAut(Autores codigoAut) {
        this.codigoAut = codigoAut;
    }

    public Editores getCodigoEdi() {
        return codigoEdi;
    }

    public void setCodigoEdi(Editores codigoEdi) {
        this.codigoEdi = codigoEdi;
    }

    public Categoria getCodigoGen() {
        return codigoGen;
    }

    public void setCodigoGen(Categoria codigoGen) {
        this.codigoGen = codigoGen;
    }

    public String getEstadoLibros() {
        return estadoLibros;
    }

    public void setEstadoLibros(String estadoLibros) {
        this.estadoLibros = estadoLibros;
    }

    public Integer getEjemplaresLib() {
        return ejemplaresLib;
    }

    public void setEjemplaresLib(Integer ejemplaresLib) {
        this.ejemplaresLib = ejemplaresLib;
    }

    public String getTituloLib() {
        return tituloLib;
    }

    public void setTituloLib(String tituloLib) {
        this.tituloLib = tituloLib;
    }

    public String getDecripcionLib() {
        return decripcionLib;
    }

    public void setDecripcionLib(String decripcionLib) {
        this.decripcionLib = decripcionLib;
    }

    public String getImagenLib() {
        return imagenLib;
    }

    public void setImagenLib(String imagenLib) {
        this.imagenLib = imagenLib;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

}