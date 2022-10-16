/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class FichasMecanicasDTO {

    private int id_Ficha_Mecanica;
    private int id_Turno;
    private int id_Vehiculo;
    private String motivo;
    private String repuesto;

    public FichasMecanicasDTO() {
    }

    public FichasMecanicasDTO(int id_Ficha_Mecanica) {
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
    }

    public FichasMecanicasDTO(int id_Ficha_Mecanica, int id_Turno, int id_Vehiculo, String motivo, String repuesto) {
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
        this.id_Turno = id_Turno;
        this.id_Vehiculo = id_Vehiculo;
        this.motivo = motivo;
        this.repuesto = repuesto;
    }

    public int getId_Ficha_Mecanica() {
        return id_Ficha_Mecanica;
    }

    public void setId_Ficha_Mecanica(int id_Ficha_Mecanica) {
        this.id_Ficha_Mecanica = id_Ficha_Mecanica;
    }

    public int getId_Turno() {
        return id_Turno;
    }

    public void setId_Turno(int id_Turno) {
        this.id_Turno = id_Turno;
    }

    public int getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(int id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }


}
