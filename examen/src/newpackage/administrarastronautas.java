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
public class administrarastronautas {

    private ArrayList<astronauta> listaastronautas = new ArrayList();
    private File archivo = null;

    public administrarastronautas(String path) {
        archivo = new File(path);
    }

    public ArrayList<astronauta> getListaastronautas() {
        return listaastronautas;
    }

    public void setListaastronautas(ArrayList<astronauta> listaastronautas) {
        this.listaastronautas = listaastronautas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setAstronauta(astronauta p) {
        this.listaastronautas.add(p);
    }

    public void cargarArchivo() {
        try {
            listaastronautas = new ArrayList();
            astronauta temp;
            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (astronauta) objeto.readObject()) != null) {
                        listaastronautas.add(temp);
                    }
                } catch (EOFException e) {
                    System.out.println("llego al final, sino sale esto, algo esta mal :v");
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
            for (astronauta t : listaastronautas) {
                bw.writeObject(t);
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
