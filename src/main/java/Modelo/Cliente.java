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
    
    public Cliente(){
        this.setIdCliente(0);
        super.setIdPersona(0);
        super.setNombres("");
        super.setApellido("");
        super.setNroDocumento("");
        super.setTipoDocumento("");
    }
    
    public Cliente(int idCliente, int idPersona, String nombres, String apellido, String nroDocumento, String tipoDocumento){
        this.setIdCliente(idCliente);
        super.setIdPersona(idPersona);
        super.setNombres(nombres);
        super.setApellido(apellido);
        super.setNroDocumento(nroDocumento);
        super.setTipoDocumento(tipoDocumento);
        
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
