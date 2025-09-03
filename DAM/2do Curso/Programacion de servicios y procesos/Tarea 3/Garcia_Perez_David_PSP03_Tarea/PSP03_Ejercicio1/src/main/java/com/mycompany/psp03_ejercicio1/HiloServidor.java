package com.mycompany.psp03_ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase HiloServidor que extiende Thread para gestionar la conexión con un cliente.
 * 
 * El servidor genera un número aleatorio y el cliente debe adivinarlo enviando números.
 * Proporciona retroalimentación sobre si el número enviado es mayor, menor o correcto.
 */
public class HiloServidor extends Thread {

    private Socket sc;

    /**
     * Constructor de la clase HiloServidor.
     * 
     * @param sc Socket asociado a la conexión del cliente.
     */
    public HiloServidor(Socket sc) {
        this.sc = sc;
    }

    /**
     * Método ejecutado cuando el hilo comienza su ejecución.
     * Gestiona la interacción con el cliente, incluyendo el intercambio de mensajes
     * y la lógica para adivinar el número.
     */
    @Override
    public void run() {

        System.out.println("Cliente conectado");
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            // Inicializa los flujos de entrada y salida
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            // Genera un número aleatorio entre 0 y 100
            int aleatorio = generarNumeroAleatorio(0, 100);
            int numeroCliente;

            System.out.println("El número generado es: " + aleatorio);

            do {
                // Envía una solicitud al cliente para que ingrese un número
                out.writeUTF("Escribe un número entre 1 y 100:");

                // Recibe el número enviado por el cliente
                numeroCliente = in.readInt();

                System.out.println("El número enviado por el cliente es: " + numeroCliente);

                // Proporciona retroalimentación sobre el número enviado
                if (numeroCliente == aleatorio) {
                    out.writeUTF("Has acertado el número");
                } else if (numeroCliente > aleatorio) {
                    out.writeUTF("El número es menor");
                } else {
                    out.writeUTF("El número es mayor");
                }

                // Informa al cliente si ha acertado
                out.writeBoolean(numeroCliente == aleatorio);

            } while (numeroCliente != aleatorio); // Finaliza cuando el cliente acierta el número
            
            // Cierra el socket y los recursos asociados
            sc.close();
            System.out.println("Cliente desconectado");

        } catch (IOException ex) {
            // Manejo de errores de entrada/salida
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cierra los flujos de entrada y salida
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Genera un número aleatorio dentro de un rango especificado.
     * 
     * @param min Valor mínimo del rango (inclusive).
     * @param max Valor máximo del rango (inclusive).
     * @return Un número entero aleatorio entre min y max.
     */
    private int generarNumeroAleatorio(int min, int max) {
        int numAleatorio = (int) (Math.random() * (max - min + 1) + min);
        return numAleatorio;
    }
}
