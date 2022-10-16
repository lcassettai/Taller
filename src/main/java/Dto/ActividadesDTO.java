/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class ActividadesDTO {

    private int id_Actividad;
    private int id_Ficha_Mecanica;
    private int hs_Empleadas;
    private double costo_Servicio;

    public ActividadesDTO() {
    }

    public ActividadesDTO(int id_Actividad) {
        this.id_Actividad = id_Actividad;
    }

    public ActividadesDTO(int id_Actividad, int id_Ficha_Mecanica, int hs_Empleadas, double costo_Servicio) {
        this.id_Actividad = id_Actividad;
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
        this.hs_Empleadas = hs_Empleadas;
        this.costo_Servicio = costo_Servicio;
    }

    public int getId_Actividad() {
        return id_Actividad;
    }

    public void setId_Actividad(int id_Actividad) {
        this.id_Actividad = id_Actividad;
    }

    public int getId_Ficha_Mecanica() {
        return id_Ficha_Mecanica;
    }

    public void setId_Ficha_Mecanica(int id_Ficha_Mecanica) {
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
    }

    public int getHs_Empleadas() {
        return hs_Empleadas;
    }

    public void setHs_Empleadas(int hs_Empleadas) {
        this.hs_Empleadas = hs_Empleadas;
    }

    public double getCosto_Servicio() {
        return costo_Servicio;
    }

    public void setCosto_Servicio(double costo_Servicio) {
        this.costo_Servicio = costo_Servicio;
    }

    
    }
    

   