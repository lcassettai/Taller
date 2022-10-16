/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class RolesDTO {

    private int id_Rol;
    private String rol;

    public RolesDTO() {
    }

    public RolesDTO(int id_Rol) {
        this.id_Rol = id_Rol;
    }

    public RolesDTO(int id_Rol, String rol) {
        this.id_Rol = id_Rol;
        this.rol = rol;
    }

    public int getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(int id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
