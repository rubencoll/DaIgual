/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import com.fpmislata.daw2.bancocutre.negocio.EntidadBancaria;
import com.fpmislata.daw2.bancocutre.negocio.SucursalBancaria;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;

/**
 *
 * @author alumno
 */
public interface SucursalBancariaDAO extends GenericDAO<EntidadBancaria, Integer>{
    
 
     public List<SucursalBancaria> findByCodigo(String codigo);
    
}
