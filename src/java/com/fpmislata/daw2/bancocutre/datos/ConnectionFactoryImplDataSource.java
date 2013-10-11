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
    public Connection getConnection() throws SQLException, ServletException {
        DataSource datasource = null;
        try {

            InitialContext initialContext = new InitialContext();
            if (initialContext == null) {
                
                throw new Exception("There was no InitialContext in DBBroker. We're about to have some problems.");
            }

            // actual jndi name is "jdbc/postgres"
            datasource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/banco");

            if (datasource == null) {
                
                throw new Exception("Could not find our DataSource in DBBroker. We're about to have problems.");
            }
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        return datasource.getConnection();
    }

    @Override
    public void close(Connection connection) throws SQLException, ClassNotFoundException {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println("DBBroker: Threw an exception closing a database connection");
            e.printStackTrace();
        }
    }
}
