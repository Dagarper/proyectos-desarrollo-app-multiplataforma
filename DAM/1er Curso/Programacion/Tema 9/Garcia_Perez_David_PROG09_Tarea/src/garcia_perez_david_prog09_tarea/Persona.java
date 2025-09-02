package garcia_perez_david_prog09_tarea;

import java.io.Serializable;

public class Persona implements Imprimible, Serializable {//Clase Persona que implementa el interfaz Imprimible.
    //También implementa la interfaz Serializable: esto significa que las subclases de CuentaBancaria pueden ser 
    //guardadas y restauradas como objetos mediante la serialización. La serialización es el proceso de convertir 
    //un objeto en una secuencia de bytes, que luego se puede almacenar en un archivo o transmitir a través de una red.
    //Declaración de variables privadas que se usarán en esta clase, al ser privadas solo podrán ser usadas dentro de esta clase:
    private String nombre;
    private String apellidos;
    private String DNI;

    
    //Constructor de la clase:
    public Persona(String nombre, String apellidos, String DNI) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
    }
    
    //Métodos get de las variables del Objeto:
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    //Métodos set de las variables del Objeto:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    //Método to String de la clase Persona:
    @Override
    public String devolverInfoString() {
        return "nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI;
    }
    
    
    
    
    
    }
    
    
    
    

