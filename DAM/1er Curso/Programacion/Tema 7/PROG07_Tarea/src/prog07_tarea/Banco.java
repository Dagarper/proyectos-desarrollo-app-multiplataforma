package prog07_tarea;


public class Banco {//Clase pública Banco. Incluye los métodos que se incorporarán en el programa de la clase Principal.
    
    //Declaración de las variables de tipo privada que se utilizarán en el constructor de la clase. al ser privadas solo podrán ser usadas dentro de esta clase:
    private final CuentaBancaria[] cuentas; //Variable de tipo array del objeto de cuentas bancarias con nombre cuentas.
    private final int num_max = 100;//Variable de tipo entero que inicializa con valor 100, se usará para indicar el número máximo de cuentas que contendrá el array "cuentas". 
    private int num_cuentas;//Variable de tipo entero que será utilizada como contador.

    //Constructor del objeto array Banco.
    public Banco(){
    this.cuentas = new CuentaBancaria[num_max];//Crea objeto array de tipo cuentaBancaria que contendrá un número máximo de 100 cuentas.
    this.num_cuentas = 0;//Variable num_cuentas inicializada en 0.
    
    }
    
    //Método abrirCuenta recibe por parámetro un objeto CuentaBancaria y lo almacena en la estructura. 
    //Devuelve true o false indicando si la operación se realizó con éxito.
    //Hace uso del método buscarCuenta para comprobar si la cuenta con el IBAN introducido ya existe.
    //Comprueba si el array cuentas ya está completo
    public boolean abrirCuenta(CuentaBancaria cuenta){
        
        if(this.num_cuentas >= this.num_max){
            System.out.println("Banco completo, no se puede insertar cuenta.");
            return false;
        }
        
        CuentaBancaria creada = this.buscarCuenta(cuenta.getIban());
        if (creada != null) {
            System.out.println("Ya existe la cuenta bancaria");
            return false;
        }
        
        this.cuentas[this.num_cuentas] = cuenta;//Introduce en el array cuentas la nueva cuenta.
        this.num_cuentas++;//Aumenta en 1 el valor de num_cuentas.
        return true;

    }
    //Método buscarCuenta de tipo privado, por lo que solo se puede acceder desde esta clase. 
    //Contiene un bucle for que recorre todo el array y comprueba que si existe una cuenta con el IBAN recibido por parámetro. 
    //En caso de que exista devuelve la cuenta. En caso contrario devuelve null.
    private CuentaBancaria buscarCuenta(String IBAN) {
        for (int i = 0; i < this.num_cuentas; i++) {
            if (this.cuentas[i].getIban().equals(IBAN)) {
                return this.cuentas[i];
            }
        }
        return null;
    }
    
    //Método listadoCuentasde tipo array de String. No recibe valor por parámetro. Declara un array de String de nombre listaCuenta que
    //es un array que contiene las cuentas que existen hasta el momento.
    //Contiene un bucle for que devuelve con la información del interfaz de cada una de las cuentas que contiene el array.
    public String[] listadoCuentas(){
        
        String[] listaCuentas = new String[this.num_cuentas];
        
        for (int i = 0; i < this.num_cuentas; i++) {
            listaCuentas[i] = this.cuentas[i].devolverInfoString();
        }
        
        return listaCuentas;
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

}
