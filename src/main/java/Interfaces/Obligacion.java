/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;


import java.util.List;

/**
 *
 * @author win
 */
public interface Obligacion <Cualquiercosa> {
    public boolean create(Cualquiercosa c);
    public boolean delete(Object key);
    public boolean update(Cualquiercosa c);
    
    public Cualquiercosa read(Object key);
    public List<Cualquiercosa> readAll();
    
    
}
