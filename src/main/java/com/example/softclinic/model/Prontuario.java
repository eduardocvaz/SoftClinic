package com.example.softclinic.model;

public class Prontuario {

  private long id;
  private Paciente paciente;
  private String tiposanguineo;
  private String observacao;
  private Exame exame;
  private PacienteAlergia pacienteAlergia;

  public Prontuario(Paciente paciente, String tiposanguineo, String observacao, Exame exame, PacienteAlergia pacienteAlergia) {
    this.paciente = paciente;
    this.tiposanguineo = tiposanguineo;
    this.observacao = observacao;
    this.exame = exame;
    this.pacienteAlergia = pacienteAlergia;
  }

  public Prontuario() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Paciente getPaciente() {
    return paciente;
  }

  public void setPaciente(Paciente paciente) {
    this.paciente = paciente;
  }


  public String getTiposanguineo() {
    return tiposanguineo;
  }

  public void setTiposanguineo(String tiposanguineo) {
    this.tiposanguineo = tiposanguineo;
  }


  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }


  public Exame getExame() {
    return exame;
  }

  public void setExame(Exame exame) {
    this.exame = exame;
  }


  public PacienteAlergia getPacienteAlergia() {
    return pacienteAlergia;
  }

  public void setPacienteAlergia(PacienteAlergia idPacienteAlergia) {
    this.pacienteAlergia = idPacienteAlergia;
  }

  @Override
  public String toString() {
    return "Prontuario{" +
            "id=" + id +
            ", paciente=" + paciente +
            ", tiposanguineo='" + tiposanguineo + '\'' +
            ", observacao='" + observacao + '\'' +
            ", exame=" + exame +
            ", pacienteAlergia=" + pacienteAlergia +
            '}';
  }
}
