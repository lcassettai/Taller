/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import DataBase.Conexion;
import Dto.ClientesDTO;
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
public class ClientesDAO implements Obligacion<ClientesDTO> {

    private static final String SQL_INSERT = "INSERT INTO clientes (id_Cliente, id_Persona)VALUES (?,?)";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_Cliente=?";
    private static final String SQL_UPDATE = "UPDATE clientes SET id_Persona=? WHERE id_Clientes=?";
    private static final String SQL_READ = "SELECT * FROM clientes WHERE id_Cliente=?";
    private static final String SQL_READALL = "SELECT * FROM  clientes";

    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(ClientesDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_Cliente());
            ps.setInt(2, c.getId_Persona());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ClientesDTO c) {
        PreparedStatement ps;
        try {

            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getId_Persona());
            ps.setInt(2, c.getId_Cliente());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ClientesDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        ClientesDTO e = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();

            while (res.next()) {
                e = new ClientesDTO(
                    res.getInt(1),
                    res.getInt(2));
            }
            return e;
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return e;

    }

    @Override
    public List<ClientesDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<ClientesDTO> clientes = new ArrayList();
        try {

            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()) {
                clientes.add(new ClientesDTO(
                    res.getInt(1),
                    res.getInt(2)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return clientes;
    }

}
