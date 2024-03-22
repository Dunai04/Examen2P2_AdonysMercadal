/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2examen2adonys12341345;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author adony
 */
public class claseAdmin {

    private File archivo;
    ArrayList<Carros> listacarros = new ArrayList();

    public claseAdmin(String path) {
        archivo = new File(path);
        listacarros = new ArrayList<>();
    }

    public void guardarArchivo() {
        try {
            FileOutputStream fileOut = new FileOutputStream(archivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listacarros);
            out.close();
            fileOut.close();
        } catch (IOException i) {
        }
    }

    public void cargarArchivo() {
        try {
            FileInputStream fileIn = new FileInputStream(archivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            listacarros = (ArrayList<Carros>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {

        } catch (ClassNotFoundException c) {
        }
    }

    public void agregarCarro(Carros carro) {
        listacarros.add(carro);
    }

    public ArrayList<Carros> getCarros() {
        return listacarros;
    }

}
