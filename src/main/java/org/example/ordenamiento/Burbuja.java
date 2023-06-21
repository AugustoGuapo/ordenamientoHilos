package org.example.ordenamiento;

import java.util.concurrent.CountDownLatch;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Burbuja extends IOrdenamiento {
    
    public Burbuja(JProgressBar barraProgreso, int[] vector, JLabel tiempo, CountDownLatch latch) {
        super(barraProgreso, vector, tiempo, latch);
    }

    @Override
    public void algoritmoOrdenamiento() {
        int n = vector.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (vector[j - 1] > vector[j]) {
                    temp = vector[j - 1];
                    vector[j - 1] = vector[j];
                    vector[j] = temp;
                }
            }
            actualizarBarra(i);
        }
    }

}
