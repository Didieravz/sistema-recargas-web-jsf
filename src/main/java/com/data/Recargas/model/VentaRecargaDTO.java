package com.data.Recargas.model;

public class VentaRecargaDTO {
    
    private int idOperador;
    private String nombre;
    private String valor;
    private String numeroRecarga;
    private int idPersona;

    public VentaRecargaDTO() {
    }

    public int getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(int idOperador) {
        this.idOperador = idOperador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNumeroRecarga() {
        return numeroRecarga;
    }

    public void setNumeroRecarga(String numeroRecarga) {
        this.numeroRecarga = numeroRecarga;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    
}
