package Alumno;

import java.beans.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;
import java.sql.*;
import java.sql.Statement;

/**
 * JavaBean para gestionar matrículas de alumnos.
 */
public class MatriculaBean implements Serializable {

    private PropertyChangeSupport propertySupport;

    protected String DNI;
    protected String NombreModulo;
    protected String Curso;
    protected double Nota;
    protected Vector<Matricula> matriculas = new Vector<>();
    
    protected MatriculaModoListener receptor;

    /**
     * Constructor del JavaBean
     */
    public MatriculaBean() {
        propertySupport = new PropertyChangeSupport(this);
    }

    /**
     * Get the value of DNI
     *
     * @return the value of DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Set the value of DNI
     *
     * @param DNI new value of DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Get the value of NombreModulo
     *
     * @return the value of NombreModulo
     */
    public String getNombreModulo() {
        return NombreModulo;
    }

    /**
     * Set the value of NombreModulo
     *
     * @param NombreModulo new value of NombreModulo
     */
    public void setNombreModulo(String NombreModulo) {
        this.NombreModulo = NombreModulo;
    }

    /**
     * Get the value of Curso
     *
     * @return the value of Curso
     */
    public String getCurso() {
        return Curso;
    }

    /**
     * Set the value of Curso
     *
     * @param Curso new value of Curso
     */
    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    /**
     * Get the value of Nota
     *
     * @return the value of Nota
     */
    public double getNota() {
        return Nota;
    }

    /**
     * Set the value of Nota
     *
     * @param Nota new value of Nota
     */
    public void setNota(double Nota) {
        this.Nota = Nota;
    }

    /**
     * Obtiene el vector de matrículas.
     * @return Vector de matrículas.
     */
    public Vector<Matricula> getMatriculas() {
        return matriculas;
    }

   

    //Clase interna Matrícula, representa a cada matrícula con sus correspondientes atributos y métodos getter y setter:
    public class Matricula {

        String DNI;
        String NombreModulo;
        String Curso;
        double Nota;

        public Matricula(String DNI, String NombreModulo, String Curso, double Nota) {
            this.DNI = DNI;
            this.NombreModulo = NombreModulo;
            this.Curso = Curso;
            this.Nota = Nota;
        }

        public String getDNI() {
            return DNI;
        }

        public void setDNI(String DNI) {
            this.DNI = DNI;
        }

        public String getNombreModulo() {
            return NombreModulo;
        }

        public void setNombreModulo(String NombreModulo) {
            this.NombreModulo = NombreModulo;
        }

        public String getCurso() {
            return Curso;
        }

        public void setCurso(String Curso) {
            this.Curso = Curso;
        }

        public double getNota() {
            return Nota;
        }

        public void setNota(double Nota) {
            this.Nota = Nota;
        }

    }

    public void seleccionarFila(int i) {

        if (i >= 0 && i < matriculas.size()) {

            Matricula m = matriculas.get(i);
            this.DNI = m.DNI;
            this.NombreModulo = m.NombreModulo;
            this.Curso = m.Curso;
            this.Nota = m.Nota;
        } else {
            System.out.println("Indice esta fuera de rango");
            this.DNI = "";
            this.NombreModulo = "";
            this.Curso = "";
            this.Nota = 0.0;
        }
    }

    // Método para cargar todas las matrículas
    public void recargarMatriculas() throws ClassNotFoundException {
        matriculas.clear();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", ""); Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM matriculas");
            while (rs.next()) {
                Matricula m = new Matricula(
                        rs.getString("DNI"),
                        rs.getString("NombreModulo"),
                        rs.getString("Curso"),
                        rs.getDouble("Nota"));
                matriculas.add(m);
            }
            // Lanzar el evento de cambio de modo (modo todas las matriculas)
            if (receptor != null) {
                receptor.cambiarModo("todos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método para recargar matrículas por DNI
    public void recargarDNI(String DNI) {

        matriculas.clear();
        String query = "SELECT * FROM matriculas WHERE DNI = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", ""); PreparedStatement st = conn.prepareStatement(query)) {

            // Establecer el parámetro en la consulta (evita SQL injection)
            st.setString(1, DNI);

            // Ejecutar la consulta
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    // Crear un objeto Matricula y añadirlo al vector
                    Matricula m = new Matricula(
                            rs.getString("DNI"),
                            rs.getString("NombreModulo"),
                            rs.getString("Curso"),
                            rs.getDouble("Nota"));
                    matriculas.add(m);
                }
            }
            // Lanzar el evento de cambio de modo (modo completo)
            if (receptor != null) {
                receptor.cambiarModo("DNI");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Agrega una nueva matrícula a la base de datos.
     */
    public void addMatricula() throws ClassNotFoundException {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "");
            PreparedStatement pdst = conn.prepareStatement("INSERT INTO matriculas (DNI, NombreModulo, Curso, Nota) VALUES (?,?,?,?)");
            pdst.setString(1, DNI);
            pdst.setString(2, NombreModulo);
            pdst.setString(3, Curso);
            pdst.setDouble(4, Nota);

            // Ejecutar la inserción y obtener el número de filas afectadas
            int columnasAfectadas = pdst.executeUpdate();

            if (columnasAfectadas > 0) {
                System.out.println("Matrícula añadida correctamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para añadir o quitar un listener
    public void addMatriculaModoListener(MatriculaModoListener listener) {
        this.receptor = listener;
    }

    public void removeMatriculaModoListener(MatriculaModoListener listener) {
        this.receptor = listener;
    }

    /**
     * Interfaz para manejar eventos de cambio de modo.
     */
    public interface MatriculaModoListener {
        void cambiarModo(String modo);
    }

}
