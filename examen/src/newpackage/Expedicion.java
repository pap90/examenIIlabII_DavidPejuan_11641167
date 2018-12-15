/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class Expedicion extends Thread {

    private nave nave;

    private ArrayList datos = new ArrayList();
    private JTable tabla;

    public Expedicion(nave nave, JTable tabla) {
        this.nave = nave;
        this.tabla = tabla;
    }

    public nave getNave() {
        return nave;
    }

    public void setNave(nave nave) {
        this.nave = nave;
    }

    public ArrayList getDatos() {
        return datos;
    }

    public void setDatos(ArrayList datos) {
        this.datos = datos;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    @Override
    public void run() {
        
        double num = 0;
        boolean termina = false;
        boolean ida = false;
        boolean vuelta = false;
        while (termina != true) {
            

            if (vuelta == true && vuelta == true) {
                termina = true;
                System.out.println("1");
            }
            if (num == (double) datos.get(0)) {
                num = 0;
                ida = true;
                System.out.println("2");
            }
            if (num == (double) datos.get(1)) {
                num = 0;
                vuelta = true;
                System.out.println("3");
            }
            num++;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
        System.out.println("funciono");
        Object row2[] = {nave.getSerie(), nave.getDestino()};
        DefaultTableModel m = (DefaultTableModel) tabla.getModel();
        m.addRow(row2);
        tabla.setModel(m);

    }
}
