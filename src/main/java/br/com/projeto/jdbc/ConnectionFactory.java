/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.jdbc;

/*import com.sun.jdi.connect.spi.Connection;*/

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author geu_p
 */
public class ConnectionFactory {
    
 /*   private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dbloja";
    private static final String USER = "root";
    private static final String PASS = "1995";*/

    public Connection getConnection(){

        try {
           // Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas","usuariocurso","1234");
        } catch (Exception e) {
            throw new RuntimeException("Erro de conexão",e);
        }

    }

}
//