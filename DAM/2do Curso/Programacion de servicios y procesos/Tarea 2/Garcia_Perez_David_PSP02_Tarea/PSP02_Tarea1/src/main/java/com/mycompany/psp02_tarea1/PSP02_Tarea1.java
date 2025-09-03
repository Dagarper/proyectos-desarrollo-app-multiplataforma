package com.mycompany.psp02_tarea1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase principal inicia el programa productor-consumidor.
 * Crea un buffer compartido y lanza un hilo productor y un hilo consumidor.
 */

public class PSP02_Tarea1 {

    public static void main(String[] args) {

        try {

             // Crear un buffer con una capacidad de 6 elementos
            Buffer b = new Buffer(6);
            // Crear instancias de productor y consumidor que comparten el mismo buffer
            Productor p = new Productor(b);
            Consumidor c = new Consumidor(b);
            // Iniciar el hilo productor
            p.start();
            // Esperar 2 segundos antes de iniciar el hilo consumidor
            Thread.sleep(2000);
            // Iniciar el hilo productor
            c.start();
            // Esperar a que ambos hilos terminen su ejecución
            p.join();
            c.join();
            System.out.println("Fin del proceso");

        } catch (InterruptedException ex) {
            Logger.getLogger(PSP02_Tarea1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
