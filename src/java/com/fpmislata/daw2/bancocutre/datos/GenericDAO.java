/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import java.util.List;

/**
 *
 * @author alumno
 */
public interface GenericDAO<T,ID> {
    
    T read(ID id);
    void insert(T t);
    void update(T t);
    void delete(T t);
    List<T> findAll();
    
    
}
