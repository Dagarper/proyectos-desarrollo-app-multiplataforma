package com.mycompany.psp02_tarea1;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Consumidor representa un hilo que consume caracteres de un buffer
 * compartido. Hereda de la clase Thread para ejecutarse de manera concurrente.
 */
public class Consumidor extends Thread {

    /**
     * Buffer compartido desde donde el consumidor retirará los caracteres.
     */
    private Buffer buffer;

    /**
     * Contador de caracteres consumidos por este hilo.
     */
    private int consumido;

    /**
     * Número máximo de caracteres que el consumidor extraerá del buffer.
     */
    private int maximo = 15;

    /**
     * Constructor que inicializa el consumidor con un buffer compartido.
     * 
     * @param buffer El buffer desde donde se consumirán los caracteres.
     */
    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
        this.consumido = 0;
    }

    /**
     * Método que ejecuta el hilo. Extrae caracteres del buffer hasta alcanzar el
     * número máximo permitido.
     */
    @Override
    public void run() {
        while (consumido < maximo) {
            try {
                // Extraer un carácter del buffer
                char letra = buffer.consumir();

                // Imprimir el carácter consumido
                System.out.println("Consumido el caracter " + letra + " del buffer.");
                consumido++;

                // Pausa aleatoria antes de consumir el próximo carácter
                sleep((long) (Math.random() * 4000));
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}