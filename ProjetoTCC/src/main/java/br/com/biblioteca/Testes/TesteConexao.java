package br.com.biblioteca.Testes;

import br.com.biblioteca.ClassesDAO.ConexaoMySQL;
import br.com.biblioteca.ClassesDAO.UsuarioDAO;
import br.com.biblioteca.modelo.UsuarioCliente;

import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) throws SQLException {

        System.out.println(ConexaoMySQL.getConexao());

        UsuarioCliente u = new UsuarioCliente("Ronaldo", "ronaldo@email.com", "12345678900","1234");

        UsuarioDAO dao = new br.com.biblioteca.ClassesDAO.UsuarioDAO();
        dao.inserir(u);
    }
}

