/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.VehiculosDTO;
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
public class VehiculosDAO implements Obligacion<VehiculosDTO> {

    private static final String SQL_INSERT = "INSERT INTO vehiculos (id_Vehiculo, id_Cliente, id_Seguro, modelo, marca, poliza, año, patente)VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM vehiculos WHERE id_Vehiculo=?";
    private static final String SQL_UPDATE = "UPDATE vehiculos SET id_Cliente=?, id_Seguro=?, modelo=?, marca=?, poliza=?, año=?, patente=? WHERE id_Vehiculo=?";
    private static final String SQL_READ = "SELECT * FROM vehiculos WHERE id_vehiculo=?";
    private static final String SQL_READALL = "SELECT * FROM  vehiculos";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(VehiculosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Vehiculo());
            ps.setInt(2, c.getId_Cliente());
            ps.setInt(3, c.getId_Seguro());
            ps.setInt(4, c.getModelo());
            ps.setString(5, c.getMarca());
            ps.setInt(6, c.getPoliza());
            ps.setInt(7, c.getAño());
            ps.setString(8, c.getPatente());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(VehiculosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Cliente());
            ps.setInt(2, c.getId_Seguro());
            ps.setInt(3, c.getModelo());
            ps.setString(4, c.getMarca());
            ps.setInt(5, c.getPoliza());
            ps.setInt(6, c.getAño());
            ps.setString(7, c.getPatente());
            ps.setInt(8, c.getId_Vehiculo());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public VehiculosDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        VehiculosDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new VehiculosDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getInt(4),
                    res.getString(5),
                    res.getInt(6),
                    res.getInt(7),
                    res.getString(8));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<VehiculosDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<VehiculosDTO> vehiculos = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                vehiculos.add(new VehiculosDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getInt(4),
                    res.getString(5),
                    res.getInt(6),
                    res.getInt(7),
                    res.getString(8)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return vehiculos;
    }

}
