package Ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase HiloServidor que extiende Thread para gestionar la solicitud de archivos de un cliente.
 * 
 * El hilo se encarga de recibir la ruta de un archivo desde el cliente, verificar si el archivo
 * existe y, en caso afirmativo, enviar su contenido. Si el archivo no existe, notifica al cliente.
 */
public class HiloServidor extends Thread {

    private Socket sc;

    /**
     * Constructor de la clase HiloServidor.
     * 
     * @param sc Socket asociado a la conexión con el cliente.
     */
    public HiloServidor(Socket sc) {
        this.sc = sc;
    }

    /**
     * Método ejecutado cuando el hilo comienza su ejecución.
     * 
     * Gestiona la interacción con el cliente:
     *     1.Recibe la ruta de un archivo.
     *     2.Verifica si el archivo existe.
     *     3.Si existe, lee y envía el contenido del archivo.
     *     4.Si no existe, informa al cliente.
     */
    
    @Override
    public void run() {
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            // Inicializa los flujos de entrada y salida
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            // Lee la ruta del archivo enviada por el cliente
            String ruta = in.readUTF();

            // Verifica si el archivo existe
            File fichero = new File(ruta);

            if (fichero.exists()) {
                // Notifica al cliente que el archivo existe
                out.writeBoolean(true);

                // Lee el contenido del archivo línea por línea
                BufferedReader br = new BufferedReader(new FileReader(ruta));
                String linea;
                String contenido = "";

                while ((linea = br.readLine()) != null) {
                    contenido += linea + "\r\n";
                }

                br.close();

                // Convierte el contenido del archivo a un arreglo de bytes
                byte[] contenidoFichero = contenido.getBytes();

                // Envía el tamaño del archivo al cliente
                out.writeInt(contenidoFichero.length);

                // Envía el contenido del archivo byte por byte
                for (int i = 0; i < contenidoFichero.length; i++) {
                    out.writeByte(contenidoFichero[i]);
                }

                // Cierra la conexión con el cliente
                sc.close();
            } else {
                // Notifica al cliente que el archivo no existe
                out.writeBoolean(false);
            }

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
}