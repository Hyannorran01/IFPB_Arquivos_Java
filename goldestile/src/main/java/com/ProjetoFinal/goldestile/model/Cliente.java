package com.ProjetoFinal.goldestile.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CLIENTE")
public class Cliente {

    @Column (value = "NOME")
    private String nome;

    @Id
    @Column (value = "CPF")
    private int CPF;

    @Column (value = "EMAIL")
    private String email;

    @Column (value = "SENHA")
    private String senha;



    public Cliente(String nome, int CPF, String email, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.senha = senha;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
