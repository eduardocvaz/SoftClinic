package com.example.softclinic.model;

public class Medico {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String data_nascimento;
    private int numeroCTPS;
    private String cr;
    private String sexo;
    private String especialidade;

    public Medico(String nome, String sobrenome, String cpf, String data_nascimento, int numeroCTPS, String cr, String sexo, String especialidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.numeroCTPS = numeroCTPS;
        this.cr = cr;
        this.sexo = sexo;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getNumeroCTPS() {
        return numeroCTPS;
    }

    public void setNumeroCTPS(int numeroCTPS) {
        this.numeroCTPS = numeroCTPS;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
