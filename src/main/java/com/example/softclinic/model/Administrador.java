package com.example.softclinic.model;

public class Administrador {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String data_nascimento;
    private String sexo;
    private String telefone;

    private int numeroCTPS;


    public Administrador(String nome, String sobrenome, String cpf, String data_nascimento, String sexo, String telefone, int numeroCTPS) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.numeroCTPS = numeroCTPS;
    }

    public Administrador() {

    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNumeroCTPS() {
        return numeroCTPS;
    }

    public void setNumeroCTPS(int numeroCTPS) {
        this.numeroCTPS = numeroCTPS;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", numeroCTPS=" + numeroCTPS +
                '}';
    }
}
