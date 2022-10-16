/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.HorariosAtencionDTO;
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
public class HorariosAtencionDAO implements Obligacion<HorariosAtencionDTO> {

    private static final String SQL_INSERT = "INSERT INTO horarios_atencion (id_Horario, id_Mecanico, dia, hora_Inicio, hora_Fin)VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM horarios_atencion WHERE id_Horario=?";
    private static final String SQL_UPDATE = "UPDATE horarios_atencion SET id_Mecanico=?, dia=?, hora_Inicio=?, hora_Fin=? WHERE id_Horario=?";
    private static final String SQL_READ = "SELECT * FROM horarios_atencion WHERE id_Horario=?";
    private static final String SQL_READALL = "SELECT * FROM  horarios_atencion";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(HorariosAtencionDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Horario());
            ps.setInt(2, c.getId_Mecanico());
            ps.setDate(3, (Date) c.getDia());
            ps.setDate(4, (Date) c.getHora_Inicio());
            ps.setDate(5, (Date) c.getHora_Fin());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorariosAtencionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HorariosAtencionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(HorariosAtencionDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Mecanico());
            ps.setDate(2, (Date) c.getDia());
            ps.setDate(3, (Date) c.getHora_Inicio());
            ps.setDate(4, (Date) c.getHora_Fin());
            ps.setInt(5, c.getId_Horario());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorariosAtencionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public HorariosAtencionDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        HorariosAtencionDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new HorariosAtencionDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getDate(3),
                    res.getDate(4),
                    res.getDate(5));
            }    
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(HorariosAtencionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<HorariosAtencionDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<HorariosAtencionDTO> horarios_atencion = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                horarios_atencion.add(new HorariosAtencionDTO(
                    res.getInt(1),
                    res.getInt(2),
                    res.getDate(3),
                    res.getDate(4),
                    res.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HorariosAtencionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return horarios_atencion;
    }

}
