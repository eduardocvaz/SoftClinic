package com.example.softclinic.model;

public class Exame {
    private int idExame;
    private String resultado;
    private String tipo;
    private Boolean sigilo;
    private int idProtuario;

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getSigilo() {
        return sigilo;
    }

    public void setSigilo(Boolean sigilo) {
        this.sigilo = sigilo;
    }

    public int getIdProtuario() {
        return idProtuario;
    }

    public void setIdProtuario(int idProtuario) {
        this.idProtuario = idProtuario;
    }
}
