package com.ProjetoFinal.goldestile.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("CAMISA")
public class Camisa {

    @Id
    @Column (value = "ID")
    private int ID;

    @Column (value = "DESCRICAO")
    private String descricao;

    @Column (value = "NOME")
    private String nome;

    @Column (value = "QUANTIDADE")
    private int quantidade;

    @Column (value = "VALOR")
    private int valor;

    @Column (value = "ID_ADMIN_FK")
    private int ID_Admin_FK;


    public Camisa(int ID, String descricao, String nome, int quantidade, int valor) {
        this.ID = ID;
        this.descricao = descricao;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Camisa(int ID, String descricao, String nome, int quantidade, int valor, int ID_Admin_FK) {
        this.ID = ID;
        this.descricao = descricao;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.ID_Admin_FK = ID_Admin_FK;
    }

    public Camisa() {

    }

    public int getID_Admin_FK() {
        return ID_Admin_FK;
    }

    public void setID_Admin_FK(int ID_Admin_FK) {
        this.ID_Admin_FK = ID_Admin_FK;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
