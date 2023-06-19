/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.SwingWorker;
import org.example.ordenamiento.IOrdenamiento;

/**
 *
 * @author Augusto
 */
public class Worker extends SwingWorker<Object, Object>{
    
    IOrdenamiento algoritmo;
    
    public Worker(IOrdenamiento algoritmo) {
        this.algoritmo = algoritmo;
    }

    @Override
    protected Object doInBackground() throws Exception {
       algoritmo.metodoOrdenamiento();
        double progreso = algoritmo.getPrimerIndice() / 100000 - 1;
        algoritmo.getBarra().setValue((int) progreso * algoritmo.getBarra().getMaximum());
        algoritmo.getBarra().repaint();
        return null;
    }
    
}
