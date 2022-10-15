/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class EspecialidadDTO {

    private int idEspecialidad;
    private String tipoEspecialidad;

    public EspecialidadDTO() {
    }

    public EspecialidadDTO(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public EspecialidadDTO(int idEspecialidad, String tipoEspecialidad) {
        this.idEspecialidad = idEspecialidad;
        this.tipoEspecialidad = tipoEspecialidad;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getTipoEspecialidad() {
        return tipoEspecialidad;
    }

    public void setTipoEspecialidad(String tipoEspecialidad) {
        this.tipoEspecialidad = tipoEspecialidad;
    }

}
