package tema8_ejerc1;

import java.util.ArrayList;////Utilizaría una estructura dinámica, en este caso un ArrayList que permite almacenar vehículos sin una cantidad máxima. 


public class Banco {//Clase pública Banco. Incluye los métodos que se incorporarán en el programa de la clase Principal.
    
    //Declaración de las variables de tipo privada que se utilizarán en el constructor de la clase. al ser privadas solo podrán ser usadas dentro de esta clase:
    private ArrayList <CuentaBancaria> cuentas; //Lista de array del objeto de cuentas bancarias con nombre cuentas.


    //Constructor del objeto array Banco.
    public Banco(){
    this.cuentas = new ArrayList<>();
    }
    
    //Método abrirCuenta recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura. 
    //Devuelve true o false indicando si la operación se realizó con éxito.
    //Hace uso del método buscarCuenta para comprobar si la cuenta con el IBAN introducido ya existe.
   
    public boolean abrirCuenta(CuentaBancaria cuenta){

        
        CuentaBancaria creada = this.buscarCuenta(cuenta.getIban());
        if (creada != null) {
            System.out.println("Ya existe la cuenta bancaria");
            return false;
        }
        
        this.cuentas.add(cuenta);//Añadimos al ArrayList la cuenta.
        System.out.println("La cuenta se ha añadido correctamente.");
        return true;
    }
    //Método buscarCuenta de tipo privado, por lo que solo se puede acceder desde esta clase. 
    //Contiene un bucle for que recorre todo el array y comprueba que si existe una cuenta con el IBAN recibido por parámetro. 
    //En caso de que exista devuelve la cuenta. En caso contrario devuelve null.
    private CuentaBancaria buscarCuenta(String IBAN) {
        CuentaBancaria cuenta = null;
        for (CuentaBancaria c : this.cuentas) {
            if (c.getIban().equals(IBAN)) {
                return c;
            }
        }
        return null;
    }
    
    //Método listadoCuentasde tipo void. 
    //Contiene un bucle for que devuelve con la información del interfaz de cada una de las cuentas que contiene el ArrayList CuentaBancaria.
    public void listadoCuentas(){
        for (CuentaBancaria c : this.cuentas) {
            System.out.println(c.devolverInfoString());
        }
    }
    
    //Método informacionCuenta. Recibe un IBAN por parámetro y dado este IBAN implementa el método buscarCuenta. 
    //Si existe la cuenta devuelve el valor de la interfaz de esa cuenta. 
    public String informacionCuenta (String IBAN){
       
       CuentaBancaria cuenta = this.buscarCuenta(IBAN);
        if (cuenta != null) {
            return cuenta.devolverInfoString();
        }
        return null;
        
    }
    
    //Método booleano ingresoCuenta. Recibe por parámetro un IBAN y una cantidad a ingresar. Comprueba si esta cuenta existe con el método buscarCuenta.
    //Contiene un condicional que comprueba que el valor de cantidad sea positivo, y en caso contrario imprime mensaje de error y devuelve false.
    //Contiene un segundo condicional que comprueba que la cuenta existe, si existe suma la cantidad al saldo actual y lo setea a Saldo actual. En caso contrario devuelve false.
    public boolean ingresoCuenta(String IBAN, double cantidad) {

        CuentaBancaria cuenta = this.buscarCuenta(IBAN);
        if (cantidad <= 0){
        System.out.println("Introduce una cantidad positiva");
        return false;
        }
        
        if (cuenta != null) {
            cuenta.setSaldoActual(cuenta.getSaldoActual()+ cantidad);
            return true;
        }
        return false;
    }
    
    //Método booleano ingresoCuenta. Recibe por parámetro un IBAN y una cantidad a retirar. Comprueba si esta cuenta existe con el método buscarCuenta.
    //Contiene un condicional que comprueba que el valor de cantidad sea positivo, y en caso contrario imprime mensaje de error y devuelve false.
    //Contiene un segundo condicional que comprueba que la cuenta existe, si existe resta la cantidad al saldo actual y lo setea a Saldo actual. En caso contrario devuelve false.
    public boolean retiradaCuenta(String IBAN, double cantidad) {

        CuentaBancaria cuenta = this.buscarCuenta(IBAN);
        if (cantidad <= 0){
        System.out.println("Introduce una cantidad positiva");
        return false;
        }
        
        if (cuenta != null) {
            
            if(cuenta.getSaldoActual() - cantidad > 0){
                cuenta.setSaldoActual(cuenta.getSaldoActual() - cantidad);
                return true;
            }
            return false;
        }
        return false;
        
    }
    
    //Método público de tipo decimal obtenerSaldo. Recibe por parámetro un IBAN y dado este IBAN implementa el método buscarCuenta.
    //Si existe esta cuenta devuelve un getSaldoActual, en caso contrario devuelve -1.
    public double onbtenerSaldo (String IBAN){
    
    CuentaBancaria cuenta = this.buscarCuenta(IBAN);
    
    if (cuenta != null){ 
    return cuenta.getSaldoActual();
    }
    return -1;
    }

    //Método booleano EliminarCuentaBancaria que pasandole un IBAN por parámetro, recorre el ArrayList con un for y comprueba si hay un objeto
    //cuenta con el IBAN introducido. Si lo hay comprueba que esta cuenta tenga un saldo mayor que 0, si es así procede a eliminarla y retorna verdadero. 
    //En caso de que no existala cuenta con ese IBAN devuelve falso, y en caso de que la cuenta exista pero tenga un saldo menor o igual que 0 retorna falso e imprime mensaje por pantalla.  
    public boolean EliminarCuentaBancaria(String IBAN){
        
        CuentaBancaria cuenta = this.buscarCuenta(IBAN);
        if (cuenta != null) {
            if (cuenta.getSaldoActual() > 0) {
                this.cuentas.remove(cuenta);
                return true;
            }else{
                System.out.println("El saldo actual no es mayor que 0.");
            }
        }
        return false;
}
}
