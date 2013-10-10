/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplJDBC implements ConnectionFactory {
    
    static final String USER = "root";
    static final String PASS = "root";

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        // JDBC driver name and database URL
        
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");

        //connection = null;

        connection = DriverManager.getConnection("jdbc:mysql://localhost/banco", USER, PASS);

        //System.out.println("Conexion Realizada");
        
        return connection;
    }

    @Override
    public void close(Connection connection) throws SQLException, ClassNotFoundException {
        
    }

   
    
}
