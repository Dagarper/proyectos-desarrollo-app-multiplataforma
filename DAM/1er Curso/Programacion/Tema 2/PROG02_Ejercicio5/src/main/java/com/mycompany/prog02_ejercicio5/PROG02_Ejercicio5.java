package com.mycompany.prog02_ejercicio5;

/**
 *
 * @author David
 */
public class PROG02_Ejercicio5 {

    public static void main(String[] args) {
        
        //5.- Diseña un programa Java denominado PROG02_Ejerc5 que dado un número de
        //segundos, muestre en pantalla cuántos minutos, horas y días contiene.
        
        // Segundos
        int segs = 110000;
        
        // Minutos
        int mins = segs / 60;
        
        // Horas
        int horas = mins / 60;
        // minutos restantes
        mins = mins % 60;
        
        // dias
        int dias = horas / 24;
        // horas restantes
        horas = horas % 24;
        
        // resultado
        System.out.println("mins: " + mins);
        System.out.println("horas: " + horas);
        System.out.println("dias: " + dias);
    }
}
