/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class VehiculosDTO {

    private int id_Vehiculo;
    private int id_Cliente;
    private int id_Seguro;
    private int modelo;
    private String marca;
    private int poliza;
    private int año;
    private String patente;

    public VehiculosDTO() {
    }

    public VehiculosDTO(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public VehiculosDTO(int id_Vehiculo, int id_Cliente, int id_Seguro, int modelo, String marca, int poliza, int año, String patente) {
        this.id_Vehiculo = id_Vehiculo;
        this.id_Cliente = id_Cliente;
        this.id_Seguro = id_Seguro;
        this.modelo = modelo;
        this.marca = marca;
        this.poliza = poliza;
        this.año = año;
        this.patente = patente;
    }

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Seguro() {
        return id_Seguro;
    }

    public void setId_Seguro(int id_Seguro) {
        this.id_Seguro = id_Seguro;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPoliza() {
        return poliza;
    }

    public void setPoliza(int poliza) {
        this.poliza = poliza;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }


}
