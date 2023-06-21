/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.ordenamiento;

import java.util.concurrent.CountDownLatch;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Augusto
 */
public class Insercion extends IOrdenamiento{
    
    public Insercion(JProgressBar barraProgreso, int[] vector, JLabel tiempo, CountDownLatch latch) {
        super(barraProgreso, vector, tiempo, latch);
    }

    @Override
    public void algoritmoOrdenamiento() {
        int n = vector.length;
        for (int i = 1; i < n; i++) {
            int key = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > key) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = key;

            actualizarBarra(i);
        }
    }
    
}
