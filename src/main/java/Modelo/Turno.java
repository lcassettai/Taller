/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author luciano
 */
public class Turno {

    int idTurno;
    Cliente cliente;
    Mecanico mecanico;
    Date dia;
    Date hora;
    String estadoTurno;

    public Turno() {
    }

    public Turno(int idTurno, Cliente cliente, Mecanico mecanico, Date dia, Date hora, String estadoTurno) {
        this.idTurno = idTurno;
        this.cliente = cliente;
        this.mecanico = mecanico;
        this.dia = dia;
        this.hora = hora;
        this.estadoTurno = estadoTurno;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
    }

}
