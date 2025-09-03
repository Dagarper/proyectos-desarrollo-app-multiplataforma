/**
 * Representa al objeto Jefe.
 * Cada jefe tiene un nombre, años de antigüedad en la empresa, edad y un posible hijo.
 */
public class Jefe {

    /** Nombre del jefe. */
    String nombre;

    /** Años de antigüedad en la empresa. */
    int añosAntiguedad;

    /** Edad del jefe. */
    int edad;

    /** Hijo del jefe (puede ser null si no tiene hijos). */
    Hijo hijo;

    /**
     * Constructor para crear un nuevo objeto Jefe.
     *
     * @param nombre Nombre del jefe.
     * @param añosAntiguedad Años que lleva en la empresa.
     * @param edad Edad del jefe.
     * @param hijo Hijo del jefe (puede ser null si no tiene hijos).
     */
    public Jefe(String nombre, int añosAntiguedad, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.añosAntiguedad = añosAntiguedad;
        this.edad = edad;
        this.hijo = hijo;
    }

    //Métodos getter y setter
     
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñosAntiguedad() {
        return añosAntiguedad;
    }

    public void setAñosAntiguedad(int añosAntiguedad) {
        this.añosAntiguedad = añosAntiguedad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    /**
     * Devuelve una representación en cadena del objeto Jefe.
     *
     * @return Cadena con la información del jefe, incluyendo su nombre, edad,
     *         años en la empresa y datos de su hijo (si tiene).
     */
    @Override
    public String toString() {
        return "Jefe: " + nombre + ", Años en empresa: " + añosAntiguedad + ", Edad: " + edad
                + (hijo != null ? ", Hijo: " + hijo.nombre + " (" + hijo.edad + " años)" : ", Sin hijos");
    }
}