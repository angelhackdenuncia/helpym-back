/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helpym.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ecarrillo
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Denuncia {
    
    @XmlElement
    String descripcion;
    
    @XmlElement
    Double latitud;

    @XmlElement
    Double longitud;
    
    @XmlElement
    String imagen;
    
    @XmlElement
    String direccion;
    
    @XmlElement
    String tipDenuncia;
    
    @XmlElement
    String tipDAgresion;    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }    

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipDenuncia() {
        return tipDenuncia;
    }

    public void setTipDenuncia(String tipDenuncia) {
        this.tipDenuncia = tipDenuncia;
    }

    public String getTipDAgresion() {
        return tipDAgresion;
    }

    public void setTipDAgresion(String tipDAgresion) {
        this.tipDAgresion = tipDAgresion;
    }
 
}
