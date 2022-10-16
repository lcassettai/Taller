/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author win
 */
public class SegurosDTO {

    private int id_Seguro;
    private String seguro;

    public SegurosDTO() {
    }

    public SegurosDTO(int id_Seguro) {
        this.id_Seguro = id_Seguro;
    }

    public SegurosDTO(int id_Seguro, String seguro) {
        this.id_Seguro = id_Seguro;
        this.seguro = seguro;
    }

    public int getId_Seguro() {
        return id_Seguro;
    }

    public void setId_Seguro(int id_Seguro) {
        this.id_Seguro = id_Seguro;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }


}
