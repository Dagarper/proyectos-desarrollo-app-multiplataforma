package com.mycompany.ordenarnumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase lee una serie de números enteros de la entrada estándar,
 * los ordena de forma ascendente y los imprime en la consola separados por espacios.
 * 
 * Ejemplo de uso:
 * Al ingresar: 3 1 4 1 5
 * La salida será: 1 1 3 4 5
 * 
 * @author David
 */

public class Main {
    
    public static void main(String[] args) {
        
        // Crear un objeto Scanner para leer los números desde la entrada estándar.
        Scanner entrada = new Scanner(System.in);
        
        // Lista para almacenar los números ingresados.
        List<Integer> numeros = new ArrayList<>();

        // Leer números de la entrada estándar hasta que no haya más entradas
        while (entrada.hasNextInt()) {
            numeros.add(entrada.nextInt());
        }

        // Ordenar la lista de números en orden ascendente
        Collections.sort(numeros);

        // Imprimir los números ordenados, separados por espacios
        for (int i = 0; i < numeros.size(); i++) {
            System.out.print(numeros.get(i));
            if (i < numeros.size() - 1) {
                System.out.print(" ");// Agregar un espacio entre los números.
            }
        }

        System.out.println();// Salto de línea al final.
        entrada.close();// Cerrar el objeto Scanner para liberar recursos.
    }
}