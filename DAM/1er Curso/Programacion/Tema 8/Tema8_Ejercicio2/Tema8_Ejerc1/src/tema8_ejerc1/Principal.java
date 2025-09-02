
package tema8_ejerc1;

import java.time.LocalDate;
import java.util.Scanner;


public class Principal {

   
    public static void main(String[] args) { //Método main del método principal.
        
        Scanner entrada = new Scanner (System.in); ////Creamos objeto entrada de tipo Scanner (introducir datos desde el teclado).

        
        //Declaración de variables:
        boolean salir = false; //Variable de tipo booleana inicializada en false. Sirve para crear bucle while que te devuelve al menú principal.
        
        int opcion;//Variable de número entero opción. Tomará los valores de cada apartado del menú.
        
        String marca, matricula, descripcion, nombrePropietario, dniPropietario;//Variable tipo String que contendrá la marca del vehiculo, 
        //matricula, descripcion, nombre y apellidos del propietario y el DNI de propietario.
        int numeroKm, dia, mes, anio; //Variable tipo entero que contendrá el valor del numero de Kms, el día, el mes y el año.
        LocalDate fechaMatriculacion; //Variable de tipo fecha (día/mes/año). Que contendrá la fecha de matriculación. 
        double precio; //Variable de tipo decimal que contendrá el precio del vehículo. 
        
        
        Vehiculo v = null; //Nuevo objeto vehículo con nombre "v". Inicializada en null. Tomará los valores de las variables anteriores.
        Concesionario concesionario = new Concesionario(); //Nuevo objeto concesionario con nombre "concesionario".
        while(!salir){////Bucle while para salir del programa. El programa se cierra cuando la variable booleana salir sea true. 
            //Menu del programa:
        System.out.println("Marque una opcion:");
        System.out.println("1. Nuevo vehiculo.");
        System.out.println("2. Listar vehiculos");
        System.out.println("3. Buscar vehiculos");
        System.out.println("4. Modificar kms vehiculo");
        System.out.println("5. Eliminar vehiculo");
        System.out.println("6. Salir");
        opcion = entrada.nextInt();//Entrada de número de opción.
          
        switch(opcion){//Condicional de selección múltiple que permite realizar las distintas operaciones en cada caso según la opción del menú escogida.
        
            case 1: //Caso 1: tras marcar opción 1. Nuevo Vehículo. permite introducir los datos del vehículo a crear. 
                 

                System.out.println("\nIntroduce la marca."); //Imprime mensaje.
                marca = entrada.next();//Entrada de texto. Asigna valor a variable marca.
                
                
                do {//Bucle do while que valida el formato de la matricula.
                    System.out.println("Introduce la matricula.");//Imprime mensaje. 
                    matricula = entrada.next();//Entrada de texto. Asigna valor a variable matricula.
                    if (!Validar.formatoMatricula(matricula)) {//Condicinal if. Valida que el formato de matrícula sea correcto.
                        System.out.println("El formato de matricula es incorrecto debe ser del tipo '1111AAA'."); //Si formatoMatricula devuelve false imprime el mensaje.
                    }
                    if (concesionario.existeMatricula(matricula) == true){//Si existe un vehículo con la matricula introducida (existeMatricula == true)
                        //Devuelve mensaje:
                        System.out.println("Ya existe un vehiculo con esta matricula");
                    }
                    
                } while (!Validar.formatoMatricula(matricula) | concesionario.existeMatricula(matricula) == true);//El bucle se repite mientras el formato de la matricula sea incorrecto 
                //o ya exista la matrícula. En caso que se de cualquiera de estos casos vuelve a pedir el número de matricula. 
                
               
                
                
                
                
                do {//Bucle do while que valida el número de km.
                    System.out.println("Introduce el numero de km.");//Imprime mensaje. 
                    numeroKm = entrada.nextInt();//Entrada de número. Asigna valor a variable numerokm.

                if (numeroKm <= 0) { //Condicional if. Valida que nos km sean mayores que 0.
                    //En caso de que el numero de km sea negativo imprime el siguiente mensaje:
                    System.out.println("El numero de km tiene que ser positivo y mayor que 0."); 
                }
                     } while (numeroKm <= 0);//El bucle se repite mientras los km introducidos sean menor o igual que 0.
                
                
                do {//Bucle do while que valida el formato de la fecha de matriculacion.
                    System.out.println("Introduce la fecha de matriculacion en dia, mes y anio:");//Imprime mensaje. 
                    System.out.println("Dia:");//Imprime mesaje. 
                    dia = entrada.nextInt();//Entrada de número. Asigna valor a variable dia. 
                    System.out.println("Mes:");//Imprime mesaje.Asigna valor a variable mes.
                    mes = entrada.nextInt();//Entrada de número. Asigna valor a variable anio.
                    System.out.println("Anio:");//Imprime mesaje.
                    anio = entrada.nextInt();//Entrada de número. 
                    fechaMatriculacion = LocalDate.of(anio, mes, dia); //Damos valores a la Variable LocalDate fechaMatriculación
                    //a la que asignamos los valores introducidos por texto de las variables numéricas dia, mes y anio.    

                    if (!Validar.formatoFecha(fechaMatriculacion)) {//Condicinal if. Contiene el método de validacion fechaMayorHoy, 
                        //sustituyendo la variable original del método (ahora) por fechaMatriculacion, valida si la fecha introducida es mayor que la fecha actual.
                        //En caso de que la fecha sea mayor que el dia actual imprime el siguiente mensaje:
                        System.out.println("La fecha de matriculacion no puede ser mayor que hoy:"); 
                    }
                } while (!Validar.formatoFecha(fechaMatriculacion));//El bucle se repite mientras el método formatoFecha devuelva false.
                
                
                do {//Bucle do while que valida el precio del vehículo.
                    System.out.println("Introduce el precio:");//Imprime mesaje.
                    precio = entrada.nextDouble();//Entrada de número decimal que se asigna a la variable precio.
                    if(precio <= 0){ //Condicional if. Si el precio es menor o igual que 0 imprime el siguiente mensaje:
                        System.out.println("El precio debe ser mayor que 0.");
                    }
                } while (precio <= 0);//El bucle se repite mientras el precio sea menor o igual que 0.
                
                
               do{//Bucle do while que valida el nombre del propietario.
                   System.out.println("Introduce el nombre del propietario: ");//Imprime mesaje.
                    nombrePropietario = entrada.nextLine();//Entrada de texto. Asigna el valor a la variable nombrePropietario. 

               }while(!Validar.formatoNombre(nombrePropietario));//El bucle se repite cuando el método formatoNombre de la clase Validar sea false.
                    
                
                do {//Bucle do while que valida el formato del DNI del propietario.
                    System.out.println("Introduce el DNI del propietario:");//Imprime mesaje.
                    dniPropietario = entrada.next();//Entrada de texto. Asigna el valor a la variable dniPropietario. 

                    if (!Validar.formatoDNI(dniPropietario)) {//Condional para validar el formato del DNI. En el caso de que el formato sea false...
                        System.out.println("El DNI introducido no es valido.");//Lanza excepción: Imprime mensaje. 
                    }
                } while (!Validar.formatoDNI(dniPropietario));//El bucle se repite mientras el método formatoDNI de la clase Validar sea false. 
                

                
                descripcion = "El propietario es: " + nombrePropietario + ". Con DNI: " + dniPropietario + "."; //Entrada de texto. Se asigna valores a la variable descripcion.
                //Variable v toma los valores de un nuevo vehículo que se corresponderán a los que el usuario introduzca por teclado: 
                v = new Vehiculo(marca, matricula, nombrePropietario, descripcion, numeroKm, precio, fechaMatriculacion, dniPropietario);
                
                
                
                switch(concesionario.insertarVehiculo(v)){//Condicional de selección múltiple que permite realizar las distintas operaciones en cada caso según el valor arrojado por el método insertarVehiculo.
                
                    case -1: //Cuando arroja el valor -1 imprime el siguiente mensaje:
                        System.out.println("El concesionario esta lleno.");
                        break;//Sentencia para salir del caso.
                    case -2: //Cuando arroja el valor -2 imprime el siguiente mensaje:
                        System.out.println("La matricula ya existe.");
                        break;//Sentencia para salir del caso.
                    case 0: //Cuando arroja el valor 0 imprime el siguiente mensaje:
                        System.out.println("Vehiculo creado e insertado en el concesionario.");
                        break;//Sentencia para salir del caso.
                
                }
           
            break;//Sentencia para salir del caso.
        
            case 2: //Caso 1: tras marcar opción 2. Listar vehículos, muestra las características de los vehículos guardados en el concesionario. 
                concesionario.listaVehiculos();//Método para listar los vehículos guardados en el concesionario. 
                break;//Sentencia para salir del caso.
        
            case 3: //Caso 3: tras marcar opción 3, Buscar vehículo, pide el número de matrícula y valida si ya existe, si existe muestra la marca, 
                //el número de matrícula y su precio. . 
                System.out.println("Introduce la matricula del vehiculo que deseas mostrar:");//Imprime mensaje por pantalla. 
                matricula = entrada.next();//Introduce valor y lo asigna a la variable matricula. 
                if(concesionario.buscaVehiculo(matricula) == null){//Condicional if. En caso de que el método buscaVehículo sea nulo (no exista vehículo con esa matrícula)
                    //imprime el siguiente mensaje:
                    System.out.println("No existe vehiculo con la matricula introducida.");
                }else{//En caso contrario (que exista vehículo con esta matricula), muestra la marca, número de matricula y precio de dicho vehículo:
                    System.out.println(v.getMarca() + " " + v.getNumMatricula() + " " + v.getPrecio());
                }
                
                break;//Sentencia para salir del caso.
        
            case 4: ////Caso 4: tras marcar opción 4. Actualizar. permite actualizar el número de kms de un vehículo dada una matricula. 
                System.out.println("Introduce la matricula del coche al que quieres actualizar los km");//Imprime mensaje por pantalla.
                matricula = entrada.next();// Introduce valor y se lo asigna a la variable matricula.
                System.out.println("Introduce los nuevos km");//Imprime mensaje:
                numeroKm = entrada.nextInt();//Introduce nuevo valor a la variable numero matricula.
                if(concesionario.actualizaKms(matricula, numeroKm)){//Condicional if con el método actualizaKm. Valida que existe la matricula introducida
                    // y en caso de que exista actualiza los kms introducidos. 
                    System.out.println("Kms actualizados.");//En caso de que el método devuelva true imprime el siguiente mensaje:
                }else{//En caso contrario (actualizaKm devuelva false) imprime el siguiente mensaje:
                    System.out.println("No existen vehiculos con la matricula " + matricula + ".");
                }
                break;//Sentencia para salir del caso.
        
            case 5:
                System.out.println("Introduce un nuevo número de matricula:");
                matricula = entrada.next();
                if(concesionario.eliminarVehiculo(matricula)){
                    System.out.println("vehiculo eliminado correctamente");
                
                }else{
                    System.out.println("No existe vehívulo con esta matricula.");
                }
                break;
            case 6: //Caso 5: tras marcar opción 5. Finaliza el programa. 
                salir = true; //Asigna a la variable salir true.
                System.out.println("El programa ha finalizado.");//Imprime el mensaje por pantalla. 
                break;//Sentencia para salir del caso.
        
            default: System.out.println("Escoge una opcion correcta");//En caso de introducir un numero de opcion distinta imprime el mensaje. 
        }

        }
        }
    }
    

