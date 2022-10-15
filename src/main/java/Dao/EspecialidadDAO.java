/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.EspecialidadDTO;
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
public class EspecialidadDAO implements Obligacion<EspecialidadDTO> {

    private static final String SQL_INSERT = "INSERT INTO especialidades (id_Especialidad, tipo_Especialidad)VALUES (?,?)";
    private static final String SQL_DELETE = "DELETE FROM especialidades WHERE id_Especialidad=?";
    private static final String SQL_UPDATE = "UPDATE especialidades SET id_Especialidad=?, tipo_Especialidad=? WHERE id_Especialidad=?";
    private static final String SQL_READ = "SELECT * FROM especialidades WHERE id_especialidad=?";
    private static final String SQL_READALL = "SELECT * FROM  especialidades";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(EspecialidadDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getIdEspecialidad());
            ps.setString(2, c.getTipoEspecialidad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(EspecialidadDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getIdEspecialidad());
            ps.setString(2, c.getTipoEspecialidad());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public EspecialidadDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        EspecialidadDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new EspecialidadDTO(res.getInt(1), res.getString(2));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<EspecialidadDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<EspecialidadDTO> especialidades = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                especialidades.add(new EspecialidadDTO(res.getInt(1), res.getString(2)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return especialidades;
    }

}
