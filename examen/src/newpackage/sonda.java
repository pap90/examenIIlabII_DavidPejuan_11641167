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
public class sonda extends nave{
    private String material;
    private double peso;

    public sonda() {
    }

    public sonda(String material, double peso, int serie, planeta destino, Double velocidad) {
        super(serie, destino, velocidad);
        this.material = material;
        this.peso = peso;
    }

    

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    @Override
    public ArrayList calcularTiempo() {
        ArrayList<Double> tiempos=new ArrayList();
        Double tiempo1,tiempo2;
        tiempo1=super.getDestino().getDistancia()/super.getVelocidad();
        tiempo2=(9.8)*super.getVelocidad();
        tiempos.add(tiempo1);
        tiempos.add(tiempo2);
        return tiempos;
    }

    @Override
    void expedicion(nave nave, JTable tabla) {
        ArrayList datos = this.calcularTiempo();
        Expedicion ex=new Expedicion(nave, tabla);
        ex.setDatos(datos);
        ex.start();
    }

    

    

   
    
}
