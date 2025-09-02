
package prog06_tarea;

import java.time.LocalDate;
import java.time.Period;

public class Vehiculo {
    
private String marca, numMatricula, nomProp, descripcion, dniProp;//variables de tipo String, permiten guardar un texto. 
private int numKm;//Variable tipo numérica. 
private double precio;//Variable tipo numérico decimal.
private LocalDate fechaMatr;//Variable en formato fecha (dia/mes/año).



 
    public Vehiculo(String marca, String numMatricula, String nomProp, String descripcion, int numKm, double precio, LocalDate fechaMatr, String dniProp) {//Constructor del objeto Vehículo.
        //Compuesto por las siguientes variables: 
        this.marca = marca;
        this.numMatricula = numMatricula;
        this.nomProp = nomProp;
        this.precio = precio;
        this.descripcion = descripcion;
        this.numKm = numKm;
        this.fechaMatr = fechaMatr;
        this.dniProp = dniProp;
    }                      

    
//Método get de las variables del constructor. Devuelve el valor dado a los distintos atributos del objeto. 
    public String getMarca() {
        return marca;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public String getNomProp() {
        return nomProp;
    }

    public String getDniProp() {
        return dniProp;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNumKm() {
        return numKm;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaMatr() {
        return fechaMatr;
    }

//Método set de las variables/atributos del constructor. Permite asignar valores a las distintas variables/atributos del constructor. Son públicos para poder utilizarse
    //en el resto de clases. Aunque se introducen todas, en este ejercicio solo se utiliza el método setNumKm.
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    public void setNomProp(String nomProp) {
        this.nomProp = nomProp;
    }

    public void setDniProp(String dniProp) {
        this.dniProp = dniProp;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNumKm(int numKm) {
        this.numKm = numKm;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFechaMatr(LocalDate fechaMatr) {
        this.fechaMatr = fechaMatr;
    }

            
   //Método toString(), devuelve el nombre y el valor de las variables/atributos del constructor Vehículo.          

    @Override
    public String toString() {
        return "Vehiculo de la marca: " + marca + ", con numero de matricula: " + numMatricula + ". Fecha de matriculacion: " + fechaMatr + ". Precio: " + precio + ". Numero de Kms: " + numKm + ". Descripcion: " + descripcion;
    }
   






    public int get_Anios() {//Creación del método get_Anios, que permite obtener un periodo (en años) entre la fecha dada y la actual.
      LocalDate fechaInicio = this.fechaMatr;//Declaración de la variable de tipo fecha (dia/mes/año) a la que se da el valor de la variable fechaMatr.
      LocalDate fechaHoy = LocalDate.now();//Declaración de la variable de tipo fecha (dia/mes/año) a la que se da el valor de la fecha actual.
      
      Period p = Period.between(fechaInicio, fechaHoy);//Periodo p que comprede la fecha transcurrida entre fechaInicio y fechaHoy.
      
      return p.getYears();//Este método devuelve el periodo p en años (función de .getYear).
      
        
        
    }
    
    
    
}
