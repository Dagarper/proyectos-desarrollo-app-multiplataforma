/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.colaborar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que lanza 10 instancias de la aplicación "lenguaje" para generar un archivo de palabras.
 * Las instancias generarán un número creciente de palabras: 10, 20, 30, ..., 100.
 * 
 * Se invoca como: java -jar colaborar.jar
 * 
 * @author David
 */
public class Main {

    public static void main(String[] args){
        // Lanzar 10 instancias de la aplicación "lenguaje" con un número creciente de palabras
        for (int i = 1; i <= 10; i++) {
            int numeroInstancias;
            numeroInstancias = i*10;// 10, 20, 30, ..., 100
            try {
                // Crear el comando para ejecutar la aplicación "lenguaje"
                ProcessBuilder builder = new ProcessBuilder("java", "-jar", "Lenguaje.jar", String.valueOf(numeroInstancias), "FicheroConjunto.txt");
                // Iniciar el proceso
                Process proceso = builder.start();
                // Esperar a que el proceso termine antes de lanzar el siguiente
                proceso.waitFor();
                
            } catch (IOException | NumberFormatException e) {
            System.out.println("Error al iniciar el proceso.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        System.out.println("Archivo FicheroConjunto.txt generado.");
        
    }
}
