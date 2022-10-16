/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

import java.util.Date;

/**
 *
 * @author win
 */
public class TurnosDTO {

    private int id_Turno;
    private int id_Cliente;
    private int id_Mecanico;
    private Date dia;
    private Date hora;
    private String estado_Turno;
    private int id_Ficha_Mecanica;

    public TurnosDTO() {
    }

    public TurnosDTO(int id_Turno) {
        this.id_Turno = id_Turno;
    }

    public TurnosDTO(int id_Turno, int id_Cliente, int id_Mecanico, Date dia, Date hora, String estado_Turno, int id_Ficha_Mecanica) {
        this.id_Turno = id_Turno;
        this.id_Cliente = id_Cliente;
        this.id_Mecanico = id_Mecanico;
        this.dia = dia;
        this.hora = hora;
        this.estado_Turno = estado_Turno;
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
    }

    public int getId_Turno() {
        return id_Turno;
    }

    public void setId_Turno(int id_Turno) {
        this.id_Turno = id_Turno;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public int getId_Mecanico() {
        return id_Mecanico;
    }

    public void setId_Mecanico(int id_Mecanico) {
        this.id_Mecanico = id_Mecanico;
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

    public String getEstado_Turno() {
        return estado_Turno;
    }

    public void setEstado_Turno(String estado_Turno) {
        this.estado_Turno = estado_Turno;
    }

    public int getId_Ficha_Mecanica() {
        return id_Ficha_Mecanica;
    }

    public void setId_Ficha_Mecanica(int id_Ficha_Mecanica) {
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
    }


}
