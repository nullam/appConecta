package com.elizabeth.appConecta.DTO;

import java.io.Serializable;

/**
 *
 * @author ElySanchez
 */
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idUsuario;
    private String nombre;
    private Integer edad;
    private String ciudad;
    private Boolean estado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDTO(Integer idUsuario, String nombre, Boolean estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.estado = estado;
    }

    public UsuarioDTO(String nombre, Boolean estado, Integer edad, String ciudad) {
        this.nombre = nombre;
        this.estado = estado;
        this.edad = edad;
        this.ciudad = ciudad;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
