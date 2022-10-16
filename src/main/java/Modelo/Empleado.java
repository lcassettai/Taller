/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author luciano
 */
public abstract class Empleado extends Persona {

    int idEmpleado;
    String usuario;
    String pass;
    Rol rolEmpleado;
    
    public Empleado(){
        
    }

    public Empleado(int idEmpleado, String usuario, String pass, Rol rolEmpleado, int idPersona, String nombres, String apellido, String nroDocumento, String tipoDocumento, String telefono) {
        super(idPersona, nombres, apellido, nroDocumento, tipoDocumento, telefono);
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.pass = pass;
        this.rolEmpleado = rolEmpleado;
    }   

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public Rol getRolEmpleado() {
        return rolEmpleado;
    }

    public void setRolEmpleado(Rol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }
}
