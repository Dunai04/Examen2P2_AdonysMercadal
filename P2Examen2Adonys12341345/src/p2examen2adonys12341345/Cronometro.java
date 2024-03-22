/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2examen2adonys12341345;

import javax.swing.JLabel;

/**
 *
 * @author adony
 */
public class Cronometro implements Runnable {

    private JLabel cronometro;
    private boolean corriendo;

    public Cronometro(JLabel cronometro) {
        this.cronometro = cronometro;
        this.corriendo = true;
    }

    @Override
    public void run() {
        int segundos = 0;
        while (corriendo && !Carrera.ganador ) {
            try {
                Thread.sleep(1000);
                cronometro.setText(String.valueOf(segundos++));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void detener() {
        this.corriendo = false;
    }

    public int getSegundos() {
        return Integer.parseInt(cronometro.getText());
    }
}
