/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.ActividadesDTO;
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
public class ActividadesDAO implements Obligacion<ActividadesDTO> {

    private static final String SQL_INSERT = "INSERT INTO actividades (id_Actividad, id_Ficha_Mecanica, hs_Empleadas, costo_Servicio)VALUES (?,?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM actividades WHERE id_Actividad=?";
    private static final String SQL_UPDATE = "UPDATE actividades SET id_Ficha_Mecanica=?, hs_Empleadas=?, costo_Servicio=? WHERE id_Actividad=?";
    private static final String SQL_READ = "SELECT * FROM actividades WHERE id_Actividad=?";
    private static final String SQL_READALL = "SELECT * FROM  actividades";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(ActividadesDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Actividad());
            ps.setInt(2, c.getId_Ficha_Mecanica());
            ps.setInt(3, c.getHs_Empleadas());
            ps.setDouble(4, c.getCosto_Servicio());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ActividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ActividadesDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Ficha_Mecanica());
            ps.setInt(2, c.getHs_Empleadas());
            ps.setDouble(3, c.getCosto_Servicio());
            ps.setInt(4, c.getId_Actividad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ActividadesDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        ActividadesDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new ActividadesDTO(
                  res.getInt(1),
                  res.getInt(2),
                  res.getInt(3),
                  res.getDouble(4));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<ActividadesDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<ActividadesDTO> actividades = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                actividades.add(new ActividadesDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getDouble(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ActividadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return actividades;
    }

}
