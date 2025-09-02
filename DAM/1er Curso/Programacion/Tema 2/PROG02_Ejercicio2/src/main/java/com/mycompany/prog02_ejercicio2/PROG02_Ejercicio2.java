/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejercicio2;

/**
 *
 * @author David
 */
public class PROG02_Ejercicio2 {

    public static void main(String[] args) {
         // No valido: porque double es una palabra reservada
        int double;
        // No valido: porque no puede empezar por caracteres como /
        int /horaactual;
        // Valido: porque puede empezar con caracteres como $
        int $hora;
        // Valido
        int MiHora;
        // Valido: porque puede empezar con caracteres como _
        int _hora;
        // No valido: no puede empezar por numeros
        int 5hora;
        // No valido: porque char es una palabra reservada
        int char;
    }
}
