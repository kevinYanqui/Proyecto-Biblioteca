package com.Proyecto.Biblioteca.domain.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usu", nullable = false, length = 6)
    private Long codigoUsu;

    @Column(name = "documentodeidentidad", length = 8)
    private String documentodeidentidad;

    @Column(name = "psw_sesesion_us", length = 100)
    private String pswSesesionUs;

    @Column(name = "nombres_usu", length = 50)
    private String nombresUsu;

    @Column(name = "apellidospaterno_usu", length = 50)
    private String apellidospaternoUsu;

    @Column(name = "apellidosmaterno_usu", length = 50)
    private String apellidosmaternoUsu;

    @Column(name = "telelefono_usu", length = 9)
    private String telelefonoUsu;

    @Column(name = "direccion_usu", length = 100)
    private String direccionUsu;

    @Column(name = "correoelectronico_usu", length = 100)
    private String correoelectronicoUsu;

    @Column(name = "fecha_registro_usu")
    private LocalDate fechaRegistroUsu;

    @Column(name = "facha_nac_usu")
    private LocalDate fachaNacUsu;

    @Column(name = "estado_usuario", length = 50)
    private String estadoUsuario;

    @Column(name = "tipo_usu", nullable = false, length = 50)
    private String tipoUsu;

    @Column(name = "imagen", length = 50)
    private String imagen;

    @Column(name = "nombres_sesison_usu", length = 50)
    private String nombresSesisonUsu;

    public Long getCodigoUsu() {
        return codigoUsu;
    }

    public void setCodigoUsu(Long codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public String getDocumentodeidentidad() {
        return documentodeidentidad;
    }

    public void setDocumentodeidentidad(String documentodeidentidad) {
        this.documentodeidentidad = documentodeidentidad;
    }

    public String getPswSesesionUs() {
        return pswSesesionUs;
    }

    public void setPswSesesionUs(String pswSesesionUs) {
        this.pswSesesionUs = pswSesesionUs;
    }

    public String getNombresUsu() {
        return nombresUsu;
    }

    public void setNombresUsu(String nombresUsu) {
        this.nombresUsu = nombresUsu;
    }

    public String getApellidospaternoUsu() {
        return apellidospaternoUsu;
    }

    public void setApellidospaternoUsu(String apellidospaternoUsu) {
        this.apellidospaternoUsu = apellidospaternoUsu;
    }

    public String getApellidosmaternoUsu() {
        return apellidosmaternoUsu;
    }

    public void setApellidosmaternoUsu(String apellidosmaternoUsu) {
        this.apellidosmaternoUsu = apellidosmaternoUsu;
    }

    public String getTelelefonoUsu() {
        return telelefonoUsu;
    }

    public void setTelelefonoUsu(String telelefonoUsu) {
        this.telelefonoUsu = telelefonoUsu;
    }

    public String getDireccionUsu() {
        return direccionUsu;
    }

    public void setDireccionUsu(String direccionUsu) {
        this.direccionUsu = direccionUsu;
    }

    public String getCorreoelectronicoUsu() {
        return correoelectronicoUsu;
    }

    public void setCorreoelectronicoUsu(String correoelectronicoUsu) {
        this.correoelectronicoUsu = correoelectronicoUsu;
    }

    public LocalDate getFechaRegistroUsu() {
        return fechaRegistroUsu;
    }

    public void setFechaRegistroUsu(LocalDate fechaRegistroUsu) {
        this.fechaRegistroUsu = fechaRegistroUsu;
    }

    public LocalDate getFachaNacUsu() {
        return fachaNacUsu;
    }

    public void setFachaNacUsu(LocalDate fachaNacUsu) {
        this.fachaNacUsu = fachaNacUsu;
    }

    public String getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(String estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public String getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(String tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombresSesisonUsu() {
        return nombresSesisonUsu;
    }

    public void setNombresSesisonUsu(String nombresSesisonUsu) {
        this.nombresSesisonUsu = nombresSesisonUsu;
    }

}