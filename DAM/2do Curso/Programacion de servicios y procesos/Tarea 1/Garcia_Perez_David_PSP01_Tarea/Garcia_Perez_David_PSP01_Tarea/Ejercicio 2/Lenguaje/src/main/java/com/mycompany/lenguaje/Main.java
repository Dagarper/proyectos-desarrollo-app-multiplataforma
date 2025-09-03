package com.mycompany.lenguaje;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Aplicación que genera conjuntos de letras aleatorios y los escribe en un fichero.
 * Se invoca como: java -jar lenguaje.jar numeroConjuntos nombreArchivo
 * Ejemplo: java -jar lenguaje.jar 40 miFicheroDeLenguaje.txt
 * 
 * @author David
 */
public class Main {

    public static void main(String[] args) {
        // Verificar que se han pasado dos argumentos
        if (args.length < 2){
            System.out.println("Instrucción incorrecta. Ejemplo: java -jar lenguaje.jar 40 archivo.txt ");
            return;
        }
        
        
        try {
            int numeroPalabras = Integer.parseInt(args[0]); //Primer argumento es una instanca de tipo entero (cantidad de palabras generadas)
            String nombreDocumento = args[1];//Segundo argumento de tipo texto con el nombre del fichero. 
           
            generarConjuntoPalabras(numeroPalabras, nombreDocumento);// Instanciamos la clase
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al escribir el argumento.");
        }
    }

    /**
     * Genera el número de palabras dadas como parámetro y las escribe en un archivo con un nombre dado por parámetro.
     * 
     * @param cantidadPalabras Número de conjuntos de letras a generar.
     * @param nombreArchivo   Nombre del archivo donde escribir las palabras.
     * @throws IOException    Si ocurre un error de escritura.
     */
    
    public static void generarConjuntoPalabras(int cantidadPalabras, String nombreArchivo) throws IOException {
        //Utilizamos un String[] letras que contiene todas las letras del abecedario excepto la ñ.
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Random r = new Random();
        
        //Se utiliza un FileWriter dentro de un try-with-resources para asegurar el cierre automático del archivo al terminar.
        //Ponemos el valor true como parámetro en FileWriter para que permita rellenar el archivo de texto sin sobreescribirlo
        try (FileWriter writer = new FileWriter(nombreArchivo, true)) {
            for (int i = 0; i < cantidadPalabras; i++) {
                StringBuilder palabra = new StringBuilder();//Cada palabra se construye usando un StringBuilder ya que permite la concatenación de caracteres.
                int longitudPalabra = r.nextInt(26) + 1;// Longitud entre 1 y 26

                for (int j = 0; j < longitudPalabra; j++) {

                    int posicionLetra = r.nextInt(letras.length);
                    String caracter = letras[posicionLetra];
                    palabra = palabra.append(caracter);
                }
                //Cada palabra generada se escribe en una línea diferente usando writer.write() seguido de System.lineSeparator().
                writer.write(palabra.toString());
                writer.write(System.lineSeparator());

            }
        }

    }
}
