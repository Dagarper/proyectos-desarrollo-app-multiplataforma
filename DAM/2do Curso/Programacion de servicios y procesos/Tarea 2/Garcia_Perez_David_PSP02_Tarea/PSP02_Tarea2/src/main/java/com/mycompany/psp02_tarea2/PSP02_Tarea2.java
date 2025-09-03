package com.mycompany.psp02_tarea2;

public class PSP02_Tarea2 {

    public static void main(String[] args) {

        // Crear una mesa con 5 palillos
        Mesa m = new Mesa(5); // En la mesa se colocan 5 palillos disponibles para los filósofos

        // Crear y comenzar 5 filósofos
        for (int i = 1; i <= 5; i++) {  // Iteramos 5 veces para crear 5 filósofos

            // Creamos un filósofo con el número correspondiente (comenzando desde 1)
            // 'i' es el índice del bucle.
            Filosofo filosofo = new Filosofo(m, i); 

            // Iniciar el hilo del filósofo (cada uno comenzará su ejecución)
            filosofo.start(); // Comienza el hilo para que el filósofo comience a pensar, comer, etc.
        }
    }
}