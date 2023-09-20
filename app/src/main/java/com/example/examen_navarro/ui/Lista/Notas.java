package com.example.examen_navarro.ui.Lista;

import java.io.Serializable;

public class Notas implements Serializable {

    private String nombre;

   private String detalle;


    public Notas(String nombre, String detalle) {
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
