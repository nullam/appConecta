/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elizabeth.appConecta.entidad;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author ElySanchez
 */
@Entity
@Table(name = "auto")
@NamedQueries({
    @NamedQuery(name = "Auto.findAll", query = "SELECT a FROM Auto a"),
    @NamedQuery(name = "Auto.findByIdAuto", query = "SELECT a FROM Auto a WHERE a.idAuto = :idAuto"),
    @NamedQuery(name = "Auto.findByPlaca", query = "SELECT a FROM Auto a WHERE a.placa = :placa"),
    @NamedQuery(name = "Auto.findByMarca", query = "SELECT a FROM Auto a WHERE a.marca = :marca"),
    @NamedQuery(name = "Auto.findByModelo", query = "SELECT a FROM Auto a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Auto.findByChasis", query = "SELECT a FROM Auto a WHERE a.chasis = :chasis"),
    @NamedQuery(name = "Auto.findByColor", query = "SELECT a FROM Auto a WHERE a.color = :color"),
    @NamedQuery(name = "Auto.findByEstado", query = "SELECT a FROM Auto a WHERE a.estado = :estado")})
public class Auto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_auto")
    private Integer idAuto;
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "chasis")
    private String chasis;
    @Basic(optional = false)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Auto() {
    }

    public Auto(Integer idAuto) {
        this.idAuto = idAuto;
    }

    public Auto(Integer idAuto, String placa, String marca, String modelo, String chasis, String color, boolean estado) {
        this.idAuto = idAuto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.chasis = chasis;
        this.color = color;
        this.estado = estado;
    }
    
    public Auto(String placa, String marca, String modelo, String chasis, String color, boolean estado) {
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuto != null ? idAuto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auto)) {
            return false;
        }
        Auto other = (Auto) object;
        if ((this.idAuto == null && other.idAuto != null) || (this.idAuto != null && !this.idAuto.equals(other.idAuto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.elizabeth.appConecta.entidad.Auto[ idAuto=" + idAuto + " ]";
    }
    
}
