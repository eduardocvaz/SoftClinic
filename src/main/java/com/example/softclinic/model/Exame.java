package com.example.softclinic.model;

public class Exame {
    private int idExame;
    private String resultado;
    private String tipo;
    private Boolean sigilo;

    public Exame(String resultado, String tipo, Boolean sigilo) {
        this.resultado = resultado;
        this.tipo = tipo;
        this.sigilo = sigilo;
    }

    public Exame() {
    }

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

    @Override
    public String toString() {
        return "Exame{" +
                "idExame=" + idExame +
                ", resultado='" + resultado + '\'' +
                ", tipo='" + tipo + '\'' +
                ", sigilo=" + sigilo +
                '}';
    }
}
