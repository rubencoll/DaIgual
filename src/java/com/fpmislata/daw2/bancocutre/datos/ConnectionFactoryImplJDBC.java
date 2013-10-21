/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplJDBC implements ConnectionFactory {

    static final String USER = "root";
    static final String PASS = "root";

    @Override
    public Connection getConnection() {
        // JDBC driver name and database URL

        try {
            Connection connection = null;
            Class.forName("com.mysql.jdbc.Driver");

            //connection = null;

            connection = DriverManager.getConnection("jdbc:mysql://localhost/banco", USER, PASS);

            //System.out.println("Conexion Realizada");

            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void close(Connection connection) {
    }
}
