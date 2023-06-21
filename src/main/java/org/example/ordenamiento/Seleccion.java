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
public class Seleccion extends IOrdenamiento{
    
    public Seleccion(JProgressBar barraProgreso, int[] vector, JLabel tiempo, CountDownLatch latch) {
        super(barraProgreso, vector, tiempo, latch);
    }

    @Override
    public void algoritmoOrdenamiento() {
        int n = vector.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (vector[j] < vector[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = vector[minIndex];
            vector[minIndex] = vector[i];
            vector[i] = temp;
            actualizarBarra(i+1);
        }
    }
}
