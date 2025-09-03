package com.mycompany.psp02_tarea1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Productor representa un hilo que produce caracteres aleatorios y los
 * deposita en un buffer compartido. Hereda de la clase Thread para ejecutarse
 * de manera concurrente.
 */
public class Productor extends Thread {

    /**
     * Buffer compartido donde el productor depositará los caracteres.
     */
    private Buffer buffer;

    /**
     * Conjunto de letras que el productor puede generar aleatoriamente.
     */
    private final String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Contador de caracteres producidos por este hilo.
     */
    private int producido;

    /**
     * Número máximo de caracteres que el productor generará.
     */
    private int maximo = 15;

    /**
     * Constructor que inicializa el productor con un buffer compartido.
     * 
     * @param buffer El buffer donde se depositarán los caracteres producidos.
     */
    public Productor(Buffer buffer) {
        this.buffer = buffer;
        this.producido = 0;
    }

    /**
     * Método que ejecuta el hilo. Genera caracteres aleatorios y los deposita en
     * el buffer hasta alcanzar el máximo permitido.
     */
    @Override
    public void run() {
        while (producido < maximo) {
            try {
                // Generar un carácter aleatorio de la cadena 'letras'
                char letra = letras.charAt((int) (Math.random() * letras.length()));

                // Depositar el carácter en el buffer
                buffer.producir(letra);
                producido++;

                // Imprimir el carácter depositado
                System.out.println("Depositado el caracter " + letra + " en el buffer.");

                // Pausa aleatoria antes de producir el próximo carácter
                sleep((long) (Math.random() * 4000));
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
} 