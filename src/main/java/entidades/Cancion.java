/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jorge
 */
public class Cancion {
    String nombre;
    double duracion;
    
    public Cancion(String nombre, Double duracion) {
        
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }
    
    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
    
    
}
