/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author luciano
 */
public final class Cliente extends Persona {

    int idCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, int idPersona, String nombres, String apellido, String nroDocumento, String tipoDocumento, String telefono) {
        super(idPersona,nombres,apellido,nroDocumento,tipoDocumento,telefono);
        this.setIdCliente(idCliente);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
