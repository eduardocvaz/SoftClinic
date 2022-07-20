package com.example.softclinic.model;



public class PacienteAlergia {

  private long idPacienteAlergia;
  private String tipo;
  private String reacao;
  private String causador;
  private String nivel;

  public PacienteAlergia(String tipo, String reacao, String causador, String nivel) {
    this.tipo = tipo;
    this.reacao = reacao;
    this.causador = causador;
    this.nivel = nivel;
  }

  public PacienteAlergia() {
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


  public String getReacao() {
    return reacao;
  }

  public void setReacao(String reacao) {
    this.reacao = reacao;
  }


  public String getCausador() {
    return causador;
  }

  public void setCausador(String causador) {
    this.causador = causador;
  }


  public String getNivel() {
    return nivel;
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }


  public long getIdPacienteAlergia() {
    return idPacienteAlergia;
  }

  public void setIdPacienteAlergia(long idPacienteAlergia) {
    this.idPacienteAlergia = idPacienteAlergia;
  }

  @Override
  public String toString() {
    return "PacienteAlergia{" +
            "idPacienteAlergia=" + idPacienteAlergia +
            ", tipo='" + tipo + '\'' +
            ", reacao='" + reacao + '\'' +
            ", causador='" + causador + '\'' +
            ", nivel='" + nivel + '\'' +
            '}';
  }
}
