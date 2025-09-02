
package prog05_tarea; //Paquete que contiene esta clase. 
import PROG05_Ejerc1_util.Validacion; //Importamos clase Validación del paquete PROG05_Ejerc1_util.
import java.time.LocalDate;//Importamos clase de java que permite establecer la fecha con día, mes y año. 
import java.util.Scanner;//Importamos clase para introducir datos desde el teclado. 

public class PROG05_Tarea {

    public static void main(String[] args) {//Método main de la clase principal.
        
    Scanner entrada = new Scanner(System.in); //Creamos objeto entrada de tipo Scanner (introducir datos desde el teclado).
    //Declaración de variables:
    boolean salir = false;  //Variable de tipo booleana inicializada en false. Sirve para crear bucle while que te devuelve al menú principal. 
    int opcion; //Variable de número entero opción. Tomará los valores de cada apartado del menú. 
    Vehiculo v = null; //Variable v del objeto vehículo. Tomará los valores de las variables siguientes:
    
    String marca; //Variable tipo String que contendrá la marca del vehículo. 
    String matricula; //Variable tipo String que contendrá la matrícula del vehículo. 
    int numerokm; //Variable de numero entero que contendrá los km iniciales del vehículo
    int nuevonumkm; //Variable de número entero que servirá para actualizar km. 
    LocalDate fechaMatriculacion; //Variable de tipo fecha (día/mes/año). Que contendrá la fecha de matriculación. 
    int dia; //Variable de tipo entero que contendrá el día.
    int mes; //Variable de tipo entero que contendrá el mes.
    int anio; //Variable de tipo entero que contendrá el año.
    int añosAntiguedad; //Variable de tipo entero que contendrá los años de antiguedad del vehículo.
    String descripcion; //Variable de tipo String que contendrá la descripción del vehículo. 
    double precio; //Variable de tipo decimal que contendrá el precio del vehículo. 
    String nombrePropietario; //Variable de tipo String que contendrá el nombre del propietario. 
    String dniPropietario; //Variable de tipo String que contendrá el DNI del propietario. 
    
    
    
    while(!salir)    {//Bucle while para salir del programa. El programa se cierra cuando la variable booleana salir sea true. 
        //Imprime las 9 opciones del menú:
        System.out.println("1. Nuevo vehiculo.");
        System.out.println("2. Ver Matricula.");
        System.out.println("3. Ver Numero de Kilometros.");
        System.out.println("4. Actualizar Kilometros.");
        System.out.println("5. Ver anios de antiguedad.");
        System.out.println("6. Mostrar propietario.");
        System.out.println("7. Mostrar descripcion.");
        System.out.println("8. Mostrar Precio.");
        System.out.println("9. Salir.");
        opcion = entrada.nextInt(); //Entrada de texto numérico para indicar opción.
        
        switch(opcion){//Condicional de selección múltiple que permite realizar las distintas operaciones en cada caso según la opción del menú escogida.  
        
            
             
            case 1: //Caso 1: tras marcar opción 1. Nuevo Vehículo. permite introducir los datos del vehículo a crear. 
                try{//Función try que sirve para probar el caso y arrojar excepciones en caso de que no se cumplan determinadas instrucciones.
                    System.out.println("\nIntroduce la marca."); //Imprime mensaje.
                    marca = entrada.next();//Entrada de texto. Asigna valor a variable marca.
                    System.out.println("Introduce la matricula.");//Imprime mensaje. 
                    matricula = entrada.next();//Entrada de texto. Asigna valor a variable matricula.
                    System.out.println("Introduce el numero de km.");//Imprime mensaje. 
                    numerokm = entrada.nextInt();//Entrada de número. Asigna valor a variable numerokm.
                    
                    if(Validacion.negativo(numerokm)){ //Condicional if. Contiene el método de validacion negativo. 
                        //sustituyendo la variable original del método (num) por numerokm, valida si el número de kilometros introducido es negativo.
                        //En caso de que el numero de km sea negativo...
                        throw new Exception("El numero de km tiene que ser positivo."); //Lanza esta excepción: Imprime mensaje.
                    }
                    System.out.println("Introduce la fecha de matriculacion en dia, mes y anio):");//Imprime mensaje. 
                    System.out.println("Dia:");//Imprime mesaje. 
                    dia = entrada.nextInt();//Entrada de número. Asigna valor a variable dia. 
                    System.out.println("Mes:");//Imprime mesaje.Asigna valor a variable mes.
                    mes = entrada.nextInt();//Entrada de número. Asigna valor a variable anio.
                    System.out.println("Anio:");//Imprime mesaje.
                    anio = entrada.nextInt();//Entrada de número. 
                    fechaMatriculacion = LocalDate.of(anio, mes, dia); //Damos valores a la Variable LocalDate fechaMatriculación
                    //a la que asignamos los valores introducidos por texto de las variables numéricas dia, mes y anio.    

                     if(Validacion.fechaMayorHoy(fechaMatriculacion)){//Condicinal if. Contiene el método de validacion fechaMayorHoy, 
                         //sustituyendo la variable original del método (ahora) por fechaMatriculacion, valida si la fecha introducida es mayor que la fecha actual.
                         //En caso de que la fecha sea mayor que el dia actual...
                        throw new Exception("La fecha de matriculación no puede ser mayor que hoy:");//Lanza esta excepción: Imprime mensaje. 
                    }
                    System.out.println("Introduce el precio:");//Imprime mesaje.
                    precio = entrada.nextDouble();//Entrada de número decimal.
                    System.out.println("Introduce la descripcion:");//Imprime mesaje.
                    descripcion = entrada.next(); //Entrada de texto.
                    System.out.println("Introduce el nombre del propietario:");//Imprime mesaje.
                    nombrePropietario = entrada.next();//Entrada de texto.
                    System.out.println("Introduce el DNI del propietario:");//Imprime mesaje.
                    dniPropietario = entrada.next();//Entrada de texto.

                    if(!Validacion.formatoDNI(dniPropietario)){//Condional para validar el formato del DNI. En el caso de que el formato sea false...
                    throw new Exception ("El DNI introducido no es valido.");//Lanza excepción: Imprime mensaje. 
                    }
                    //Variable v toma los valores de un nuevo vehículo que se corresponderán a los que el usuario introduzca por teclado. 
                    v = new Vehiculo (marca, matricula, nombrePropietario, descripcion, numerokm, precio, fechaMatriculacion, dniPropietario);
                        System.out.println("Vehiculo creado.");//Imprime mensaje. 
                    }catch(Exception e){//Captura excepciones en caso de que se cumpla la excepción lanzando el mensaje correspondiente. 
                        System.out.println(e.getMessage());
                    }
        
                break;//Sentencia para salir del caso. 
                
       
            case 2: //Caso 2. Ver matrícula. Permite ver el valor asignado al número de matricula. 
                if(v != null){//Condicional if. En caso de que v sea distinta de null...
                    System.out.println("La matricula es: " + v.getNumMatricula());//Imprime este mensaje y muestra el valor dado a la variable NumMatrícula del objeto Vehículo.
                }else{//En caso de que no se cumpla la condición. 
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");//Imprime mensaje.
                    }
                
                break;//Sentencia para salir del caso. 
                
            case 3: //Caso 3. Ver Número de Kilometros. 
                if(v != null){//Condicional if. En caso de que v sea distinta de null...
                    System.out.println("Tiene: " + v.getNumKm() + " km.");//Imprime este mensaje y muestra el valor dado a la variable NumKm del objeto Vehículo v.
                }else{//En caso de que no se cumpla la condición.
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");//Imprime mensaje.
                    }
                
                break;//Sentencia para salir del caso. 
                
            case 4: //Caso 4. Actualizar km. Permite darle un nuevo valor a la variable numkm.
                if(v!=null){//Condicional if. En caso de que v sea distinta de null...
                
                    System.out.println("Introduce el numero de km.");//Imprime mensaje.
                    numerokm = entrada.nextInt(); //Entrada de número entero asigna valor a variable numerokm.
                    if(!Validacion.negativo(numerokm)){//Condicional if. En caso de que el número sea distinto que negativo...
                    if (numerokm <= v.getNumKm()){//Condicional if dentro de condicional if. En caso de que además de ser un número positivo, 
                        //el numero introducido sea mayor o igual que el número de kilometros de inicio. 
                        System.out.println("El numero de km actual debe ser mayor que el numero de km anterior.");//Imprime mensaje.
                    }
                    else{//En caso de que el número introducido no sea negativo ni menor o igual que el valor anterior.
                    v.setNumKm(numerokm);//Da el nuevo valor a la variable NumKm del objeto vehículo. 
                        System.out.println("Km actualizados.");//Imprime mensaje. 
                    }
                    }else{//En caso de que no se cumpla la primera condición...
                    System.out.println("El numero de km tiene que ser positivo.");//Imprime mensaje. 
                
                    }
                }else{//En caso de que el valor de v sea null...
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");//Imprime mesaje. 
                }
                break;//Sentencia para salir del caso.
                
            case 5: 
                if(v != null){ //Condicional if. En caso de que v sea distinta de null...              
                System.out.println("El coche tiene " + v.get_Anios()+ " anios de antiguedad.");//Imprime mensaje y muestra el valor
                //dado a la variable Anios del objeto vehículo v. 
                }else{//
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");
                    }
                break;//Sentencia para salir del caso.
                
            case 6: 
                    if(v != null){//Condicional if. En caso de que v sea distinta de null...
                    System.out.println("El propietario es: " + v.getNomProp() + ". Con DNI: " + v.getDniProp() + ".");//Imprime mensaje y 
                    //muestra el valor dado a las variables NomProp y DniProp del objeto vehículo v. 
                }else{//En caso de que el valor de v sea null...
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");//Imprime mensaje.
                    }
                break;//Sentencia para salir del caso.
                
            case 7: 
                if(v != null){//Condicional if. En caso de que v sea distinta de null...
                    System.out.println(v.getDescripcion() + " " + v.getNumMatricula() + " " + v.getNumKm() + "km.");//Imprime mensaje y 
                    //muestra el valor dado a las variables Descripción, NumMatricula y NumKm del objeto vehículo v.
                }else{//En caso de que el valor de v sea null...
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");
                    }
                break;//Sentencia para salir del caso.
                
                
            case 8: 
                if(v != null){//Condicional if. En caso de que v sea distinta de null...
                    System.out.println("Su precio es: " + v.getPrecio() + " euros.");//Imprime mensaje y 
                    //muestra el valor dde la variable precio del objeto vehículo v.
                }else{//En caso de que el valor de v sea null...
                    System.out.println("No existe vehiculo creado. Debes marcar opcion 1 para crear un vehiculo.");//Imprime mensaje. 
                    }
                break;//Sentencia para salir del caso.
                
            case 9: 
                salir=true;//Sentencia que permite salir del bucle while y salir del programa.
                break;//Sentencia para salir del caso. En este caso no sería necesario. 
           
                
            default: System.out.println("Escoge una opcion correcta.");//En caso de introducir un número que
            //no corresponda a ningún caso. 
        
        
        
        
        }
                
    
    
    }
    
  
    }
    
}
