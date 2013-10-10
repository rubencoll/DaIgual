/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class SucursalBancaria {
    
     
    private int idSucursalBancaria;
    private List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
    private EntidadBancaria entidadBancaria;
    private String codigoSucursal;
    private String nombre;
    
    public SucursalBancaria(){
    
    }

    public SucursalBancaria(int idSucursalBancaria, EntidadBancaria entidadBancaria, String codigoSucursal, String nombre) {
        this.idSucursalBancaria = idSucursalBancaria;
        this.entidadBancaria = entidadBancaria;
        this.codigoSucursal = codigoSucursal;
        this.nombre = nombre;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }

   

    public int getIdSucursalBancaria() {
        return idSucursalBancaria;
    }

    public void setIdSucursalBancaria(int idSucursalBancaria) {
        this.idSucursalBancaria = idSucursalBancaria;
    }
    
    

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentasBancarias;
    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentasBancarias = cuentasBancarias;
    }


    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
