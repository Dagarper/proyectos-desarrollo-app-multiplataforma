package prog07_tarea;

public abstract class CuentaBancaria implements Imprimible{//Clase CuentaBancaria que implementa el interfaz Imprimible.
    //es una clase que no se puede instanciar (es decir, no se puede crear un objeto a partir de ella), 
    //sino que se utiliza como una plantilla para otras clases que hereden de ella (Clase CuentaAhorro y clase CuentaCorriente).
    
    //Declaración de variables privadas que se usarán en esta clase, al ser privadas solo podrán ser usadas dentro de esta clase:
    private Persona titular;//Objeto titular de la Clase Persona.
    private double saldoActual;
    private String iban;

    //Constructor de la clase:
    public CuentaBancaria(Persona titular, double saldoActual, String iban) {
        this.titular = titular;
        this.saldoActual = saldoActual;
        this.iban = iban;
    }
    //Métodos get de las variables del Objeto:
    public Persona getTitular() {
        return titular;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public String getIban() {
        return iban;
    }
    //Métodos set de las variables del Objeto:
    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    //Método to String de la clase Cuenta Bancaria:
    @Override
    public String devolverInfoString(){
    return "titular=" + titular + ", saldoActual=" + saldoActual + ", iban=" + iban;
    }

    

    
    
    
   
    
    
}
