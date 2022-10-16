/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.FichasMecanicasDTO;
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
public class FichasMecanicasDAO implements Obligacion<FichasMecanicasDTO> {

    private static final String SQL_INSERT = "INSERT INTO fichas_mecanicas (id_Ficha_Mecanica, id_Turno, id_Vehiculo, motivo, repuesto)VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM fichas_mecanicas WHERE id_Ficha_Mecanica=?";
    private static final String SQL_UPDATE = "UPDATE fichas_mecanicas SET id_Turno=?, id_Vehiculo=?, motivo=?, repuesto=? WHERE id_Ficha_Mecanica=?";
    private static final String SQL_READ = "SELECT * FROM fichas_mecanicas WHERE id_Ficha_Mecanica=?";
    private static final String SQL_READALL = "SELECT * FROM  fichas_mecanicas";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(FichasMecanicasDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Ficha_Mecanica());
            ps.setInt(2, c.getId_Turno());
            ps.setInt(3, c.getId_Vehiculo());
            ps.setString(4, c.getMotivo());
            ps.setString(5, c.getRepuesto());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FichasMecanicasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(FichasMecanicasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(FichasMecanicasDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Turno());
            ps.setInt(2, c.getId_Vehiculo());
            ps.setString(3, c.getMotivo());
            ps.setString(4, c.getRepuesto());
            ps.setInt(5, c.getId_Ficha_Mecanica());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FichasMecanicasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public FichasMecanicasDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        FichasMecanicasDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new FichasMecanicasDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getString(4),
                    res.getString(5));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(FichasMecanicasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<FichasMecanicasDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<FichasMecanicasDTO> fichas_mecanicas = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                fichas_mecanicas.add(new FichasMecanicasDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getInt(3),
                    res.getString(4),
                    res.getString(5)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(FichasMecanicasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return fichas_mecanicas;
    }

}
