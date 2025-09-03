package com.mycompany.psp03_ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Cliente para solicitar al servidor el contenido de un archivo.
 * 
 * El cliente se conecta al servidor en el puerto 1500, envía la ruta de un archivo,
 * y espera recibir su contenido si el archivo existe. Si no existe, informa al usuario.
 */
public class Cliente {

    /**
     * Método principal que implementa la lógica del cliente.
     * 
     * Se establece la conexión con el servidor, se envía la ruta del archivo solicitada
     * por el usuario, y se procesa la respuesta del servidor para mostrar el contenido del
     * archivo o un mensaje de error.
     */
    public static void main(String[] args) {

        try {
            // Se conecta al servidor en el puerto 1500
            Socket sc = new Socket("localhost", 1500);

            // Inicializa los flujos de entrada y salida
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            Scanner entrada = new Scanner(System.in);

            // Solicita al usuario la ruta del archivo
            System.out.println("Introduce la ruta donde se encuentra el archivo que quieres mostrar:");
            String ruta = entrada.next();

            // Envía la ruta del archivo al servidor
            out.writeUTF(ruta);

            // Verifica si el archivo existe en el servidor
            boolean existe = in.readBoolean();

            if (existe) {
                // Si existe, lee el tamaño del contenido del archivo
                int longitud = in.readInt();

                // Crea un arreglo de bytes para almacenar el contenido del archivo
                byte[] contenido = new byte[longitud];

                // Recibe el contenido del archivo byte por byte
                for (int i = 0; i < longitud; i++) {
                    contenido[i] = in.readByte();
                }

                // Convierte el contenido recibido a String y lo muestra
                String contenidoFichero = new String(contenido);
                System.out.println(contenidoFichero);

            } else {
                // Si el archivo no existe, informa al usuario
                out.writeBoolean(false);
                System.out.println("No existe el fichero especificado");
            }

            // Cierra el socket y los recursos asociados
            sc.close();

        } catch (IOException ex) {
            // Manejo de errores de entrada/salida
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}