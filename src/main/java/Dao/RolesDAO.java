/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.RolesDTO;
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
public class RolesDAO implements Obligacion<RolesDTO> {

    private static final String SQL_INSERT = "INSERT INTO roles (id_Rol, Rol)VALUES (?,?)";
    private static final String SQL_DELETE = "DELETE FROM roles WHERE id_Rol=?";
    private static final String SQL_UPDATE = "UPDATE roles SET Rol=? WHERE id_Rol=?";
    private static final String SQL_READ = "SELECT * FROM roles WHERE id_Rol=?";
    private static final String SQL_READALL = "SELECT * FROM  roles";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(RolesDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Rol());
            ps.setString(2, c.getRol());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(RolesDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getRol());
            ps.setInt(2, c.getId_Rol());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public RolesDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        RolesDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new RolesDTO(
                    res.getInt(1),
                    res.getString(2));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<RolesDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<RolesDTO> roles = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                roles.add(new RolesDTO(
                    res.getInt(1),
                    res.getString(2)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RolesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return roles;
    }

}
