/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class administrarplanetas {

    private ArrayList<planeta> listaplanetas = new ArrayList();
    private File archivo = null;

    public administrarplanetas(String path) {
        archivo = new File(path);
    }

    public ArrayList<planeta> getListaplanetas() {
        return listaplanetas;
    }

    public void setListaplanetas(ArrayList<planeta> listaplanetas) {
        this.listaplanetas = listaplanetas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setplaneta(planeta p) {
        this.listaplanetas.add(p);
    }

    public void cargarArchivo() {
        try {
            listaplanetas = new ArrayList();
            planeta temp;
            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (planeta) objeto.readObject()) != null) {
                        listaplanetas.add(temp);
                    }
                } catch (EOFException e) {
                    System.out.println("lo mismo que en astronautas :'v");
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (planeta p : listaplanetas) {
                bw.writeObject(p);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }

}
