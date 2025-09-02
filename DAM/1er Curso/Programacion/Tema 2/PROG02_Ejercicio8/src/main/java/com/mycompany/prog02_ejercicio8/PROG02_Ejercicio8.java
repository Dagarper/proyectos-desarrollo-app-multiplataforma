package com.mycompany.prog02_ejercicio8;

/**
 *
 * @author David
 */

/*
* 8.- Diseña un programa Java denominado PROG02_Ejerc8 que dados el número de
* alumnos matriculados en Programación, número de alumnos matriculados en Entornos
* de Desarrollo y número de alumnos matriculados en Base de datos. El programa deberá
* mostrar el % de alumnos matriculado en cada uno de los tres módulos. Se supone que
* un alumno sólo puede estar matrículado en un módulo. Trata de mostrar un solo
* decimal en los porcentajes.
*/

public class PROG02_Ejercicio8 {

    public static void main(String[] args) {
        // Alumnos
        int numProg = 30;
        int numEnt = 23;
        int numBD = 19;

        // Obtenemos el total
        int total = numProg + numEnt + numBD;

        // regla de 3
        //total   => 100%
        // alumno_asig => x
        double porcProg = (double) numProg * 100 / total;
        double porcEnt = (double) numEnt * 100 / total;
        double porcBD = (double) numBD * 100 / total;
        
        // Mostramos los porcentajes
        System.out.printf("Porc programacion: %.1f\n", porcProg);
        System.out.printf("Porc entornos: %.1f\n", porcEnt);
        System.out.printf("Porc base datos: %.1f\n", porcBD);
    }
}
