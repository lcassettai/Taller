/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class EmpleadosDTO {

    private int id_Empleado;
    private String usuario;
    private String pass;
    private int id_Rol;
    private int id_Persona;

    public EmpleadosDTO() {
    }

    public EmpleadosDTO(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public EmpleadosDTO(int id_Empleado, String usuario, String pass, int id_Rol, int id_Persona) {
        this.id_Empleado = id_Empleado;
        this.usuario = usuario;
        this.pass = pass;
        this.id_Rol = id_Rol;
        this.id_Persona = id_Persona;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

}
