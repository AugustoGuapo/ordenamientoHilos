/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author Augusto
 */
public class Temporizador extends Thread{
    
    int tiempoEnSegundos;
    JButton boton;
    
    public Temporizador(int tiempoEnSegundos, JButton boton) {
        this.tiempoEnSegundos = tiempoEnSegundos;
        this.boton = boton;
    }
    public void run() {
        try {
            sleep(tiempoEnSegundos*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Temporizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        boton.setEnabled(true);
    }
}
