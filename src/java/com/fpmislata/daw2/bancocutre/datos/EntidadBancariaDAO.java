/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import com.fpmislata.daw2.bancocutre.negocio.EntidadBancaria;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;

/**
 *
 * @author alumno
 */
public interface EntidadBancariaDAO {

    public EntidadBancaria read(int idEntidadBancaria) throws SQLException, ClassNotFoundException, ServletException;

    public void insert(EntidadBancaria entidadBancaria) throws SQLException, ClassNotFoundException, ServletException;

    public void update(EntidadBancaria entidadBancaria) throws SQLException, ClassNotFoundException, ServletException;
    
    public void delete(EntidadBancaria entidadBancaria) throws SQLException, ClassNotFoundException, ServletException;
    
    public List<EntidadBancaria> findAll() throws SQLException, ClassNotFoundException, ServletException;
    
    public List<EntidadBancaria> findByCodigo(String codigo) throws SQLException, ClassNotFoundException, ServletException;
    
}
