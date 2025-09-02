package prog07_tarea;

public class CuentaAhorro extends CuentaBancaria{//La clase "CuentaAhorro" es una subclase de "CuentaBancaria" y "CuentaBancaria" es la superclase de "CuentaAhorro". 
    //La subclase puede tener su propia lógica y comportamiento además de la que hereda de la superclase.
    
   //Declaración de la variables privada que se usará en esta clase, al ser privadas solo podrán ser usadas dentro de esta clase:
   private double interes_anual;

   //Constructor de la clase. Incluye las variables de la superclase CuentaBancaria super(titular, saldoActual, iban) además de la de su propia clase.
    public CuentaAhorro(double interes_anual, Persona titular, double saldoActual, String iban) {
        super(titular, saldoActual, iban);
        this.interes_anual = interes_anual;
    }
    
    //Método get del objeto:
    public double getInteres_anual() {
        return interes_anual;
    }
    
    //Método set del objeto:
    public void setInteres_anual(double interes_anual) {
        this.interes_anual = interes_anual;
    }
    
    //El método "super.devolverInfoString()" se refiere al método "devolverInfoString" de la superclase y 
    //llama a ese método para obtener su resultado. La palabra clave "super" se refiere a la superclase de la clase actual.
    @Override
    public String devolverInfoString(){
    return super.devolverInfoString() + "interes_anual=" + interes_anual;
    }

   
    
}
