/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase Cliente para gestionar la conexión con un servidor a través de sockets.
 * Este cliente envía y recibe datos utilizando flujos de entrada y salida de datos.
 * 
 * Flujo básico:
 * 
 *     1.Establece conexión con el servidor en el puerto 2000.
 *     2.Intercambia mensajes y números enteros con el servidor.
 *     3.Termina la conexión una vez finalizada la comunicación.
 */
public class Cliente {

    /**
     * Método principal para ejecutar la lógica del cliente.
     * 
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {

        try {
            // Se conecta al servidor en el puerto 2000 en la máquina local
            Socket sc = new Socket("localhost", 2000);

            // Flujos para enviar y recibir datos
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            boolean salir = false;
            Scanner entrada = new Scanner(System.in);

            do {
                // Lee un mensaje del servidor y lo imprime en la consola
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                // Captura un número desde la entrada del usuario y lo envía al servidor
                int num = entrada.nextInt();
                out.writeInt(num);

                // Recibe otro mensaje del servidor y lo imprime
                mensaje = in.readUTF();
                System.out.println(mensaje);
                
                // Lee un valor booleano del servidor (aunque no se usa aquí)
                in.readBoolean();

            } while (!salir); // El bucle continuará indefinidamente hasta que se cambie la condición
            
            // Cierra el socket y los recursos asociados
            sc.close();

        } catch (IOException ex) {
            // Manejo de excepciones en caso de errores de E/S
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

