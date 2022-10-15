/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author luciano
 */
public class Vehiculo {
    int idVehiculo;
    Cliente cliente;
    Seguro seguro;  
    int modelo;
    String marca;
    int poliza;
    int ano;
    String patente;

    public Vehiculo() {
    }

    public Vehiculo(int idVehiculo, Cliente cliente, Seguro seguro, int modelo, String marca, int poliza, int ano, String patente) {
        this.idVehiculo = idVehiculo;
        this.cliente = cliente;
        this.seguro = seguro;
        this.modelo = modelo;
        this.marca = marca;
        this.poliza = poliza;
        this.ano = ano;
        this.patente = patente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    
}
