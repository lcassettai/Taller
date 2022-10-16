/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class MecanicosDTO {

    private int id_Mecanico;
    private int id_Empleado;
    private int id_Especialidad;

    public MecanicosDTO() {
    }

    public MecanicosDTO(int id_Mecanico) {
        this.id_Mecanico = id_Mecanico;
    }

    public MecanicosDTO(int id_Mecanico, int id_Empleado, int id_Especialidad) {
        this.id_Mecanico = id_Mecanico;
        this.id_Empleado = id_Empleado;
        this.id_Especialidad = id_Especialidad;
    }

    public int getId_Mecanico() {
        return id_Mecanico;
    }

    public void setId_Mecanico(int id_Mecanico) {
        this.id_Mecanico = id_Mecanico;
    }

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public int getId_Especialidad() {
        return id_Especialidad;
    }

    public void setId_Especialidad(int id_Especialidad) {
        this.id_Especialidad = id_Especialidad;
    }



}
