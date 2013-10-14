/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import com.fpmislata.daw2.bancocutre.negocio.EntidadBancaria;
import com.fpmislata.daw2.bancocutre.negocio.SucursalBancaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author alumno
 */
public class SucursalBancariaDAOImplJDBC {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplJDBC();

    public SucursalBancariaDAOImplJDBC() throws ClassNotFoundException, SQLException {
    }

    public SucursalBancaria read(int idSucursalBancaria) {
        try {
            Connection connection;

            connection = connectionFactory.getConnection();

            SucursalBancaria sucursalBancaria;

            String selectSQL = "SELECT * FROM sucursalbancaria WHERE idSucursalBancaria = ?";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSQL);
            preparedStatementSelect.setInt(1, idSucursalBancaria);

            ResultSet resultSet = preparedStatementSelect.executeQuery();

            if (resultSet.next() == true) {

                sucursalBancaria = new SucursalBancaria();

                idSucursalBancaria = resultSet.getInt("idSucursalBancaria");
                int idEntidadBancaria = resultSet.getInt("idEntidadBancaria");
                String codigoSucursalBancaria = resultSet.getString("codigoEntidadBancaria");
                String nombre = resultSet.getString("nombre");

                EntidadBancaria entidadBancaria;
                
                
                sucursalBancaria.setIdSucursalBancaria(idSucursalBancaria);
                sucursalBancaria.setEntidadBancaria(null);
                sucursalBancaria.setCodigoSucursal(codigoSucursalBancaria);
                sucursalBancaria.setNombre(nombre);

                if (resultSet.next() == true) {
                    throw new RuntimeException("Hay mas de una Sucursal Bancaria con identificador: " + idSucursalBancaria);
                    // System.out.println("Hay mas de 1");
                }

            } else {    //Si no existe retornara un NULL

                sucursalBancaria = null;

            }

            connection.close();

            return sucursalBancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void insert(SucursalBancaria sucursalBancaria) {
        try {

            Connection connection;

            connection = connectionFactory.getConnection();

            String insertSQL = "INSERT INTO SucursalBancaria (idSucursalBancaria,idEntidadBancaria, codigoSucursalBancaria,nombre) VALUES (?,?,?,?)";

            PreparedStatement preparedStatementInsert = connection.prepareStatement(insertSQL);

            preparedStatementInsert.setInt(1, sucursalBancaria.getIdSucursalBancaria());
            preparedStatementInsert.setInt(2, sucursalBancaria.getEntidadBancaria().getIdEntidadBancaria());
            preparedStatementInsert.setString(3, sucursalBancaria.getCodigoSucursal());
            preparedStatementInsert.setString(4, sucursalBancaria.getNombre());

            preparedStatementInsert.executeUpdate();
            connection.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void update(SucursalBancaria sucursalBancaria) {

        try {

            Connection connection;

            connection = connectionFactory.getConnection();

            String updateSQL = "UPDATE sucursalBancaria SET idEntidadBancaria = ?, codigoSucursal = ?, nombre = ? WHERE idSucursalBancaria = ?";

            PreparedStatement preparedStatementUpdate = connection.prepareStatement(updateSQL);

            preparedStatementUpdate.setInt(1, sucursalBancaria.getEntidadBancaria().getIdEntidadBancaria());
            preparedStatementUpdate.setString(2, sucursalBancaria.getCodigoSucursal());
            preparedStatementUpdate.setString(3, sucursalBancaria.getNombre());
            preparedStatementUpdate.setInt(4, sucursalBancaria.getIdSucursalBancaria());


            preparedStatementUpdate.executeUpdate();
            connection.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void delete(SucursalBancaria sucursalBancaria) {
        try {
            Connection connection;

            connection = connectionFactory.getConnection();

            String deleteSQL = "DELETE FROM sucursalBancaria WHERE idSucursalBancaria = ?";

            PreparedStatement preparedStatementDelete = connection.prepareStatement(deleteSQL);

            preparedStatementDelete.setInt(1, sucursalBancaria.getIdSucursalBancaria());

            int numeroEntidades = preparedStatementDelete.executeUpdate();

            if (numeroEntidades > 1) {     //Si hay más de una entidad con el mismo ID

                throw new RuntimeException("Hay mas de una Sucursal Bancaria con Identificador: " + sucursalBancaria.getIdSucursalBancaria());

            }
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<SucursalBancaria> findAll() {

        try {
            Connection connection;

            connection = connectionFactory.getConnection();

            List<SucursalBancaria> sucursalesBancarias = new ArrayList<>();

            String selectSQL = "SELECT * FROM sucursalbancaria";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatementSelect.executeQuery();

            while (resultSet.next()) {

                SucursalBancaria sucursalBancaria = new SucursalBancaria();

                int idSucursalBancaria = resultSet.getInt("idSucursalBancaria");
                int idEntidadBancaria = resultSet.getInt("idEntidadBancaria");
                String codigoSucursalBancaria = resultSet.getString("codigoSucursal");
                String nombre = resultSet.getString("nombre");

                sucursalBancaria.setIdSucursalBancaria(idSucursalBancaria);
                sucursalBancaria.setEntidadBancaria(null);
                sucursalBancaria.setCodigoSucursal(codigoSucursalBancaria);
                sucursalBancaria.setNombre(nombre);

                sucursalesBancarias.add(sucursalBancaria);

            }

            connection.close();

            return sucursalesBancarias;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<SucursalBancaria> findByCodigo(String codigo) {

        try {
            Connection connection = connectionFactory.getConnection();

            List<SucursalBancaria> sucursalesBancarias = new ArrayList<>();

            String selectSQL = "SELECT * FROM sucursalBancaria WHERE codigoSucursalBancaria = ?";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSQL);
            preparedStatementSelect.setString(1, codigo);

            ResultSet resultSet = preparedStatementSelect.executeQuery();

            while (resultSet.next()) {

                SucursalBancaria sucursalBancaria = new SucursalBancaria();

                int idSucursalBancaria = resultSet.getInt("idSucursalBancaria");
                int idEntidadBancaria = resultSet.getInt("idEntidadBancaria");
                String codigoSucursalBancaria = resultSet.getString("codigoSucursalBancaria");
                String nombre = resultSet.getString("nombre");

                sucursalBancaria.setIdSucursalBancaria(idSucursalBancaria);
                sucursalBancaria.setEntidadBancaria(null);
                sucursalBancaria.setCodigoSucursal(codigoSucursalBancaria);
                sucursalBancaria.setNombre(nombre);

                sucursalesBancarias.add(sucursalBancaria);

            }
            connection.close();

            return sucursalesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
