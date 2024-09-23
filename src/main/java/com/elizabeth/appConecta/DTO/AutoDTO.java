package com.elizabeth.appConecta.DTO;

import java.io.Serializable;

/**
 *
 * @author ElySanchez
 */
public class AutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idAuto;
    private String placa;
    private String marca;
    private String modelo;
    private String chasis;
    private String color;
    private Boolean estado;
    private UsuarioDTO idUsuario;

    public AutoDTO() {
    }

    public AutoDTO(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public AutoDTO(Integer idAuto, String placa, String marca, String modelo, String chasis, String color, Boolean estado) {
        this.idAuto = idAuto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.chasis = chasis;
        this.color = color;
        this.estado = estado;
    }

    public AutoDTO(String placa, String marca, String modelo, String chasis, String color, Boolean estado) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.chasis = chasis;
        this.color = color;
        this.estado = estado;
    }

    public Integer getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
    }
}
