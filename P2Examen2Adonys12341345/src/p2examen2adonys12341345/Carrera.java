/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2examen2adonys12341345;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author adony
 */
public class Carrera implements Runnable {

    private JProgressBar progreso;
    private Carros carro;
    private String nombre;
    private Cronometro cronometro;
    public static  boolean ganador = false;
    public Carrera(JProgressBar progreso, Carros carro, String nombre, Cronometro cronometro) {
        this.progreso = progreso;
        this.carro = carro;
        this.nombre = nombre;
        this.cronometro = cronometro;
    }

    @Override
    public void run() {
        int velocidad = carro.getVelocidad();
        for (int i = 0; i <= 100 && !ganador; i++) {
            try {
                Thread.sleep(1000 / velocidad);
                progreso.setValue(i);
                if (i == 100) {
                    ganador = true;
                    JOptionPane.showMessageDialog(null, nombre + " ha ganado en " + cronometro.getSegundos() + " segundos!");
                    cronometro.detener();
                    ganador = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
