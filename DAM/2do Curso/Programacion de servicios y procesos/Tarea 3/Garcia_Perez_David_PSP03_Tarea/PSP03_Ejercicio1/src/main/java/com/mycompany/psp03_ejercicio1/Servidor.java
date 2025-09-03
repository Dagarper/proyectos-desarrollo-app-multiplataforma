package com.mycompany.psp03_ejercicio1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Servidor que gestiona las conexiones de múltiples clientes mediante hilos.
 * 
 * El servidor escucha en el puerto 2000 y crea una instancia de {@link HiloServidor}
 * para manejar cada cliente que se conecta. Permite la ejecución concurrente de múltiples
 * clientes.
 */
public class Servidor {

    /**
     * Método principal para iniciar el servidor.
     * 
     * Este método crea un ServerSocket para escuchar conexiones en el puerto 2000,
     * y maneja cada cliente que se conecta creando un nuevo hilo de tipo HiloServidor.
     * 
     */
    public static void main(String[] args) {

        try {
            // Crea un servidor que escucha en el puerto 2000
            ServerSocket servidor = new ServerSocket(2000);
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