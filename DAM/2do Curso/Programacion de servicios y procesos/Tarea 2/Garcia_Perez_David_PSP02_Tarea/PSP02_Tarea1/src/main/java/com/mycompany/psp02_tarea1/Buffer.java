package com.mycompany.psp02_tarea1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Buffer que implementa un buffer circular de caracteres con un tamaño fijo.
 * Proporciona métodos sincronizados para producir y consumir caracteres,
 * permitiendo la comunicación entre hilos productores y consumidores.
 */
public class Buffer {

    /**
     * Array de caracteres que actúa como el buffer.
     */
    private char[] buffer;

    /**
     * Índice actual para la posición de inserción/consumo en el buffer.
     */
    private int posicion;

    /**
     * Indica si el buffer está lleno.
     */
    private boolean estaLleno;

    /**
     * Indica si el buffer está vacío.
     */
    private boolean estaVacio;

    /**
     * Constructor que inicializa el buffer con un tamaño dado.
     * 
     * @param tamanio Tamaño del buffer.
     */
    public Buffer(int tamanio) {
        this.buffer = new char[tamanio];
        this.posicion = 0;
        this.estaLleno = false;
        this.estaVacio = true;
    }

    /**
     * Método sincronizado que permite a un hilo productor agregar un carácter al buffer.
     * Si el buffer está lleno, el hilo se bloquea hasta que haya espacio disponible.
     * 
     * @param c Carácter a añadir al buffer.
     */
    public synchronized void producir(char c) {

        // Esperar si el buffer está lleno
        while (this.estaLleno) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Añadir el carácter al buffer y actualizar la posición
        this.buffer[this.posicion] = c;
        this.posicion++;
        this.estaVacio = false;

        // Marcar el buffer como lleno si hemos alcanzado su capacidad
        if (this.buffer.length == this.posicion) {
            this.estaLleno = true;
        }

        // Notificar a todos los hilos que están esperando
        notifyAll();
    }

    /**
     * Método sincronizado que permite a un hilo consumidor retirar un carácter del buffer.
     * Si el buffer está vacío, el hilo se bloquea hasta que haya elementos disponibles.
     * 
     * @return El carácter retirado del buffer.
     */
    public synchronized char consumir() {

        // Esperar si el buffer está vacío
        while (this.estaVacio) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Reducir la posición y obtener el carácter correspondiente
        this.posicion--;
        this.estaLleno = false;

        // Marcar el buffer como vacío si no quedan elementos
        if (this.posicion == 0) {
            this.estaVacio = true;
        }

        // Notificar a todos los hilos que están esperando
        notifyAll();

        // Devolver el carácter consumido
        return this.buffer[posicion];
    }
}
