/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author luciano
 */
public class Mecanico extends Empleado {

    int idMecanico;
    Especialidad especialidad;
    ArrayList<HorarioAtencion> horario = new ArrayList<HorarioAtencion>();

    public Mecanico() {
    }

    public Mecanico(int idMecanico, Especialidad especialidad) {
        this.idMecanico = idMecanico;
        this.especialidad = especialidad;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<HorarioAtencion> getHorario() {
        return horario;
    }

    public void setHorario(ArrayList<HorarioAtencion> horario) {
        this.horario = horario;
    }

}
