/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.PersonaDTO;
import Interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author win
 */
public class PersonaDAO implements Obligacion<PersonaDTO> {

    private static final String SQL_INSERT = "INSERT INTO personas (nombre,apellido,tipo_documento,nro_documento,telefono) VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM personas WHERE id_persona=?";
    //private static final String SQL_UPDATE = "UPDATE personas SET tipo_Especialidad=? WHERE id_Especialidad=?";
    private static final String SQL_READ = "SELECT * FROM personas WHERE id_persona=?";
    private static final String SQL_READALL = "SELECT id_persona,nombre,apellido,tipo_documento,nro_documento,telefono FROM personas";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public ArrayList<PersonaDTO> readAll() {
        PreparedStatement statement;
        ResultSet resultado;
        ArrayList<PersonaDTO> personas = new ArrayList();
        try {
            statement = con.getCnn().prepareStatement(SQL_READALL);
            resultado = statement.executeQuery();

            while (resultado.next()) {
                personas.add(new PersonaDTO(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6))
                );

            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return personas;
    }

    @Override
    public PersonaDTO read(Object key) {
        PreparedStatement statement;
        ResultSet resultado;
        PersonaDTO persona = null;
        try {
            statement = con.getCnn().prepareStatement(SQL_READ);
            statement.setString(1, key.toString());
            resultado = statement.executeQuery();

            while (resultado.next()) {
                persona = new PersonaDTO(
                        resultado.getInt(1),
                        resultado.getString(2),
                        resultado.getString(3),
                        resultado.getString(4),
                        resultado.getString(5),
                        resultado.getString(6));
            }
            return persona;
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return persona;
    }

    @Override
    public boolean create(PersonaDTO c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean update(PersonaDTO c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
