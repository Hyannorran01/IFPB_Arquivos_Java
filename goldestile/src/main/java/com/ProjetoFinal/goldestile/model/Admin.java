package com.ProjetoFinal.goldestile.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("ADMINISTRADOR")
public class Admin {
    @Id
    @Column (value = "ID_ADMIN")
    private int ID_Admin;

    @Column (value = "EMAIL")
    private String email;

    @Column (value = "SENHA")
    private int senha;

    public Admin() {
    }

    public Admin(int ID_Admin, String email, int senha) {
        this.ID_Admin = ID_Admin;
        this.email = email;
        this.senha = senha;
    }

    public int getID_Admin() {
        return ID_Admin;
    }

    public void setID_Admin(int ID_Admin) {
        this.ID_Admin = ID_Admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }
}
