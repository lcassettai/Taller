/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author luciano
 */
public class Seguro {
    int idSeguro;
    String seguro;
    
    public Seguro(){
    }

    public Seguro(int idSeguro, String seguro) {
        this.idSeguro = idSeguro;
        this.seguro = seguro;
    }  

    public int getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(int idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }
   
    
}
