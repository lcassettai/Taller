/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.TurnosDTO;
import Interfaces.Obligacion;
import java.sql.Date;
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
public class TurnosDAO implements Obligacion<TurnosDTO> {

    private static final String SQL_INSERT = "INSERT INTO turnos (id_Turno, id_Cliente, id_Mecanico, dia, hora, estado_Turno, id_Ficha_Mecanica)VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM turnos WHERE id_Turno=?";
    private static final String SQL_UPDATE = "UPDATE turnos SET id_Cliente=?, id_Mecanico=?, dia=?, hora=?, estado_Turno=?, id_Ficha_Mecanica=? WHERE id_Turno=?";
    private static final String SQL_READ = "SELECT * FROM turnos WHERE id_Turno=?";
    private static final String SQL_READALL = "SELECT * FROM  turnos";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(TurnosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Turno());
            ps.setInt(2, c.getId_Cliente());
            ps.setInt(3, c.getId_Mecanico());
            ps.setDate(4, (Date) c.getDia());
            ps.setDate(5, (Date) c.getHora());
            ps.setString(6, c.getEstado_Turno());
            ps.setInt(7, c.getId_Ficha_Mecanica());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnosDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TurnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(TurnosDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Cliente());
            ps.setInt(2, c.getId_Mecanico());
            ps.setDate(3, (Date) c.getDia());
            ps.setDate(4, (Date) c.getHora());
            ps.setString(5, c.getEstado_Turno());
            ps.setInt(6, c.getId_Ficha_Mecanica());
            ps.setInt(7, c.getId_Turno());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public TurnosDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        TurnosDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new TurnosDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getDate(4),
                    res.getDate(5),
                    res.getString(6),
                    res.getInt(7));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(TurnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<TurnosDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<TurnosDTO> turnos = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                turnos.add(new TurnosDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getDate(4),
                    res.getDate(5),
                    res.getString(6),
                    res.getInt(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TurnosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return turnos;
    }

}
