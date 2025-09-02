package prog07_tarea;

public class CuentaCorrienteEmpresa extends CuentaCorriente{//La clase "CuentaCorrientePersonal" es una subclase de "CuentaCorriente" y "CuentaCorriente" es la superclase de "CuentaCorrientePersonal". 
    //La subclase puede tener su propia lógica y comportamiento además de la que hereda de la superclase.
    
    //Declaración de variables privadas que se usarán en esta clase, al ser privadas solo podrán ser usadas dentro de esta clase:
    private double interes_descubierto;
    private double max_descubierto;
    private double comision_fija;

    //Constructor de la clase. Incluye las variables de la superclase CuentaCorriente super(autorizados,titular, saldoActual, iban) además de la de su propia clase.
    public CuentaCorrienteEmpresa(double interes_descubierto, double max_descubierto, double comision_fija, String autorizados, Persona titular, double saldoActual, String iban) {
        super(autorizados, titular, saldoActual, iban);
        this.interes_descubierto = interes_descubierto;
        this.max_descubierto = max_descubierto;
        this.comision_fija = comision_fija;
    }
    
    //Métodos get de la clase:
    public double getInteres_descubierto() {
        return interes_descubierto;
    }

    public double getMax_descubierto() {
        return max_descubierto;
    }

    public double getComision_fija() {
        return comision_fija;
    }

    //Métodos set de la clase:
    public void setInteres_descubierto(double interes_descubierto) {
        this.interes_descubierto = interes_descubierto;
    }

    public void setMax_descubierto(double max_descubierto) {
        this.max_descubierto = max_descubierto;
    }

    public void setComision_fija(double comision_fija) {
        this.comision_fija = comision_fija;
    }
    
    //El método "super.devolverInfoString()" se refiere al método "devolverInfoString" de la superclase y 
    //llama a ese método para obtener su resultado. La palabra clave "super" se refiere a la superclase de la clase actual.
    @Override
    public String devolverInfoString(){
    return super.devolverInfoString() + "interes_descubierto=" + interes_descubierto + ", max_descubierto=" + max_descubierto + ", comision_fija=" + comision_fija;
    }

    
    
    
}
