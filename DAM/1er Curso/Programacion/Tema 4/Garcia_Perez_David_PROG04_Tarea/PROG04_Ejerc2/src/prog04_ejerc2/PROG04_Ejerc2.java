/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog04_ejerc2;
import java.util.Scanner;//Clase que nos permite obtener la entrada de datos primitivos.

//Ejercicio 2: Un número es primo si solo tiene dos divisores: el 1 y el propio número. 
//Implementa un programa Java que pida por teclado 5 números. Para cada uno de ellos:
//Comprueba si es negativo. En caso afirmativo, muestra el mensaje por pantalla "El número es negativo".
//Si es positivo, deberá mostrar por pantalla si es primo o no.
//Procesados los 5 números, el programa finaliza.

public class PROG04_Ejerc2 {

    public static void main(String[] args) {//Método main.
        //Variable a la que asignamos el objeto "entrada" para introducir datos.
       Scanner entrada = new Scanner(System.in);
       //bucle for que inicializa la variable numérica "i" en 0, cuya condición es 
       //que sea menor que 5 y que se vaya incrementando en 1 unidad. Permite que el usuario
       //introduzca hasta 5 valores antes de acabar con el bucle. 
        for (int i = 0; i < 5; i++) {
            //Acción que realiza el bucle:
            //Imprime por pantalla
            System.out.println("Introduce un número:");
            //Introduce valor para la variable creada de tipo numérica llamada "número".
            //Esta variable recoge el numero que se va a probar si es primo o no. 
            int numero = entrada.nextInt();
            //Condicional if: Si el número introducido es igual a 2 
            //mostrara el mensaje de que este número es primo, ya que en el bucle que
            //comprueba si un número es primo no lo contiene al tener que inicializar con el
            //valor 2.
           
            if (numero==2){
                System.out.println("El numero es primo");}
            //Condicional que indica que el número es negativo cuando este es menor que 0.
            if (numero<0){
                System.out.println("El número es negativo");
            }
            //Else indica que cuando la condicion de if no se cumple (valor no es menor que 0)
            //se ejecutan las acciones que están entre los corchetes.
            else{
                //Imprime que el número es positivo.
                System.out.println("El numero es positivo");
                //Bucle para comprobar si el número es primo o no:
                //Instanciamos variable contador "j", que inicializa el bucle en 2, 
                //ya que es el numero más pequeño por el que se puede dividir el número introducido
                //además del 1. El bucle termina cuando el contador j es menor que
                //el número introducido y se va incrementando de 1 en 1.
                for (int j = 2; j < numero ; j++) {
                    //la acción que se repite en el bucle es un condicional if/else:
                    //Si el resto de número/j(contador) es igual a 0, el numero es primo,
                    //es decir tieme más posibles divisores distintos a sí mismos y el 1.
                    if(numero%j==0){
                        System.out.println("El numero no es primo");
                        break;//Utilizamos break para parar el bucle cuando esta condicion se cumple.
                    }else{//En caso de que la condicion de if no se cumpla el número es primo.
                        System.out.println("El numero es primo");
                        break;//Utilizamos break para parar el bucle cuando esta condicion se cumple.
                        
                    }
                }

            }
        }
        
               
       
    }
    
}
