package org.example.ordenamiento;

import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public abstract class IOrdenamiento extends SwingWorker<Void, Integer>{
    private final JProgressBar barraProgreso;
    protected int[] vector;
    protected int primerIndice;

    public IOrdenamiento(JProgressBar barraProgreso, int[] vector) {
        this.barraProgreso = barraProgreso;
        this.vector = vector;
    }

    public abstract void metodoOrdenamiento();

    public void actualizarBarra(int indice) {
        double progress = indice / vector.length - 1;
        int porcentajeProgreso = (int) progress * barraProgreso.getMaximum();
        setProgress(barraProgreso, porcentajeProgreso);
    }
    
    public int getPrimerIndice() {
        return primerIndice;
    }
    
    public JProgressBar getBarra() {
        return barraProgreso;
    }

    @Override
    protected Void doInBackground() throws Exception {
        metodoOrdenamiento();
        return null;
    }
    
    @Override
    protected void process(java.util.List<Integer> chunks) {
        int progress = chunks.get(chunks.size() - 1);
        barraProgreso.setValue(progress);
    }
    
    @Override
    protected void done() {
        JOptionPane.showMessageDialog(null, "Finalizado");
    }
    
    private void setProgress(final JProgressBar progressBar, final int progress) {
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(progress);
        });
    }
}
