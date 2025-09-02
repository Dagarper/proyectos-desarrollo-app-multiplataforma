package com.mycompany.prog02_ejercicio6;

/**
 *
 * @author David
 */

/**
 * 6.- Diseña un programa Java denominado PROG02_Ejerc6 que cree un tipo
enumerado para las siguientes razas de perro: Mastín, Terrier, Bulldog, Pekines,
Caniche y Galgo. El programa debe realizar las siguientes operaciones:
 Crea una variable denominada var1 del tipo enumerador. Asígnale un valor.
 Crea una variable denominada var2 del tipo enumerador. Asígnale un valor.
 Muestra por pantalla el valor obtenido de comparar ambas variables.
Investiga sobre la posibilidad averiguar la posición que ocupa un determinado valor en
el enumerado así como mostrar la cantidad de valores que contiene. Si lo consigues,
muestra la posición de las dos variables en el tipo enumerado.
 */

public class PROG02_Ejercicio6 {

    public static void main(String[] args) {
        
        // Definimos las variables
        Razas var1 = Razas.Pekines;
        Razas var2 = Razas.Galgo;

        // comparamos
        System.out.println(var1 == var2);

        // numero de razas
        System.out.println("Numero de razas: " + Razas.values().length);

        // obtener la posicion de las razas
        int posVar1 = 0;
        int posVar2 = 0;
        for (int i = 0; i < Razas.values().length; i++) {
            if (var1 == Razas.values()[i]) {
                posVar1 = i;
            }
            if (var2 == Razas.values()[i]) {
                posVar2 = i;
            }
        }
        
        System.out.println("posicion var1: " + posVar1);
        System.out.println("posicion var2: " + posVar2);
        
    }
}
