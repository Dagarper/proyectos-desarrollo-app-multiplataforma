
package tema8_ejerc1;

import java.time.LocalDate;


public class Validar {//Clase pública Validar que incluye los metodos de validación que se usarán en la clase principal. 
    
    public static boolean formatoDNI(String DNI){//Método booleano para validar el formato del DNI. Inicializa la variable String DNI.
    
    String formatoDNI = "^[0-9]{8}[a-zA-Z]$"; //Inicializa la variable String formatoDNI asignandole una cadena que incluye 8 dígitos del 1 al 9
    //y una letra de la A a la Z mayuscula o minuscula.  
    
    if (DNI.matches(formatoDNI)){//Condicional if con el metodo matches para validar la expresion regular. 
        //Si la variable DNI coincide con el formato de la variable formatoDNI devuelve true.
    return true;
    }else {//En caso contrario (no coincide el formato), devuelve false.
    return false;
    }
    }
    
    
 public static boolean formatoNombre(String nombre){//Método booleano para validar el formato del nombre. Inicializa la variable String nombre.
        
    if(nombre.length() > 40){//Condicional if que devuelve false si el número de caracteres de la variable nombre es mayor que 40.
            return false;
        }
        
        char caracter;//Inicializacion de la variable caracter de tipo caracter. 
        int numEspacios = 0;//Inicialización de la variable numEspacios que recogerá el numero de espacios que contendrá el String nombre. Inicializa en 0.
        for (int i = 0; i < nombre.length(); i++) {//Bucle for para contar el número de caracteres y el número de espacios del String nombre. 
            caracter = nombre.charAt(i);//Asigna a la variable caracter el caracter correspondiente a la posición i de la variable String.
            if(caracter == ' '){//Condicional if que incrementa en 1 cada vez que encuentra un espacio en la variable String nombre. 
                numEspacios++;
            }
            if(Character.isDigit(caracter)){//Condicional if que devuelve false en caso de que el String nombre contenga un dígito.
                return false;
            }
        }
        
        if(numEspacios >= 2){//Condicional if que devuelve true en caso de que el número de espacios que contenga la variable String sea igual o mayor que 2
            return true;
        }//En caso contrario devuelve false
        return false;
           

       
 }
  

    
    
    public static boolean formatoFecha (LocalDate fecha){//Método público, estático y de tipo booleano "fechaMayorHoy".
        //Valida que la fecha introducida sea anterior a la de hoy. Declara la variable fecha de tipo LocalDate(dia/mes/año)
    
    LocalDate fechaHoy = LocalDate.now();//Inicializa la variable fechaHoy con el valor de la fecha de hoy.
    
    if(fechaHoy.isBefore(fecha)){//Condicional if. Si la variable ahora (fecha actual) es después (función .isAfter: es anterior) a fecha.
        //devuelve false.
    return false;
    }else{//En caso contrario (la fecha sea anterior a hoy) devuelve true.
    return true;
    }
    
    
    }
    
    public static boolean formatoMatricula(String matricula){//Método booleano para validar el formato del nombre. Inicializa la variable String matricula. 
    
    String formatoMatricula = "^[0-9]{4}[A-Z]{3}$"; //Inicializa la variable String formatoMatricula asignandole una cadena que incluye 4 dígitos del 1 al 9
    //y 3 letras de la A a la Z. 
    if (matricula.matches(formatoMatricula)){//Condicional if con el metodo matches para validar la expresion regular. 
        //Si la variable matricula coincide con el formato de la variable formatoMatricula devuelve true.
    return true;
    }else{//En caso contrario (no coincide el formato), devuelve false.
    return false;
    }
    }
    
    
    
}
