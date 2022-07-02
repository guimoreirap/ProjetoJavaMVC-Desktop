package controller;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author marceloborth
 */

/*
* Segue o padrão de projeto Singleton
* Uma Unica instancia no projeto inteiro
* Criterio para o Singleton
    - Construtor privado
    - Variavel com static e private 
    - 1 Metodo para recuperar a instancia -> "getInstancia" <- static
*/

public class Conexao {
    
    private static Connection con;

    private Conexao() throws Exception {

        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/ifsis";
            String usuario = "root";
            String senha = "";
            
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);
            con.setAutoCommit(true);

        } catch (Exception e) {
            throw e;
        }
    }

    public static Connection getInstancia() throws Exception {
        if (con == null) {
            new Conexao();
        }
        return con;
    }

    public static void main(String[] args) {
        try {
            System.out.println(Conexao.getInstancia());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

