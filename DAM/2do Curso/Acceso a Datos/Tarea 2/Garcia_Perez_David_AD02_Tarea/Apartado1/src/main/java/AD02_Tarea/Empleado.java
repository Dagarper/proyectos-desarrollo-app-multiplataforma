package AD02_Tarea;

public class Empleado {

    int codigo;
    String nombre;
    String direccion;
    float salario;
    float comision;

    public Empleado(int codigo, String nombre, String direccion, float salario, float comision) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.salario = salario;
        this.comision = comision;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public float getSalario() {
        return salario;
    }

    public float getComision() {
        return comision;
    }

    @Override
    public String toString() {
        return "Empleado{ " + "Codigo: " + codigo + ". Nombre: " + nombre + ". Direccion: " + direccion + ". Salario: " + salario + ". Comision: " + comision + ".}";
    }

    
    
}
