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
    private Estilo estilo;
    public ArrayList<Cancion> canciones;
   
    public Artista() {
        this.canciones = new ArrayList<>();
    }
    
    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }
    
    public void editarCancion(int index, String nombre, Double duracion) {
        this.canciones.get(index).setNombre(nombre);
        this.canciones.get(index).setDuracion(duracion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }
    
}
