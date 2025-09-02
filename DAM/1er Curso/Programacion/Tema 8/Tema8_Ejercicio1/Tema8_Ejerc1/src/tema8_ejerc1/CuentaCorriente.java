package tema8_ejerc1;


public class CuentaCorriente extends CuentaBancaria {//La clase "CuentaCorriente" es una subclase de "CuentaBancaria" y "CuentaBancaria" es la superclase de "CuentaCorriente". 
    //La subclase puede tener su propia lógica y comportamiento además de la que hereda de la superclase.
    
    //Declaración de la variables privada que se usará en esta clase, al ser privadas solo podrán ser usadas dentro de esta clase:
    private String autorizados;

    //Constructor de la clase. Incluye las variables de la superclase CuentaBancaria super(titular, saldoActual, iban) además de la de su propia clase.
    public CuentaCorriente(String autorizados, Persona titular, double saldoActual, String iban) {
        super(titular, saldoActual, iban);
        this.autorizados = autorizados;
    }
    //Método get del objeto:
    public String getAutorizados() {
        return autorizados;
    }
    
    //Método set del objeto:
    public void setAutorizados(String autorizados) {
        this.autorizados = autorizados;
    }
 
    //El método "super.devolverInfoString()" se refiere al método "devolverInfoString" de la superclase y 
    //llama a ese método para obtener su resultado. La palabra clave "super" se refiere a la superclase de la clase actual.
    @Override
    public String devolverInfoString(){
    return super.devolverInfoString() + "autorizados=" + autorizados;
    }

   
    
   
    
}
