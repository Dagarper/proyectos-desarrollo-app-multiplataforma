package garcia_perez_david_prog09_tarea;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        ////Declaración de variables que se usarán en la clase principal:
        int opcion, tipoCuenta;
        boolean salir = false; //Variable de tipo booleana inicializada en false. Sirve para crear bucle while que te devuelve al menú principal.
        String nombre, apellidos, dni, iban, listaEntidades, informacion;
        String[] listaCuentas;
        boolean insertada, eliminada;
        double tipoInteres, comisionMant, tipoInteresDesc, maxDescubierto, comisionDesc, saldo, cantidad;
        Persona titular; //Creamos objeto Persona de nombre titular.
        CuentaBancaria cuenta; //Creamos objeto CuentaBancaria de nombre cuenta.
        Banco banco = new Banco();//Creamos objeto Banco de nombre banco que almacenará distintas cuentas.
        //Creamos objeto entrada de tipo Scanner (introducir datos desde el teclado).
        banco.recuperarCuentas();
        Scanner entrada = new Scanner (System.in);
        entrada.useDelimiter("\n");
        entrada.useLocale(Locale.US);
        
        //Bucle while para salir del programa. El programa se cierra cuando la variable booleana salir sea true. 
        while(!salir){
            
            try{//Función try que sirve para probar el caso y arrojar excepciones en caso de que no se cumplan determinadas instrucciones.
        //Menu del programa:
        System.out.println("Escoge una opcion de entre las siguientes:");
        System.out.println("1.Abrir una nueva cuenta."); 
        System.out.println("2. Ver un listado de las cuentas disponibles (código de cuenta, titular y saldo actual).");
        System.out.println("3. Obtener los datos de una cuenta concreta.");
        System.out.println("4. Realizar un ingreso en una cuenta.");
        System.out.println("5. Retirar efectivo de una cuenta.");
        System.out.println("6. Consultar el saldo actual de una cuenta.");
        System.out.println("7. Eliminar cuenta.");
        System.out.println("8. Listado de clientes.");
        System.out.println("9. Salir de la aplicacion.");
        //Entrada de número de opción.
        opcion = entrada.nextInt();
        
        
        switch(opcion){//Condicional de selección múltiple que permite realizar las distintas operaciones en cada caso según la opción del menú escogida.
        
            case 1://Caso 1: tras marcar opción 1. Abrir nueva cuenta. Permite introducir los datos de la cuenta a crear.
                
                cuenta = null;
                
                System.out.println("Introduce los datos del titular:");
                System.out.println("Introduce el nombre:");
                nombre = entrada.next();//Entrada de string de nombre.
                System.out.println("Introduce los apellidos:");
                apellidos = entrada.next();//Entrada de string de apellidos.
                System.out.println("Introduce el DNI del titular:");
                dni = entrada.next();//Entrada de número de DNI.
                
                titular = new Persona(nombre, apellidos, dni);//Crea nuevo objeto Persona e introduce los valores de nombre apellidos y dni a la persona titular de la cuenta.
                
                System.out.println("Titular creado.");
                
                System.out.println("Introduce el IBAN de la cuenta:");
                iban = entrada.next();//Entrada de string de IBAN.
                
                //Condicional if que valida el formato de IBAN.
                if(!iban.matches("^ES[0-9]{20}$")){
                throw new Exception ("Formato incorrecto.");
                }
                
                System.out.println("Introduce el saldo inicial de la cuenta:");
                saldo = entrada.nextDouble();//Entrada de número decimal de saldo.
                //Opciones de menu de elegir tipo de cuenta.
                System.out.println("Elige qué tipo de cuenta quieres crear:");
                System.out.println("1. Cuenta de ahorro.");
                System.out.println("2. Cuenta corriente personal.");
                System.out.println("3. Cuenta corriente de empresa.");
                tipoCuenta = entrada.nextInt();//Entrada de número de tipoCuenta.
                
                
                switch(tipoCuenta){//Condicional de selección múltiple que permite realizar las distintas operaciones en cada caso según la opción de cuenta escogida.
                    case 1: 
                        System.out.println("Introduce el tipo de interes:");
                        tipoInteres = entrada.nextDouble();//Entrada de número decimal de tipoCuenta.
                        cuenta = new CuentaAhorro(tipoInteres, titular, saldo, iban);//Introduce los valores de tipo de interés, titular, saldo e IBAN de la cuenta de ahorro.
                        break;
                    case 2: 
                        System.out.println("Introduce la lista de entidades autorizadas.");
                        listaEntidades = entrada.next();//Entrada de string de listaEntidades.
                        System.out.println("Introdice la comision de mantenimiento:");
                        comisionMant = entrada.nextDouble();//Entrada de número decimal de comisionMant.
                        cuenta = new CuentaCorrientePersonal(comisionMant, listaEntidades, titular, saldo, iban ); ////Introduce los valores de comision de mantenimiento, lista de entidades, titular, saldo e IBAN de la cuenta corriente personal.
                        break;
                    case 3: 
                        System.out.println("Introduce la lista de entidades autorizadas.");
                        listaEntidades = entrada.next();//
                        System.out.println("Introduce el tipo de interes descubierto:");
                        tipoInteresDesc = entrada.nextDouble();
                        System.out.println("Introduce el máximo descubierto:");
                        maxDescubierto = entrada.nextDouble();
                        System.out.println("Introduce la comision de descubierto:");
                        comisionDesc = entrada.nextDouble();
                        cuenta = new CuentaCorrienteEmpresa(tipoInteresDesc, maxDescubierto, comisionDesc, listaEntidades, titular, saldo, iban);//Introduce los valores de tipo de interés descubierto, máximo descubierto permitido, comision de descubierto, lista de entidades autorizadas titular, saldo e IBAN de la cuenta corriente de empresa.
                        break;
                    default: 
                        throw new Exception("Introduce un valor correcto.");//En caso de no elegir un caso entre los disponibles arroja error.
                }
                
                

                //Condicional if que comprueba si la cuenta se ha creado correctamente e insertado en el banco.Comprueba que el boolean insertada sea verdadero.
                insertada = banco.abrirCuenta(cuenta);
                if(insertada){
                    System.out.println("Cuenta abierta correctamente.");
                }else{
                    System.out.println("Cuenta no creada, ha sucedido un error.");
                }
                break;
                
                
            case 2:
                //Introduce el método para listar cuentas del banco. Contiene bucle que recorre el array listaCuentas mostrando las cuentas que hay guardadas hasta la posicion i.
                banco.listadoCuentas();
                    
                break;
            case 3:
                //Método para mostrar la información de la cuenta. Pide un nº de IBAN y comprueba con un condicional que la cuenta existe. Si existe muestra su información.
                System.out.println("Introduce el IBAN de la cuenta:");
                iban = entrada.next();
                
                informacion = banco.informacionCuenta(iban);
                
                if(informacion !=null){
                    System.out.println(informacion);
                }else{
                    System.out.println("La cuenta no existe.");
                }
                    break;
                    
                    
            case 4:                
                //Introduce el método para ingresar en cuenta una cantidad. Pide el IBAN de una cuenta y la cantidad a retirar. 
                //Contiene condicional que comprueba que se hayan introducido los datos correctamente. 
                 System.out.println("Introduce el IBAN de la cuenta:");
                iban = entrada.next();
                
                System.out.println("Introduce la cantidad a ingresar");
                cantidad = entrada.nextDouble();
                
                if(banco.ingresoCuenta(iban, cantidad)){
                    System.out.println("Cantidad ingresada en cuenta");
                }else{
                    System.out.println("Ingreso no realizado, introduce un cantidad correcta.");
                }
                    break;
                    
            case 5:
                //Introduce el método para ingresar en cuenta una cantidad. Pide el IBAN de una cuenta y la cantidad a ingresar. 
                //Contiene condicional que comprueba que se hayan introducido los datos correctamente. 
                System.out.println("Introduce el IBAN de la cuenta:");
                iban = entrada.next();
                
                System.out.println("Introduce la cantidad que desea retirar de la cuenta:");
                cantidad = entrada.nextDouble();
                
                
                if(banco.retiradaCuenta(iban, cantidad)){
                    System.out.println("Cantidad retirada de la cuenta");
                }else{
                    System.out.println("Retirada no realizada correctamente.");
                }

                    break;
            case 6:
                //Introducel el método para obtener el saldo de una cuenta. Pide el IBAN de una cuenta.
                //Contiene condicional if que comprueba que el IBAN que se introduce pertenece a una cuenta que ya existe. 
                System.out.println("Introduce el IBAN de la cuenta:");
                iban = entrada.next();
                
                
                saldo = banco.onbtenerSaldo(iban);
                if(saldo != -1){
                    System.out.println("El saldo es " + saldo + ".");
                }else{
                    System.out.println("La cuenta no existe.");
                }
                  
                    break;
                    
            case 7:
                
                 System.out.println("Introduce el IBAN de la cuenta");
                        iban = entrada.next();
                        
                        if(banco.EliminarCuentaBancaria(iban)){
                            System.out.println("La cuenta bancaria ha sido eliminada");
                        }else{
                            System.out.println("La cuenta bancaria no ha sido eliminada");
                        }
                        break;
                
            case 8:
                banco.listadoClientes();
                System.out.println("Listado de clientes creado");
                break;
            case 9:
                //Finaliza el programa. 
                salir = true;
                banco.guardarCuentas();
                System.out.println("Cuentas guardadas");
                    break;
                    
            default://En caso de no marcar una opcion correcta imprime mensaje de error.
                System.out.println("Introduce un valor correcto.");
        }
            }catch (InputMismatchException e){
            entrada.next();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
}
