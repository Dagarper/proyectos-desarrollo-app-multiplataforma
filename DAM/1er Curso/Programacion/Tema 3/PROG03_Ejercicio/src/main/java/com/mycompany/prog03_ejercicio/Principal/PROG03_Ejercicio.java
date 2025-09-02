package com.mycompany.prog03_ejercicio.Principal;

import com.mycompany.prog03_ejercicio.figuras.Rectangulo;

/**
 *
 * @author David
 */

/*
1. Crea un proyecto Java denominado Prog03_Ejerc1.
2. Dentro del proyecto, crea un paquete denominado com.prog03.figuras.
3. Dentro de dicho paquete, crea una clase denominada Rectangulo que:
• Declare atributos para la base y la altura de un rectángulo.
• Declare un constructor vacío que inicialice los atributos a 0.
• Declara un constructor que inicialice base y altura.
• Declare los siguientes métodos:
• Métodos para actualizar y obtener el valor de cada atributo.
• float getArea(): devuelve el área del rectángulo.
• String toString(): devuelve una cadena conteniendo su área y su altura.
• boolean isCuadrado(): devuelve un booleano indicando si el rectángulo es cuadrado.
4. Crea otro paquete con el nombre com.prog03.Principal.
5. Dentro de dicho paquete crea una clase denominada principal que contenga el método main.
6. En el método main, instancia al menos dos objetos de la clase Rectangulo y comprueba su funcionamiento.

*/
public class PROG03_Ejercicio {

    public static void main(String[] args) {
        
         //Instanciamos dos objetos del tipo Rectangulo
        Rectangulo r1 = new Rectangulo();
        Rectangulo r2 = new Rectangulo(5, 5);
        
        System.out.println("Base r1: " + r1.getBase());
        
        // Modificamos la base y la altura
        r1.setBase(20);
        r1.setAltura(10);

        // base de r1
        System.out.println("Base r1: " + r1.getBase());
        // info de r1
        System.out.println("r1 toString: " + r1.toString());
        
        // r2 ¿es cuadrado?
        System.out.println("r2 es cuadrado? " + r2.isCuadrado());
        // info de r2
        System.out.println("r2 toString" + r2.toString());
        
        
    }
}
