package com.mycompany.aleatorios;

import java.util.Random;

/**
 * Clase que genera un arreglo de 40 números aleatorios entre 0 y 100 (inclusive),
 * y los imprime en la consola separados por espacios.
 * 
 * @author David
 */

public class Main {

    public static void main(String[] args) {
        // Arreglo para almacenar 40 números aleatorios.
        int[] numeros = new int[40];
        Random r = new Random();

        // Generar 40 números aleatorios entre 0 y 100 (inclusive)
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt(101); // Genera un número entre 0 y 100
        }

        // Imprimir los números separados por espacios
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(" ");// Agregar un espacio entre los números.
            }
        }

        System.out.println(); // Salto de línea al final
    }
}
