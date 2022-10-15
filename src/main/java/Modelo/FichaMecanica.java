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
public class FichaMecanica {

    int idFicha;
    Turno turno;
    Vehiculo vehiculo;
    String repuestos;
    ArrayList<Actividad> actividades;

    public FichaMecanica() {
        actividades = new ArrayList<Actividad>();
    }

    public FichaMecanica(int idFicha, Turno turno, Vehiculo vehiculo, String repuestos, ArrayList<Actividad> actividades) {
        this.idFicha = idFicha;
        this.turno = turno;
        this.vehiculo = vehiculo;
        this.repuestos = repuestos;
        this.actividades = actividades;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }
}
