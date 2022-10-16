/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.MecanicosDTO;
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
public class MecanicosDAO implements Obligacion<MecanicosDTO> {

    private static final String SQL_INSERT = "INSERT INTO mecanicos (id_Mecanico, id_Empleado, id_Especialidad)VALUES (?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM mecanicos WHERE id_Mecanico=?";
    private static final String SQL_UPDATE = "UPDATE mecanicos SET id_Empleado=?, id_Especialidad=? WHERE id_Mecanico=?";
    private static final String SQL_READ = "SELECT * FROM mecanicos WHERE id_Mecanico=?";
    private static final String SQL_READALL = "SELECT * FROM  mecanicos";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(MecanicosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Mecanico());
            ps.setInt(2, c.getId_Empleado());
            ps.setInt(3, c.getId_Especialidad());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MecanicosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MecanicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(MecanicosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Empleado());
            ps.setInt(2, c.getId_Especialidad());
            ps.setInt(3, c.getId_Mecanico());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MecanicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public MecanicosDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        MecanicosDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new MecanicosDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(MecanicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<MecanicosDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<MecanicosDTO> mecanicos = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                mecanicos.add(new MecanicosDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(MecanicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return mecanicos;
    }

}
