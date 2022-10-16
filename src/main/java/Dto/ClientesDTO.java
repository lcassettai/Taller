/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class ClientesDTO {

    private int id_Cliente;
    private int id_Persona;

    
    public ClientesDTO() {
    }
    
    public ClientesDTO(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public ClientesDTO(int id_Cliente, int id_Persona) {
        this.id_Cliente = id_Cliente;
        this.id_Persona = id_Persona;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(int id_Persona) {
        this.id_Persona = id_Persona;
    }

}