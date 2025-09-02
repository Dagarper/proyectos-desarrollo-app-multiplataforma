package com.mycompany.prog02_ejercicio7;

/**
 *
 * @author David
 */

/*
 * Diseña un programa Java denominado PROG02_Ejerc7 para resolver una ecuación
 * de primer grado con una incógnita (x), suponiendo que los coeficientes de la ecuación
 * son C1 y C2 se inicializan en el método main:
 * C1x + C2 = 0
 * Se debe mostrar el resultado con 4 decimales.
 */
public class PROG02_Ejercicio7 {

    public static void main(String[] args) {
        
        // Variables
        double C1 = 1.32;
        double C2 = 4.68;
        
        // Obtenemos x
        double x = -C2/C1;
        
        // Sacamos 4 decimales
        System.out.printf("X => %.4f", x);
    }
}
