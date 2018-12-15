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
public class tripulada extends nave {

    private String lugar;
    private ArrayList<astronauta> tripulacion = new ArrayList();

    public tripulada() {
    }

    public tripulada(String lugar, int serie, planeta destino, Double velocidad) {
        super(serie, destino, velocidad);
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public ArrayList<astronauta> getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(ArrayList<astronauta> tripulacion) {
        this.tripulacion = tripulacion;
    }

    @Override
    public ArrayList calcularTiempo() {
        ArrayList<Double> tiempos = new ArrayList();
        Double tiempo1, tiempo2;
        double suma = 0;
        for (int i = 0; i < tripulacion.size(); i++) {
            suma += Math.pow(tripulacion.get(i).getPeso(), 2);
        }
        double sumafinal = suma / 100;
        tiempo1 = (super.getDestino().getDistancia() / (super.getVelocidad() * sumafinal));
        tiempo2 = (super.getDestino().getDistancia() / (super.getVelocidad() * sumafinal));
        tiempos.add(tiempo1);
        tiempos.add(tiempo2);
        return tiempos;
    }

    @Override
    void expedicion(nave nave, JTable tabla) {
        ArrayList datos = this.calcularTiempo();
        Expedicion ex = new Expedicion(nave, tabla);
        ex.setDatos(datos);
        ex.start();
    }

}
