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
public class HorariosAtencionDTO {

    private int id_Horario;
    private int id_Mecanico;
    private Date dia;
    private Date hora_Inicio;
    private Date hora_Fin;

    public HorariosAtencionDTO() {
    }

    public HorariosAtencionDTO(int id_Horario) {
        this.id_Horario = id_Horario;
    }

    public HorariosAtencionDTO(int id_Horario, int id_Mecanico, Date dia, Date hora_Inicio, Date hora_Fin) {
        this.id_Horario = id_Horario;
        this.id_Mecanico = id_Mecanico;
        this.dia = dia;
        this.hora_Inicio = hora_Inicio;
        this.hora_Fin = hora_Fin;
    }

    public int getId_Horario() {
        return id_Horario;
    }

    public void setId_Horario(int id_Horario) {
        this.id_Horario = id_Horario;
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

    public Date getHora_Inicio() {
        return hora_Inicio;
    }

    public void setHora_Inicio(Date hora_Inicio) {
        this.hora_Inicio = hora_Inicio;
    }

    public Date getHora_Fin() {
        return hora_Fin;
    }

    public void setHora_Fin(Date hora_Fin) {
        this.hora_Fin = hora_Fin;
    }



}
