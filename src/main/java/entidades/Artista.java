/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Artista {
    private String nombre;
    private String estilo;
    ArrayList<Cancion> canciones = new ArrayList<Cancion>();
   
    public Artista() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }
}
