/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.EmpleadosDTO;
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
public class EmpleadosDAO implements Obligacion<EmpleadosDTO> {

    private static final String SQL_INSERT = "INSERT INTO empleados (id_Empleado, usuario, pass, id_Rol, id_Persona)VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE id_Empleado=?";
    private static final String SQL_UPDATE = "UPDATE empleados SET usuario=?, pass=?, id_Rol=?, id_Persona=? WHERE id_Empleado=?";
    private static final String SQL_READ = "SELECT * FROM empleados WHERE id_Empleado=?";
    private static final String SQL_READALL = "SELECT * FROM  empleados";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(EmpleadosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Empleado());
            ps.setString(2, c.getUsuario());
            ps.setString(3, c.getPass());
            ps.setInt(4, c.getId_Rol());
            ps.setInt(5, c.getId_Persona());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(EmpleadosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getUsuario());
            ps.setString(2, c.getPass());
            ps.setInt(3, c.getId_Rol());
            ps.setInt(4, c.getId_Persona());
            ps.setInt(5, c.getId_Empleado());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public EmpleadosDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        EmpleadosDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new EmpleadosDTO(
                    res.getInt(1),
                    res.getString(2),
                    res.getString(3),
                    res.getInt(4),
                    res.getInt(5));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<EmpleadosDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<EmpleadosDTO> empleados = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                empleados.add(new EmpleadosDTO(
                    res.getInt(1),
                    res.getString(2),
                    res.getString(3),
                    res.getInt(4),
                    res.getInt(5)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return empleados;
    }
    
    public int validarUsuario(String usuario, String password) {
        PreparedStatement statement;
        ResultSet resultado;
        int idPersona = 0 ;
        
        String sql = "SELECT id_persona FROM empleados WHERE usuario = ? AND pass = ?";
        try {
            statement = con.getCnn().prepareStatement(sql);
            statement.setString(1, usuario);
            statement.setString(2, password);
            
            resultado = statement.executeQuery();

            while (resultado.next()) {
                idPersona = resultado.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return idPersona;
    }

}
