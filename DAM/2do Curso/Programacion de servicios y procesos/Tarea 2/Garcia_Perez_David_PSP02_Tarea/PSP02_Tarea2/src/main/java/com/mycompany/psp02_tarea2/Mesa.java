package com.mycompany.psp02_tarea2;

import java.util.concurrent.Semaphore;

/**
 * La clase Mesa representa una mesa con un conjunto de palillos utilizados en el
 * problema de los filósofos cenando. Cada filósofo necesita dos palillos (uno a su
 * izquierda y otro a su derecha) para comer. Los palillos son gestionados mediante
 * semáforos para asegurar la sincronización entre los filósofos.
 */
public class Mesa {

    /**
     * Array de semáforos que representa los palillos en la mesa.
     * Cada semáforo asegura que un palillo solo sea utilizado por un filósofo a la vez.
     */
    private Semaphore[] palillos;

    /**
     * Constructor que inicializa la mesa con un número específico de palillos.
     * Cada palillo es representado por un semáforo con un permiso.
     * 
     * @param numPalillos El número de palillos disponibles en la mesa (debería ser igual al número de filósofos).
     */
    public Mesa(int numPalillos) {
        this.palillos = new Semaphore[numPalillos];
        
        // Inicializar cada palillo (semáforo) con un permiso.
        for (int i = 0; i < numPalillos; i++) {
            this.palillos[i] = new Semaphore(1);
        }
    }

    /**
     * Devuelve el índice del palillo izquierdo en función del índice del filósofo.
     * 
     * @param palillo El índice del filósofo.
     * @return El índice del palillo a la izquierda del filósofo.
     */
    public int palilloIzquierdo(int palillo) {
        return palillo;
    }

    /**
     * Devuelve el índice del palillo derecho en función del índice del filósofo.
     * Si el filósofo es el primero (índice 0), el palillo derecho será el último.
     * 
     * @param palillo El índice del filósofo.
     * @return El índice del palillo a la derecha del filósofo.
     */
    public int palilloDerecho(int palillo) {
        if (palillo == 0) {
            return this.palillos.length - 1;
        }
        return palillo - 1;
    }

    /**
     * Permite a un filósofo coger los dos palillos necesarios para comer.
     * Utiliza los métodos acquire() de los semáforos para bloquear los palillos.
     * 
     * @param filosofo El índice del filósofo que quiere coger los palillos.
     * @throws InterruptedException Si el hilo es interrumpido mientras espera por un palillo.
     */
    public void cogerPalillo(int filosofo) throws InterruptedException {
        // El filósofo coge el palillo izquierdo y luego el derecho
        this.palillos[this.palilloIzquierdo(filosofo)].acquire();
        this.palillos[this.palilloDerecho(filosofo)].acquire();
    }

    /**
     * Permite a un filósofo dejar los dos palillos después de comer.
     * Utiliza los métodos release() de los semáforos para liberar los palillos.
     * 
     * @param filosofo El índice del filósofo que quiere dejar los palillos.
     */
    public void dejarPalillo(int filosofo) {
        // El filósofo suelta el palillo izquierdo y luego el derecho
        this.palillos[this.palilloIzquierdo(filosofo)].release();
        this.palillos[this.palilloDerecho(filosofo)].release();
    }
}