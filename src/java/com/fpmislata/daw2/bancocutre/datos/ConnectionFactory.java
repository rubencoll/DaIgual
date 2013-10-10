/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alumno
 */
public interface ConnectionFactory {
    
    
    

    public Connection getConnection() throws SQLException, ClassNotFoundException;
    public void close(Connection connection)throws SQLException, ClassNotFoundException;
   

}
