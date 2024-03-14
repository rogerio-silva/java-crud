package br.com.numbersapp.model;

import java.time.LocalDate;

public class Pessoa {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String numerocelular;
    private LocalDate dataaniversario;
    private LocalDate dataintegracao;
    private Curso curso;

    public Pessoa(Long id, String nome, String sobrenome, String cpf, String email, String numerocelular, LocalDate dataaniversario, LocalDate dataintegracao, Curso curso) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.numerocelular = numerocelular;
        this.dataaniversario = dataaniversario;
        this.dataintegracao = dataintegracao;
        this.curso = curso;
    }

    public Pessoa(String nome, String sobrenome, String cpf, String email, String numerocelular, LocalDate dataaniversario, LocalDate dataintegracao, Curso curso) {
        this.id = null;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.numerocelular = numerocelular;
        this.dataaniversario = dataaniversario;
        this.dataintegracao = dataintegracao;
        this.curso = curso;
    }

    public Pessoa() {
        this.id = null;
        this.nome = null;
        this.sobrenome = null;
        this.cpf = null;
        this.email = null;
        this.numerocelular = null;
        this.dataaniversario = null;
        this.dataintegracao = null;
        this.curso = null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public LocalDate getDataaniversario() {
        return dataaniversario;
    }

    public void setDataaniversario(LocalDate dataaniversario) {
        this.dataaniversario = dataaniversario;
    }

    public LocalDate getDataintegracao() {
        return dataintegracao;
    }

    public void setDataintegracao(LocalDate dataintegracao) {
        this.dataintegracao = dataintegracao;
    }

    public void printPessoa() {
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);
        System.out.print(" Sobrenome: " + this.sobrenome);
        System.out.print(" CPF: " + this.cpf);
        System.out.print(" Email: " + this.email);
        System.out.print(" Número Celular: " + this.numerocelular);
        System.out.print(" Data de Aniversário: " + this.dataaniversario);
        System.out.print(" Data de Integração: " + this.dataintegracao);
        System.out.println(" Curso: " + this.curso);
    }
}
