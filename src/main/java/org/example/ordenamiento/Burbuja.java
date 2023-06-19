package org.example.ordenamiento;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

public class Burbuja extends IOrdenamiento {
    public Burbuja(JProgressBar barraProgreso, int[] vector) {
        super(barraProgreso, vector);
    }

    @Override
    public void metodoOrdenamiento() {
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
        System.out.println("finalizado");
    }

}
