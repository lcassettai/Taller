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
public class HorarioAtencion {

    int idHorario;
    int dia; // 1 Lunes al 7  Domingo
    Date hora_inicio;
    Date hora_fin;

    public HorarioAtencion() {

    }

    public HorarioAtencion(int idHorario, int dia, Date hora_inicio, Date hora_fin) {
        this.setIdHorario(idHorario);
        this.setDia(dia);
        this.setHora_inicio(hora_inicio);
        this.setHora_fin(hora_fin);
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

}
