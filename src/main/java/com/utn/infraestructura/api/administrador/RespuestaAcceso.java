package com.utn.infraestructura.api.administrador;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.utn.dominio.foto.CalidadFoto;
import com.utn.dominio.foto.TamañoFoto;

import java.util.List;

public class RespuestaAcceso
{
    @JsonProperty
    private String nombreUsuario;

    @JsonProperty
    private List<String> usuariosSinPrivilegios;

    @JsonProperty
    private CalidadFoto calidadFoto;

    @JsonProperty
    private TamañoFoto tamañoFoto;

    @JsonProperty
    private List<String> caracteristicas;

    public List<String> getUsuariosSinPrivilegios() {
        return usuariosSinPrivilegios;
    }

    public void setUsuariosSinPrivilegios(List<String> usuariosSinPrivilegios) {
        this.usuariosSinPrivilegios = usuariosSinPrivilegios;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public CalidadFoto getCalidadFoto() {
        return calidadFoto;
    }

    public void setCalidadFoto(CalidadFoto calidadFoto) {
        this.calidadFoto = calidadFoto;
    }

    public TamañoFoto getTamañoFoto() {
        return tamañoFoto;
    }

    public void setTamañoFoto(TamañoFoto tamañoFoto) {
        this.tamañoFoto = tamañoFoto;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<String> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}