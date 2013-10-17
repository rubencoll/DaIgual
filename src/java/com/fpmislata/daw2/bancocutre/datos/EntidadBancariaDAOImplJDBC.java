/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.daw2.bancocutre.datos;

import com.fpmislata.daw2.bancocutre.negocio.EntidadBancaria;
import com.fpmislata.daw2.bancocutre.negocio.TipoEntidadBancaria;
import java.sql.Connection;
import java.sql.DriverManager;
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
//  Database credentials
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory = new ConnectionFactoryImplDataSource();
    //ConnectionFactory connectionFactory = new ConnectionFactoryImplJDBC();

    public EntidadBancariaDAOImplJDBC() {
    }

    @Override
    public EntidadBancaria read(Integer idEntidadBancaria) {

        Connection connection;

        try {
            connection = connectionFactory.getConnection();

            EntidadBancaria entidadBancaria;

            String selectSQL = "SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSQL);
            preparedStatementSelect.setInt(1, idEntidadBancaria);

            ResultSet resultSet = preparedStatementSelect.executeQuery();

            if (resultSet.next() == true) {

                entidadBancaria = new EntidadBancaria();

                idEntidadBancaria = resultSet.getInt("idEntidadBancaria");
                String codigoEntidadBancaria = resultSet.getString("codigoEntidadBancaria");
                String nombre = resultSet.getString("nombre");
                String cif = resultSet.getString("cif");
                String tipoEntidadBancaria = resultSet.getString("tipoEntidadBancaria");

                entidadBancaria.setIdEntidadBancaria(idEntidadBancaria);
                entidadBancaria.setCodigoEntidadBancaria(codigoEntidadBancaria);
                entidadBancaria.setNombre(nombre);
                entidadBancaria.setCif(cif);
                entidadBancaria.setTipoEntidadBancaria(TipoEntidadBancaria.valueOf(tipoEntidadBancaria));

                if (resultSet.next() == true) {
                    throw new RuntimeException("Hay mas de una entidad Bancaria con codigo: " + codigoEntidadBancaria);
                    // System.out.println("Hay mas de 1");
                }

            } else {    //Si no existe retornara un NULL

                entidadBancaria = null;

            }

            connection.close();
            return entidadBancaria;

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

    @Override
    public void insert(EntidadBancaria entidadBancaria) {

        Connection connection;
        try {

            connection = connectionFactory.getConnection();

            String insertSQL = "INSERT INTO EntidadBancaria (idEntidadBancaria, codigoEntidadBancaria,nombre,cif,tipoEntidadBancaria) VALUES (?,?,?,?,?)";

            PreparedStatement preparedStatementInsert = connection.prepareStatement(insertSQL);

            preparedStatementInsert.setInt(1, entidadBancaria.getIdEntidadBancaria());
            preparedStatementInsert.setString(2, entidadBancaria.getCodigoEntidadBancaria());
            preparedStatementInsert.setString(3, entidadBancaria.getNombre());
            preparedStatementInsert.setString(4, entidadBancaria.getCif());
            preparedStatementInsert.setString(5, entidadBancaria.getTipoEntidadBancaria().name());

            preparedStatementInsert.executeUpdate();
            connection.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

    @Override
    public void update(EntidadBancaria entidadBancaria) {

        Connection connection;
        try {
            connection = connectionFactory.getConnection();

            String updateSQL = "UPDATE entidadBancaria SET codigoEntidadBancaria = ?, nombre = ?, cif = ?, tipoEntidadBancaria = ? WHERE idEntidadBancaria = ?";

            PreparedStatement preparedStatementUpdate = connection.prepareStatement(updateSQL);

            preparedStatementUpdate.setString(1, entidadBancaria.getCodigoEntidadBancaria());
            preparedStatementUpdate.setString(2, entidadBancaria.getNombre());
            preparedStatementUpdate.setString(3, entidadBancaria.getCif());
            preparedStatementUpdate.setString(4, entidadBancaria.getTipoEntidadBancaria().name());
            preparedStatementUpdate.setInt(5, entidadBancaria.getIdEntidadBancaria());

            preparedStatementUpdate.executeUpdate();

            connection.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

    @Override
    public void delete(EntidadBancaria entidadBancaria) {

        Connection connection;
        try {
            connection = connectionFactory.getConnection();

            String deleteSQL = "DELETE FROM entidadBancaria WHERE idEntidadBancaria = ?";

            PreparedStatement preparedStatementDelete = connection.prepareStatement(deleteSQL);

            preparedStatementDelete.setInt(1, entidadBancaria.getIdEntidadBancaria());

            int numeroEntidades = preparedStatementDelete.executeUpdate();

            if (numeroEntidades > 1) {     //Si hay más de una entidad con el mismo ID

                throw new RuntimeException("Hay mas de una entidad Bancaria con Identificador: " + entidadBancaria.getIdEntidadBancaria());

            }
            connection.close();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

    @Override
    public List<EntidadBancaria> findAll() {

        Connection connection;

        try {

            connection = connectionFactory.getConnection();
            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();

            String selectSQL = "SELECT * FROM entidadbancaria";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatementSelect.executeQuery();

            while (resultSet.next()) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();

                int idEntidadBancaria = resultSet.getInt("idEntidadBancaria");
                String codigoEntidadBancaria = resultSet.getString("codigoEntidadBancaria");
                String nombre = resultSet.getString("nombre");
                String cif = resultSet.getString("cif");
                String tipoEntidadBancaria = resultSet.getString("tipoEntidadBancaria");

                entidadBancaria.setIdEntidadBancaria(idEntidadBancaria);
                entidadBancaria.setCodigoEntidadBancaria(codigoEntidadBancaria);
                entidadBancaria.setNombre(nombre);
                entidadBancaria.setCif(cif);
                entidadBancaria.setTipoEntidadBancaria(TipoEntidadBancaria.valueOf(tipoEntidadBancaria));

                entidadesBancarias.add(entidadBancaria);

            }
            connection.close();
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

    @Override
    public List<EntidadBancaria> findByCodigo(String codigo) {

        Connection connection;
        try {
            connection = connectionFactory.getConnection();

            List<EntidadBancaria> entidadesBancarias = new ArrayList<>();

            String selectSQL = "SELECT * FROM entidadbancaria WHERE codigoEntidadBancaria = ?";

            PreparedStatement preparedStatementSelect = connection.prepareStatement(selectSQL);
            preparedStatementSelect.setString(1, codigo);

            ResultSet resultSet = preparedStatementSelect.executeQuery();

            while (resultSet.next()) {

                EntidadBancaria entidadBancaria = new EntidadBancaria();

                int idEntidadBancaria = resultSet.getInt("idEntidadBancaria");
                String codigoEntidadBancaria = resultSet.getString("codigoEntidadBancaria");
                String nombre = resultSet.getString("nombre");
                String cif = resultSet.getString("cif");
                String tipoEntidadBancaria = resultSet.getString("tipoEntidadBancaria");

                entidadBancaria.setIdEntidadBancaria(idEntidadBancaria);
                entidadBancaria.setCodigoEntidadBancaria(codigoEntidadBancaria);
                entidadBancaria.setNombre(nombre);
                entidadBancaria.setCif(cif);
                entidadBancaria.setTipoEntidadBancaria(TipoEntidadBancaria.valueOf(tipoEntidadBancaria));

                entidadesBancarias.add(entidadBancaria);

            }
            connection.close();
            return entidadesBancarias;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } 
    }

}
