/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog04_ejerc3;
import java.util.Scanner;//Clase que nos permite obtener la entrada de datos primitivos.

//Ejercicio 3:  El Mínimo Común Múltiplo (MCM) de un conjunto de dos números es el número
//positivo más pequeño que es múltiplo de los dos números. Es posible calcular el MCM de tres o más números. 
//Por ejemplo, el MCM (2,3) es 6. El 6 es el múltiplo mas pequeño de 2 y de 3. 
//Implementa un programa Java que pida dos números por teclado, compruebe que son positivos y calcule su MCM. 
//En caso de no ser ambos números positivos, el programa mostrará un mensaje por pantalla y finalizará.

public class PROG04_Ejerc3 {

    public static void main(String[] args) {//Método main.
         ////Variable a la que asignamos el objeto "entrada" para introducir datos:
        Scanner entrada = new Scanner(System.in);
        //Imprimir mensaje e introducir valor numérico para la variable num 1.
        System.out.println("Introduzca el primer numero");
        int num1 = entrada.nextInt();
        //Imprimir mensaje e introducir valor numérico para la variable num 2.
        System.out.println("Introduzca el segundo numero");
        int num2 = entrada.nextInt();
        //Variable resultado que contiene la función mcm(mínimo común múltiplo) 
        //de los valores contenidos en las variables num1 y num2. Recoge el mcm de estos dos valores.
        int resultado = mcm(num1,num2);
        //Condicional que indica que los números son incorrectos cuando num1 o num 2 
        //sean negativos (<0), en ese caso se imprimirá el mensaje.
        if (num1<0 || num2<0){
            System.out.println("Los valores introducidos son incorrectos");
        }
        //En el caso de que los dos número sean positivos se muestra el MCM de ambos. 
        else{
        System.out.println("El MCM de " + num1 + " y " + num2 + " es " + resultado);
        }
    }
    
    //Función para obtener el mcm de num1 y num2:
    public static int mcm(int num1, int num2){//Funcion mcm compuesta por las variabes num1 y num2. 
        int a = Math.max(num1, num2);//Recoge en la variable a el valor máximo de num1 y num2.
        int b = Math.min(num1, num2);//Recoge en la variable b el valor mínimo de num1 y num2.
        int resultado = a/mcd(num1,num2)*b;//Fórmula para recoger en la variable resultado el mcm de num1 y num2.
        //Como vemos se obtiene de haber obtenido anteriormente el mcd(Máximo Común Divisor) de num1 y num2.
        //Consiste en dividir el valor mayor entre el mcd y multiplicarlo por el valor menor.
        return resultado;//Esta función devuelve el valor que se ha recogido en resultado. 
        
        
}   //Función para obtener el mcd(Máximo Común Divisor)de num1 y num2.
    public static int mcd(int num1,int num2){//Función mcd compuesta por las variables num1 y num2.
        int a = Math.max(num1, num2);//Recoge en la variable a el valor máximo de num1 y num2.
        int b = Math.min(num1, num2);//Recoge en la variable b el valor mínimo de num1 y num2.
        int res = 0;//Variable res que recoge el mcd de num1 y num2. Se inicializa en 0 para realizar el bucle.
        //Bucle do/while: 
        //do: realiza la acción al menos una vez, y continúa realizándose mientras se cumpla la condición 
        //del while que va a continuación. 
        do{
            res=b;//Se almacena el valor mínimo introducido en la variable res.
            b = a%b;//Se almacena en la variable b(número menor) el resto de dividir el número mayor entre el menor.
            a=res;//Se almacena en la variable a(numero mayor) el valor de res.
        }while(b != 0);//Condición: la variable b (ahora = al resto de la división) debe ser distinto de 0 
        //para que se repita el bucle.
    return res;//Devuelve el valor de res, en este caso el mcd de num1 y num2.
    }
    
    
}
