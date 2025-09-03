package com.mycompany.psp03_ejercicio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Servidor que gestiona solicitudes de múltiples clientes para obtener el contenido de archivos.
 * 
 * El servidor escucha conexiones en el puerto 1500 y crea un hilo de tipo HiloServidor
 * para atender cada cliente de manera concurrente. Permite manejar múltiples conexiones simultáneamente.
 */
public class Servidor {

    /**
     * Método principal para iniciar el servidor.
     * 
     * Este método configura un ServerSocket para escuchar en el puerto 1500
     * y entra en un bucle infinito aceptando conexiones de clientes. Cada conexión
     * es manejada en un hilo independiente usando la clase HiloServidor.
     */
    
    public static void main(String[] args) {

        try {
            // Crea un servidor que escucha en el puerto 1500
            ServerSocket servidor = new ServerSocket(1500);
            System.out.println("Servidor iniciado");

            // Bucle infinito para aceptar múltiples conexiones de clientes
            while (true) {
                // Acepta una conexión entrante
                Socket sc = servidor.accept();

                // Crea y lanza un nuevo hilo para manejar al cliente conectado
                HiloServidor s = new HiloServidor(sc);
                s.start();
            }

        } catch (IOException ex) {
            // Manejo de errores relacionados con entrada/salida
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
