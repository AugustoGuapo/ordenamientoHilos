package org.example.ordenamiento;

import java.util.concurrent.CountDownLatch;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public abstract class IOrdenamiento extends Thread{
    private final JProgressBar barraProgreso;
    protected int[] vector;
    protected int primerIndice;
    protected JLabel tiempo;
    protected CountDownLatch latch;

    public IOrdenamiento(JProgressBar barraProgreso, int[] vector, JLabel tiempo, CountDownLatch latch) {
        this.barraProgreso = barraProgreso;
        this.vector = vector;
        this.tiempo = tiempo;
        this.latch = latch;
    }

    public abstract void algoritmoOrdenamiento();
    
    public void ordenar() {
        Long tInicio = System.currentTimeMillis();
        algoritmoOrdenamiento();
        Long tFinal = System.currentTimeMillis();
        tiempo.setText(String.format("%.2f s", (tFinal - tInicio)/1000.0));
    }

    public void actualizarBarra(int indice) {
        double progress = (indice+1) / (double) vector.length; 
        final int porcentajeProgreso = (int) (progress * barraProgreso.getMaximum());
        this.barraProgreso.setValue(porcentajeProgreso);
        
    }

    @Override
    public void run() {
        ordenar();
        latch.countDown();
    }
}
