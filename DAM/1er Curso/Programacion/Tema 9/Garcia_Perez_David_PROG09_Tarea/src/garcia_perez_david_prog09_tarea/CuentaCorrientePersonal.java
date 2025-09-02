package garcia_perez_david_prog09_tarea;

public class CuentaCorrientePersonal extends CuentaCorriente{//La clase "CuentaCorrientePersonal" es una subclase de "CuentaCorriente" y "CuentaCorriente" es la superclase de "CuentaCorrientePersonal". 
    //La subclase puede tener su propia lógica y comportamiento además de la que hereda de la superclase.
    
    //Declaración de la variables privada que se usará en esta clase, al ser privadas solo podrán ser usadas dentro de esta clase.
    private double comision_mant;

    //Constructor de la clase. Incluye las variables de la superclase CuentaCorriente super(autorizados,titular, saldoActual, iban) además de la de su propia clase.
    public CuentaCorrientePersonal(double comision_mant, String autorizados, Persona titular, double saldoActual, String iban) {
        super(autorizados, titular, saldoActual, iban);
        this.comision_mant = comision_mant;
    }

    //Método get de la clase:
    public double getComision_mant() {
        return comision_mant;
    }

    //Método set de la clase:
    public void setComision_mant(double comision_mant) {
        this.comision_mant = comision_mant;
    }
    
    //El método "super.devolverInfoString()" se refiere al método "devolverInfoString" de la superclase y 
    //llama a ese método para obtener su resultado. La palabra clave "super" se refiere a la superclase de la clase actual.
    @Override
    public String devolverInfoString(){
    return super.devolverInfoString() + " comision_mant: " + comision_mant;
    }

   
    
    
}
