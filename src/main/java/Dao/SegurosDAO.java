/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.SegurosDTO;
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
public class SegurosDAO implements Obligacion<SegurosDTO> {

    private static final String SQL_INSERT = "INSERT INTO seguros (id_Seguro, seguro)VALUES (?,?)";
    private static final String SQL_DELETE = "DELETE FROM seguros WHERE id_Seguro=?";
    private static final String SQL_UPDATE = "UPDATE seguros SET seguros=? WHERE id_Seguro=?";
    private static final String SQL_READ = "SELECT * FROM seguros WHERE id_seguro=?";
    private static final String SQL_READALL = "SELECT * FROM  seguros";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(SegurosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Seguro());
            ps.setString(2, c.getSeguro());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SegurosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SegurosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(SegurosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Seguro());
            ps.setString(2, c.getSeguro());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SegurosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public SegurosDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        SegurosDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new SegurosDTO(
                    res.getInt(1),
                    res.getString(2));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(SegurosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<SegurosDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<SegurosDTO> seguros = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                seguros.add(new SegurosDTO(
                    res.getInt(1),
                    res.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SegurosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return seguros;
    }

}
