package org.example;

import utils.GeneradorDeVectores;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class SortingProgram extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar selectionProgressBar;
    private JProgressBar insertionProgressBar;
    private JButton btnStart;

    public SortingProgram() {
        setTitle("Sorting Program");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel progressBarPanel = new JPanel();
        progressBarPanel.setLayout(new BorderLayout());
        contentPane.add(progressBarPanel, BorderLayout.CENTER);

        selectionProgressBar = new JProgressBar();
        progressBarPanel.add(selectionProgressBar, BorderLayout.NORTH);

        insertionProgressBar = new JProgressBar();
        progressBarPanel.add(insertionProgressBar, BorderLayout.SOUTH);

        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);
                selectionProgressBar.setValue(0);
                selectionProgressBar.setMaximum(100);
                insertionProgressBar.setValue(0);
                insertionProgressBar.setMaximum(100);

                SwingWorker<Void, Integer> selectionSortWorker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        int[] vector = GeneradorDeVectores.vectorGrande(100000);
                        selectionSort(vector);
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        int progress = chunks.get(chunks.size() - 1);
                        selectionProgressBar.setValue(progress);
                    }

                    @Override
                    protected void done() {
                        btnStart.setEnabled(true);
                    }
                };

                SwingWorker<Void, Integer> insertionSortWorker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        int[] vector = { 5, 2, 8, 1, 9, 3, 7, 6, 4 };
                        insertionSort(vector);
                        return null;
                    }

                    @Override
                    protected void process(java.util.List<Integer> chunks) {
                        int progress = chunks.get(chunks.size() - 1);
                        insertionProgressBar.setValue(progress);
                    }

                    @Override
                    protected void done() {
                        btnStart.setEnabled(true);
                    }
                };

                selectionSortWorker.execute();
                insertionSortWorker.execute();
            }
        });
        contentPane.add(btnStart, BorderLayout.SOUTH);
    }

    private void selectionSort(int[] vector) {
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

            double progress = (double) (i + 1) / (n - 1);
            int progressPercentage = (int) (progress * 100);
            setProgress(selectionProgressBar, progressPercentage);
        }
    }

    private void insertionSort(int[] vector) {
        int n = vector.length;
        for (int i = 1; i < n; i++) {
            int key = vector[i];
            int j = i - 1;
            while (j >= 0 && vector[j] > key) {
                vector[j + 1] = vector[j];
                j--;
            }
            vector[j + 1] = key;

            double progress = (double) i / (n - 1);
            int progressPercentage = (int) (progress * 100);
            setProgress(insertionProgressBar, progressPercentage);
        }
    }

    private void setProgress(final JProgressBar progressBar, final int progress) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                progressBar.setValue(progress);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SortingProgram frame = new SortingProgram();
                frame.setVisible(true);
            }
        });
    }
}
