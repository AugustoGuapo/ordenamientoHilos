/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Random;

/**
 *
 * @author Augusto
 */
public class GeneradorDeVectores {
   
    public static int[] vectorGrande(int tamanoVector) {
        Random random = new Random();
        int[] salida = new int[tamanoVector];
        for (int i = 0; i < tamanoVector; i++) {
            salida[i] = random.nextInt(1, 2000000);
        }
        return salida;
    }
}
