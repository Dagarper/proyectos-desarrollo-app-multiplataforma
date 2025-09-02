package garcia_perez_david_prog09_tarea;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    //Comprueba si el array cuentas ya está completo
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
    
//Método guardar cuentas que guarda en el archivo con formato binario llamado 
//"datoscuentasbancarias.dat" la información de las cuentas bancarias que se van creando.
    public void guardarCuentas(){
        
        //utiliza un ObjectOutputStream para escribir los objetos CuentaBancaria en el archivo. 
        //Primero, crea un objeto ObjectOutputStream envolviendo un objeto FileOutputStream que representa el archivo de destino.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("datoscuentasbancarias.dat"))){
        
        //bucle for-each para iterar a través de cada objeto CuentaBancaria en la lista cuentas y escribe cada objeto en el archivo 
        //usando el método writeObject() del ObjectOutputStream.   
            for (CuentaBancaria cuenta: cuentas) {
                oos.writeObject(cuenta);
            }
        
        //Si ocurre alguna excepción, como una FileNotFoundException o una IOException, el método captura la excepción 
        //e imprime un mensaje de error.    
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
//El método recuperarCuentas recupera los datos de una lista de objetos de la clase CuentaBancaria 
//que han sido previamente guardados en un archivo binario llamado 
//"datoscuentasbancarias.dat" y los carga en una lista cuentas.    
    public void recuperarCuentas(){
        
        //Utiliza un ObjectInputStream para leer los objetos CuentaBancaria del archivo binario. 
        //Primero, crea un objeto ObjectInputStream envolviendo un objeto FileInputStream que representa el archivo de origen.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("datoscuentasbancarias.dat"))){
        
           //utiliza un bucle while(true) para leer cada objeto CuentaBancaria del archivo binario y utiliza el método 
           //abrirCuenta() para agregar cada objeto a la lista cuentas. Este bucle se ejecuta hasta 
           //que se lanza una excepción EOFException, lo que indica que se ha alcanzado el final del archivo binario.
            while(true){
                CuentaBancaria cuenta = (CuentaBancaria)ois.readObject();
                this.abrirCuenta(cuenta);
            }
        //Si ocurre alguna excepción, como una FileNotFoundException, una EOFException, una IOException o una 
        //ClassNotFoundException, el método captura la excepción e imprime un mensaje de error apropiado.    
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el fichero.");
        } catch (EOFException ex) {
            System.out.println("Cuentas añadidas del fichero de cuentas guardadas");    
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
        //En resumen, este método recupera los datos de cuentas bancarias previamente guardados 
        //y los carga en una lista de cuentas para que puedan ser utilizados por otros métodos en la aplicación.
    }
    
    //El método listadoClientes crea un archivo de texto llamado "listadoCCC.txt" y escribe información de cada 
    //cliente y su respectivo número de cuenta bancaria en el archivo.
        public void listadoClientes(){
        //Primero, el método utiliza un BufferedWriter para escribir el contenido en el archivo. 
            
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("listadoCCC.txt"));){
        String linea; 
        //Dentro de un bucle for-each, el método itera a través de cada objeto CuentaBancaria en la lista cuentas.
        //Para cada objeto CuentaBancaria, el método crea una línea de texto que incluye la información del titular 
        //de la cuenta y su respectivo número de cuenta bancaria (obtenido con los métodos devolverInfoString() 
        //y getIban(), respectivamente). Luego, escribe esta línea en el archivo usando el método write() del BufferedWriter.
        for (CuentaBancaria cuenta : cuentas) {
            linea = cuenta.getTitular().devolverInfoString() + " " + cuenta.getIban() + "\r\n";
            bw.write(linea);
            }
        //Después de escribir las líneas de información para cada cuenta bancaria, el método escribe una última línea que 
        //indica el número total de cuentas en la lista cuentas.
        bw.write("Numero de cuentas: " + cuentas.size());
        } catch (IOException ex) {
        //Si ocurre una excepción IOException al intentar escribir en el archivo, el método captura la excepción y la registra con el objeto Logger.
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }

            
}
}

