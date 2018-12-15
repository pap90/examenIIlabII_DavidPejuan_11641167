/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author david
 */
public abstract class nave {
    private int serie;
    private planeta destino;
    private Double velocidad;

    public nave() {
    }

    public nave(int serie, planeta destino, Double velocidad) {
        this.serie = serie;
        this.destino = destino;
        this.velocidad = velocidad;
    }

    

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public planeta getDestino() {
        return destino;
    }

    public void setDestino(planeta destino) {
        this.destino = destino;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return Integer.toString(serie);
    }
    
    

    abstract void expedicion(nave nave, JTable tabla);
    
    public abstract ArrayList calcularTiempo();
    
}
