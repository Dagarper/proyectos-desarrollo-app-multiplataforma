/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PROG05_Ejerc1_util;//Pertenece al paquete PROG05_Ejerc1_util del proyecto PROG05_Tarea. 

import java.time.LocalDate;//Importamos clase de java que permite establecer la fecha con día, mes y año.


public class Validacion {//Clase pública (puede utilizarse por otras clases) de Validación 
    //que contiene los métodos estáticos para realizar validaciones.  
   
    public static boolean negativo (int num){//Método público, estático y de tipo booleano "negativo". 
        //Valida que el número introducido sea mayor que 0. Declara la variable num de tipo numérico. 
        if(num<0){//Condicional if. Si la variable num tiene un valor menor que 0(negativo)..
            return true;//Devuelve true (boolean negativo=true).

        }else{//Si el número es mayor que 0. 
        return false;//Devuelve false (boolean negativo=false).
    }
    }
    
    public static boolean fechaMayorHoy (LocalDate fecha){//Método público, estático y de tipo booleano "fechaMayorHoy".
        //Valida que la fecha introducida sea anterior a la de hoy. Declara la variable fecha de tipo LocalDate(dia/mes/año)
        LocalDate ahora = LocalDate.now();//Declaración de variable ahora de tipo LocalDate, que contiene la fecha actual.
        if (ahora.isAfter(fecha)){//Condicional if. Si la variable ahora (fecha actual) es después (función .isAfter: es anterior) a fecha. 
            return false;//Devuelve false.
        }else{//En caso contrario...
            return true;//Devuelve true. Es en este caso donde se cumple la validación. 
            //El valor de fecha(que luego será sustituida por el atributo fecha de matriculación) es anterior que la fecha actual)
        }
    }
    
    public static boolean formatoDNI (String DNI){//Método público, estático y de tipo booleano "formatoDNI".
    //Valida que el formato de DNI introducido sea correcto (Tenga 9 carácteres: 8 de tipo numérico y el último de tipo alfabético 
    //y que se corresponda con la letra que le correspoda según al valor de su parte numérica). Declara la variable DNI de tipo String. 
        if (DNI.length() != 9){//Si la longitud del DNI es distinta de 9...
        return false;//Devuelve false. 
        }

        String numeroDNI = DNI.substring(0,DNI.length() - 1);//Variable String que contiene los 8 primeros carácteres del contenido 
        //de la variable DNI.

        char letraDNI = DNI.charAt(DNI.length() -1);//Variable de tipo char (caracter) que contiene el último carácter del contenido 
        //de la variable DNI.

        int numDNI;//Variable numDNI de tipo numérica.

        try{//Prueba que al asignar a la variable numérica numDNI el valor de los 8 primeros carácteres (numéricos) de la variable DNI 
            //(de tipo String contenidos en la variable numeroDNI(tipo String), 
            //utilizando la función Integer.parseInt que permite convertir cadena de texto en numeros enteros. 
            numDNI = Integer.parseInt(numeroDNI);

            }catch(NumberFormatException e){//Captura la excepción en caso de que el formato introducido no sea correcto.
                    return false;//Devuelve false.
                    }

        if (!Character.isAlphabetic(letraDNI)){//Condicional if. Si el valor de la variable letraDNI no es 
            //un caracter alfabético (función .isAlphabetic)...
            return false;//devuelve false
        }
        //Variable letrasNIF de tipo char, contiene las 23 letras del abecedario, de forma que a cada letra puede asignarsele una posición 
        //que corresponda con un número del 1 al 23.
        char letrasDNI[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int resto = numDNI%23;//Declaración de variable DNIletra que contiene el valor de la variable numDNI(8 primeros dígitos) 
        //dividido entre 23 (letras).

        char DNIletra = letrasDNI[resto];//Declaracion de la variable DNIletra de tipo char (caracter), que contiene la letra de 
        //la variable letrasDNi que corresponte a la posición que equivale el valor de la variable resto. Ej: resto = 3 --> DNIletra='W'


        String DNINuevo = numeroDNI + DNIletra;//Declaración de variable tipo String compuesta por variable numeroDNI(tipo String 8 carácteres numericos)
        //más la variable DNIletra (tipo char que contiene la letra que corresponde al número del dni)


        if(DNI.equals(DNINuevo)){//Condicional if. Si las variables DNI y DNInuevo son del mismo tipo y tienen los mismos datos...
            return true;//Devuelve true.
            }else{//En caso contrario...
                return false;//Devuelve false.
            }
}
}