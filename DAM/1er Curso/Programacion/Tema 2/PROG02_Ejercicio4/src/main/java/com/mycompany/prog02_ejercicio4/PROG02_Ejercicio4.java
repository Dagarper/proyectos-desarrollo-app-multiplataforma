/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog02_ejercicio4;

/**
 *
 * @author David
 */
public class PROG02_Ejercicio4 {

    public static void main(String[] args) {
         // declaramos la edad
        byte edad = 16;

        // booleano para indicar si es mayor o no
        boolean esMayor = edad >= 18;
        String respuesta;

        // Guardamos la respuesta
        respuesta = esMayor ? "Es mayor" : "Es menor";
        
        System.out.println(respuesta);
    }
}
