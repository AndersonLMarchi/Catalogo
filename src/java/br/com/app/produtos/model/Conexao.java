package br.com.app.produtos.model;

import java.sql.*;

/**
 *
 * @author Anderson Luis Marchi
 */
public class Conexao {

    /**
     * Usada para a conexao com o banco de dados
     */
    private Connection connection = null;

    /**
     * Usada para realizar as instrucoes SQL
     */
    private Statement statement;

    /**
     * Retorna os dados das tabelas do banco
     */
    private ResultSet resultSet;

    /**
     * Construtor
     */
    public Conexao() {
        this.Conectar();
    }

    /**
     * Esse metodo realiza a conexao com o banco de dados
     */
    public final void Conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja", "postgres", "123456");
            statement = connection.createStatement();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    /**
     * Esse metodo quando invocado, realiza a desconexao com o banco
     */
    public void Desconectar() {
        try {
            connection.close();
        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

}
