
package prog04_ejerc1;
import java.util.Scanner;//Clase que nos permite obtener la entrada de datos primitivos.

//Ejercicio 1: Implementar un programa que muestre la tabla de multiplicar de un 
//número leido desde teclado utilizando al menos tres bucles diferentes. 
//El número leído desde teclado debe ser menor que 30. En caso contrario 
//se mostrará un mensaje por pantalla y el programa finalizará.

public class PROG04_Ejerc1 {
     public static void main(String[] args) {//Método main
      //Variable a la que asignamos el objeto "entrada" para introducir datos.  
      Scanner entrada= new Scanner(System.in);
      //Creamos las variables de tipo entero:
      int numero; 
      int contador;
      int resultado;
      //Creamos la variable de tipo booleano "comprobar" para poder salir del bucle.
      boolean comprobar = true;
      //Creamos bucle while para repetir la acción que contiene entre corchetes
      //en un bucle siempre y cuando el booleano comprobar sea distinto de true. 
      while (comprobar==true){
          //Imprimir por pantalla:
        System.out.println("Indique un numero menor que 30:");
        //Introducir valor de variable numero  en la siguiente linea 
        numero = entrada.nextInt();
        //Condicional if/else. Dentro de if, si la condición de que el número 
        //introducido sea menor o igual a 30 se cumple se ejecuta lo que está entre corchetes.
        if (numero <=30) { 
          //Imprimir por pantalla:
          System.out.println("Tabla de multiplicar del " + numero); 
          //Bucle for: donde se ejecuta el bucle, el contador empieza en uno, debe detenerse cuando
          //contador sea igual o menor que 10 y se va incrementando de 1 en 1, es decir del 1 al 10.
          for(contador = 1; contador<=10;contador++){
            //Acción que se repite: imprime por pantalla cada linea de la multiplicación para formar 
            //la tabla de multiplicar del 1 al 10 del número introducido anteriormente: 
            System.out.println(numero + " por " + contador + " es igual a: " + numero*contador);
            //Como hemos indicado que comprobar ha de ser idéntico a true, en caso de que se cumplan las condiciones
            //seguiría ejecutándose el bucle para pedir de nuevo un número menor que 30;
            comprobar=true;
          }
        }
        //En caso de que el número introducido sea mayor se ejecuta la acción entre corchetes.
        else{
            //Imprime por pantalla el siguiente mensaje.
            System.out.println("El numero escogido es incorrecto");
            //Variable booleana comprobar tiene el valor de false, así que en este caso saldría del bucle
            //y el programa finaliza
            comprobar=false;
    
      
      }
      }
    }
   
    }
        //¡¡Duda!!: No conseguí implementar más de dos bucles en el programa.
        
        
        
        



