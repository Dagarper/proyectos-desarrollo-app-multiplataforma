
package prog04_ejerc5;
import java.util.Scanner;//Clase que nos permite obtener la entrada de datos primitivos.
//Ejercicio 5: Cuando dividimos un número entre 0 se genera un valor indeterminado. 
//En cualquier lenguaje de programación este tipo de operaciones genera un error de ejecución
//que debe ser controlado desde el código para evitar malas experiencias al usuario. 
//En Java, cuando se produce esta operación se genera la excepción ArithmeticException. 
//Queremos implementar un programa Java que calcule la división de dos números solicitados por 
//teclado (dividendo y divisor). El programa solicitará números indefinidamente hasta que los 
//dos números solicitados sean -1. Se debe controlar mediante excepciones que el divisor no sea 0. 
//En caso de serlo, se mostrará un mensaje por pantalla. También habrá que mostrar por pantalla el 
//número de divisiones calculadas. Utiliza número enteros para las variables.
public class PROG04_Ejerc5 {

    public static void main(String[] args) {//Metodo main
        //Variable a la que asignamos el objeto "entrada" para introducir datos:
          Scanner entrada = new Scanner(System.in);//
//Creación de las variables utilizadas en el bucle.
int dividendo = 0;//Recoge el valor del dividendo. Inicializa en 0.
int divisor = 0;//Recoge el valor del divisor. Inicializa en 0.
int resultado = 0;//Recoge el valor del resultado. Inicializa en 0.
int cantidad_operaciones = 0;//Recoge el valor de la cantidad de operaciones realizadas. Inicializa en 0.

//Bucle do/while. Inicializa una sentencia (lo que incluye do) al menos una vez, y se repite en bucle 
//mientras se cumple la condición while.
do{
//Muestra el mensaje y permite introducir por pantalla el valor del dividendo.
System.out.println("Introduce el dividendo");
dividendo= entrada.nextInt();
//Muestra el mensaje y permite introducir por pantalla el valor del divisor.
System.out.println("Introduce el divisor");
divisor= entrada.nextInt();
//Para capturar la excepción en el caso de que el dividendo o el divisor sean igual que -1. Try prueba la sentencia
//que se encuentra en su interior(resultado) en determinadas condiciones.
try{
//Da valor a la variable resultado como el producto de dividendo*divisor.    
resultado=dividendo/divisor;
//Condicional if/else:
//Cuando el dividendo o el divisor sean distintos de -1.
if (dividendo != -1 || divisor != -1){
System.out.println("El resultado de la división es: " + resultado);
cantidad_operaciones++;//La variable cantidad de operaciones se va incrementando de 1 en 1.
System.out.println("El numero de operaciones realizadas es: " + cantidad_operaciones);
//Cuando al menos uno de los valores dados a las variables de dividendo y divisor sea menor que 1.
}else{
//Imprime el mensaje.
System.out.println("Fin del programa"); 
//Imprime el mensaje indicando la cantidad de operaciones que se han realizado hasta el momento.
System.out.println("El numero de operaciones realizadas es: " + cantidad_operaciones);
}
//Captura la excepción cuando el divisor sea igual que 0.
}catch(ArithmeticException ex){
//Imprime el mesanje:
System.out.println("El resultado es indeterminado, no se puede dividir por 0");
}
//Condición de ejecución de la sentencia de do: do se sigue ejecutando mientras los valores 
//del dividendo o el divisor no sean igual a -1.
}while(dividendo != -1 || divisor != -1);
        
    }
}

    
    

