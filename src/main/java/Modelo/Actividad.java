/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author luciano
 */
public class Actividad {

    int idActividad;
    int hsEmpleadas;
    double costo;

    public Actividad() {
    }

    public Actividad(int idActividad, int hsEmpleadas, double costo) {
        this.idActividad = idActividad;
        this.hsEmpleadas = hsEmpleadas;
        this.costo = costo;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getHsEmpleadas() {
        return hsEmpleadas;
    }

    public void setHsEmpleadas(int hsEmpleadas) {
        this.hsEmpleadas = hsEmpleadas;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

}
