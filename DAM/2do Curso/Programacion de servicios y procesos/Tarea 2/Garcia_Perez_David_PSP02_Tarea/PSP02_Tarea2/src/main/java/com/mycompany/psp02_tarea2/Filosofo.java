package com.mycompany.psp02_tarea2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Filosofo representa a un filósofo en el problema de los filósofos cenando.
 * Cada filósofo alterna entre los estados de pensando y comiendo.
 * Para comer, un filósofo debe tomar dos palillos (el de su izquierda y el de su derecha).
 * Esta clase extiende la clase Thread para ejecutarse de forma concurrente.
 */
public class Filosofo extends Thread {

    /**
     * La mesa compartida con los palillos que los filósofos comparten.
     */
    private Mesa mesa;

    /**
     * El número que identifica al filósofo (comienza en 1).
     */
    private int comensal;

    /**
     * La posición del filósofo en la mesa (índice del array de palillos).
     */
    private int posicionMesa;

    /**
     * Constructor que inicializa un nuevo filósofo.
     * 
     * @param m        La instancia de Mesa que contiene los palillos.
     * @param comensal El número que identifica al filósofo (comienza en 1).
     */
    public Filosofo(Mesa m, int comensal) {
        this.mesa = m;
        this.comensal = comensal;
        this.posicionMesa = comensal - 1; // Convertir a índice basado en 0
    }

    /**
     * Método principal que ejecuta el ciclo de vida del filósofo.
     * El filósofo alterna entre pensar y comer indefinidamente.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // El filósofo piensa durante un tiempo aleatorio
                this.pensando();

                System.out.println("Filosofo " + this.comensal + " Hambriento");

                // El filósofo intenta coger los palillos para comer
                mesa.cogerPalillo(this.posicionMesa);

                // El filósofo está comiendo
                this.comiendo();

                System.out.println("Filosofo " + this.comensal + " Termina de comer, Libres palillos: " +
                        (this.mesa.palilloIzquierdo(this.posicionMesa) + 1) + ", " +
                        (this.mesa.palilloDerecho(this.posicionMesa) + 1));

                // El filósofo deja los palillos después de comer
                mesa.dejarPalillo(this.posicionMesa);

            } catch (InterruptedException ex) {
                Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Simula el estado de pensamiento del filósofo.
     * El filósofo estará pensando durante 2 segundos.
     */
    public void pensando() {
        try {
            Thread.sleep(2000); // Simular el tiempo de pensar durante 2000 milisegundos.
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Filosofo " + this.comensal + " pensando...");
    }

    /**
     * Simula el estado de comer del filósofo.
     * El filósofo estará comiendo durante 2 segundos.
     */
    public void comiendo() {
        try {
            Thread.sleep(2000); // Simular el tiempo de comida durnate 2000 milisegundos.
        } catch (InterruptedException ex) {
            Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Filosofo " + this.comensal + " comiendo...");
    }
}