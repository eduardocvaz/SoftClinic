package com.example.softclinic.model;

public class Atendente{
    private String nome;
    private String sobrenome;
    private String cpf;
    private String data_nascimento;
    private int numeroCTPS;
    private String telefone;
    private String sexo;

    public int getNumeroCTPS() {
        return numeroCTPS;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Atendente(String nome, String sobrenome, String cpf, String data_nascimento, int numeroCTPS, String telefone, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.numeroCTPS = numeroCTPS;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    public Atendente() {

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

    public int getNumeroCTPS(int numeroctps) {
        return numeroCTPS;
    }

    public void setNumeroCTPS(int numeroCTPS) {
        this.numeroCTPS = numeroCTPS;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", numeroCTPS=" + numeroCTPS +
                ", telefone='" + telefone + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
