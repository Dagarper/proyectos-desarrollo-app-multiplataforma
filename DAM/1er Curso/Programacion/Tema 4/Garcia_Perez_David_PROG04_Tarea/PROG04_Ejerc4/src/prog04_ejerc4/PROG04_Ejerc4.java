/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog04_ejerc4;
import java.util.Scanner;//Clase que nos permite obtener la entrada de datos primitivos.

//Ejercicio 4: Deseamos implementar un juego en Java que permita al usuario adivinar un número oculto 
//(que será aleatorio).  El funcionamiento será el siguiente:
//El programa mostrará un pequeño menú en pantalla con las siguientes opciones (1. Configurar, 2. Jugar, 3. Salir).
//Si el usuario selecciona el la primera opción, se le solicitará por teclado el número de intentos permitidos (numInt) 
//y el número máximo  (numMax) generado.
//Si el usuario selecciona la opción 2,  el programa generará un número aleatorio entre 0 y numMax que será el número 
//a adivinar (numOculto). A partir de este momento, se le solicitarán al usuario números hasta adivinar el número oculto.
//Si el usuario adivina el número, se mostrará un mensaje "Has ganado!. Has necesitado X intentos".
//Si se consume el número de intentos sin adivinar el número, se mostrará el mensaje "Perdiste!. Intentos consumidos".
//En cada intento, si el usuario no adivina el número se le proporcionará una pista, por ejemplo, "El número oculto es menor".
//En ambos casos, la siguiente acción será mostrar el menú.
//Si el usuario selecciona Jugar sin configurar previamente el número de intentos y el número máximo generado, 
//se tomarán como valores por defecto: numInt=5 y numMax=10.
//Si el usuario pulsa la opción 3, el programa finaliza.
//Para generar un número aleatorio en java puedes utilizar el siguiente código:
//int numOculto = (int)Math.floor(Math.random()*20+1); //genera un número aleatorio entre 0 y 20, ambos incluidos.

public class PROG04_Ejerc4 {

    public static void main(String[] args) {//Método main.
        //Variable a la que asignamos el objeto "entrada" para introducir datos:
        Scanner entrada = new Scanner(System.in);
        //Instanciación de variables que van a actuar como constantes(valores por defecto).
        int NUM_INT = 5;
        int NUM_MAX =10;
        //Instanciación de variable "Salir" de tipo booleana con valor igual a false, 
        //que servirá para crear un bucle que nos permita salir cuando se cumpla la condicion de
        //salir=false (se explica más adelante).
        boolean salir = false;
        //Instanciación de variables numéricas:
        int opcion = 0;//Variable "opción" inicializada por defecto en 0, 
        //que servirá para indicar que caso(opción) quiere ejecutarse.
        int numInt = NUM_INT;//Variable que indica el número de intentos que va poder tener el jugador. 
        //Inicializada con el valor de la constante NUM_INT. 
        int numMax = NUM_MAX;//Variable que indica el valor máximo con el que se va a jugar.
        ////Inicializada con el valor de la constante NUM_INT.
        //Bucle while que continúa mientras salir sea = false. Utilizado para  la opción(caso) 3 salir.
        while(!salir){
            //Imprime por pantalla las instrucciones de juego:
            System.out.println("Escoge una opcion:");
            System.out.println("1. Configurar");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");
            //Permite introducir por pantalla el valor de la variable la opción.
            opcion = entrada.nextInt();
        
        //Introduce una estructura de selección múltiple que permite elegir entre 
        //las 3 opciones (variable "opcion") que aparecen en el menú principal. 
        switch(opcion){
        
            //caso 1(Configurar). Introduce un valor a la variable numInt,  
            //y un valor para la variable numMax.
            case 1:
                System.out.println("Introduce número de intentos: ");
                numInt=entrada.nextInt();
                System.out.println("Introduce numero maximo para adivinar: ");
                numMax=entrada.nextInt();
                //sentencia de ruptura para el caso 1, finaliza la sentencia del caso 1
                break;
            //caso 2(Jugar). 
            case 2:
                //Declara las variables que se van a utilizar para el juego.
                //Permite generar un número aleatoria de 0 al número máximo 
                //introducido(valor dado a la variable numMax).El número a descubrir.
                int numOculto = (int)Math.floor(Math.random()*numMax+1);
                //Variable número de jugadas que ha realizado el jugador, inicializa con valor 1.
                int intentos =1;
                //Variable que indica el número introducido por el jugador en la jugada.
                int numJugador = 0;
                //variable booleana utilizada para detener el bucle while junto a variable intentos. 
                boolean correcto =false;
               
                //bucle while ejecuta la instrucción en bucle mientras el número de intentos se menor o igual 
                //al numero de jugadas realizadas y el booleano correcto sea true.
                while(intentos<= numInt && !correcto) {
                    //Imprime el mensaje e introduce un valor para la variable numJugador:
                    System.out.println("Introduce el numero oculto:");
                    numJugador = entrada.nextInt();
                    //Condicional, cuando el valor introducido por el jugador se identico al número a descubrir.
                    if (numJugador == numOculto){
                        //Imprime mensaje:
                        System.out.println("¡¡Has acertado!! Has necesitado " + intentos + " intentos.");
                        //Sale del bucle while.
                        correcto = true;
                    }
                    //Condicional, cuando el número introducido por el jugador sea menor al número a descubrir.
                    if (numJugador < numOculto){
                        //Imprime mensaje:
                        System.out.println("El numero oculto es mayor.");
                        //Imprime el mensaje indicando los intentos que le quedan:
                        System.out.println("Te quedan "+ (numInt - intentos) + " intentos.");
                    }
                    //Condicional, cuando el número introducido por el jugador sea mayor al número a descubrir.
                    if (numJugador > numOculto){
                         //Imprime mensaje:
                        System.out.println("El numero oculto es menor.");
                        //Imprime el mensaje indicando los intentos que le quedan:
                        System.out.println("Te quedan "+ (numInt - intentos) + " intentos.");
                    }
                    //Condicional cuando los intentos realizados sean igual que los intentos permitidos:
                    if (intentos == numInt){
                        //Imprime mensaje:
                        System.out.println("Perdiste. Te has quedado sin intentos");
                    }
                   //La variable intentos va incrementando de 1 en 1 en este bucle.
                    intentos++;
                    
                  
                }
                //sentencia de ruptura para el caso 2, finaliza la sentencia del caso 2.   
                break;
            case 3:
                //Valor boolean salir es correcto por lo que sale del bucle y finaliza el programa.
                salir = true;
                //sentencia de ruptura para el caso 3, finaliza la sentencia del caso 3. 
                break;
                }

                
                 
                
        
        }
        }
    
}
    
    

