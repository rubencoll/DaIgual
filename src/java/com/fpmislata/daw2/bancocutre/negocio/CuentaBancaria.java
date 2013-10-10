/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.negocio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class CuentaBancaria {

    private int idCuentaBancaria;
    private List<MovimientoBancario> movimientosBancario = new ArrayList<MovimientoBancario>();
    private SucursalBancaria sucursalBancaria;
    private String numeroCuenta;
    private String dc;
    private BigDecimal saldo;
    private String cif;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int idCuentaBancaria, SucursalBancaria sucursalBancaria, String numeroCuenta, String dc, BigDecimal saldo, String cif) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.sucursalBancaria = sucursalBancaria;
        this.numeroCuenta = numeroCuenta;
        this.dc = dc;
        this.saldo = saldo;
        this.cif = cif;
    }

    

    public SucursalBancaria getSucursalBancaria() {
        return sucursalBancaria;
    }

    public void setSucursalBancaria(SucursalBancaria sucursalBancaria) {
        this.sucursalBancaria = sucursalBancaria;
    }

    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public void setIdCuentaBancaria(int idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    public List<MovimientoBancario> getMovimientosBancario() {
        return movimientosBancario;
    }

    public void setMovimientosBancario(List<MovimientoBancario> movimientosBancario) {
        this.movimientosBancario = movimientosBancario;
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    //Metodos
    public String getInformacionCuentaBancaria() {

        String informacionCoche = " Numero Cuenta: " + this.numeroCuenta + "\n DC: " + this.dc + "\n Saldo: " + this.saldo + "\n CIF: " + this.cif;

        return informacionCoche;
    }

    public String getNumeroCuentaBancaria() {

        String informacionCoche = this.dc + "         " + this.numeroCuenta;

        return informacionCoche;
    }
}
