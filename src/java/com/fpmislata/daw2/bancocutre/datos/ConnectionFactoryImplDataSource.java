/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 *
 * @author alumno
 */
public class ConnectionFactoryImplDataSource implements ConnectionFactory {

    @Override
    public Connection getConnection() {

        try {
            DataSource datasource = null;
            InitialContext initialContext = new InitialContext();
            if (initialContext == null) {

                throw new Exception("There was no InitialContext in DBBroker. We're about to have some problems.");
            }

            // actual jndi name is "jdbc/postgres"
            datasource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/banco");

            if (datasource == null) {

                throw new Exception("Could not find our DataSource in DBBroker. We're about to have problems.");
            }

            return datasource.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
