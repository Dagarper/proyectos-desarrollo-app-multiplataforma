/**
 * Representa a un hijo de un jefe dentro de la empresa.
 * Cada hijo tiene un nombre y una edad.
 */
public class Hijo {

    /** Nombre del hijo. */
    String nombre;

    /** Edad del hijo. */
    int edad;

    /**
     * Constructor para crear un nuevo objeto Hijo.
     *
     * @param nombre Nombre del hijo.
     * @param edad Edad del hijo.
     */
    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    //Métodos getter y setter:
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve una representación en cadena del objeto Hijo.
     *
     * @return Cadena con la información del hijo.
     */
    @Override
    public String toString() {
        return "Hijo: " + nombre + " (" + edad + " años)";
    }
}