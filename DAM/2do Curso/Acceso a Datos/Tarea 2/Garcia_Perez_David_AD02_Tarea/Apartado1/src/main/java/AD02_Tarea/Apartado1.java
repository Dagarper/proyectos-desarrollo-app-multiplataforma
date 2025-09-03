package AD02_Tarea;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * La clase {@code Apartado1} gestiona la creación de un archivo binario y su posterior
 * conversión a un archivo XML.
 * Esta clase realiza las siguientes acciones:
 * 1. Escribe una lista de objetos Empleado en un archivo binario llamado {@code empleados.dat}.
 * 2. Lee los datos del archivo binario y los convierte en un archivo XML llamado {@code empleados.xml}.
 *
 * Uso:
 * Al ejecutar esta clase, se generará un archivo binario con datos de empleados y un archivo XML con los mismos datos.
 */

public class Apartado1 {

     /**
     * Método principal que inicia el proceso de creación de archivos.
     * Se crean varios objetos Empleado que se escriben en un archivo binario 
     * llamado empleados.dat. Luego, llama al método CrearXML() para 
     * generar un archivo XML con los datos leídos del archivo binario.
     * @param args
     */
    
    public static void main(String[] args) {

        // Crear instancias de Empleado
        Empleado empleado1 = new Empleado(1, "Juan", "Calle Primera", 1300, 300);
        Empleado empleado2 = new Empleado(2, "Rosa", "Calle Segunda", 1400, 100);
        Empleado empleado3 = new Empleado(3, "Jose", "Calle Tercera", 1500, 200);
        Empleado empleado4 = new Empleado(4, "Maria", "Calle Cuarta", 1100, 500);
        Empleado empleado5 = new Empleado(5, "Antonio", "Calle Quinto", 1600, 50);

        // Crear una lista de empleados
        ArrayList<Empleado> empleados = new ArrayList<>(Arrays.asList(empleado1, empleado2, empleado3, empleado4, empleado5));

        // Escribir los datos de empleados en un archivo binario
        try (RandomAccessFile fichero = new RandomAccessFile("empleados.dat", "rw")) {

            for (Empleado e : empleados) {
                fichero.writeInt(e.getCodigo());
                
                // Escribir el nombre (20 caracteres)
                StringBuffer sb = new StringBuffer(e.getNombre());
                sb.setLength(20);
                fichero.writeChars(sb.toString());
                
                // Escribir la dirección (20 caracteres)
                sb = new StringBuffer(e.getDireccion());
                sb.setLength(20);
                fichero.writeChars(sb.toString());

                // Escribir el salario y la comisión
                fichero.writeFloat(e.getSalario());
                fichero.writeFloat(e.getComision());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Llamar al método para crear el XML
        CrearXML();
    }

    
    /**
     * Método que convierte los datos del archivo binario empleados.dat a un archivo XML.
     * Lee cada empleado del archivo binario y crea un documento XML con la estructura:
     * El archivo resultante se guarda como empleados.xml.
     */
    public static void CrearXML() {
        try {
             // Crear el documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            // Crear el elemento raíz <empleados> y añadirlo al documento
            Element rootElement = documento.createElement("empleados");
            documento.appendChild(rootElement);

            // Lectura de datos de empleados.dat
            try (RandomAccessFile fichero = new RandomAccessFile("empleados.dat", "r")) {
                while (fichero.getFilePointer() < fichero.length()) {
                    
                    // Crear el elemento <empleado>
                    Element elementoEmpleado = documento.createElement("empleado");
                    
                    // Leer y añadir el código
                    int codigo = fichero.readInt();
                    Element elementoCodigo = documento.createElement("codigo");
                    Text codigoText = documento.createTextNode(String.valueOf(codigo));
                    elementoCodigo.appendChild(codigoText);
                    elementoEmpleado.appendChild(elementoCodigo);

                    // Leer y añadir el nombre
                    String nombre = "";
                    for (int i = 0; i < 20; i++) {
                        nombre += fichero.readChar();
                    }
                    Element elementoNombre = documento.createElement("nombre");
                    Text nombreText = documento.createTextNode(nombre.trim());
                    elementoNombre.appendChild(nombreText);
                    elementoEmpleado.appendChild(elementoNombre);

                    // Leer y añadir la direccion.
                    String direccion = "";
                    for (int i = 0; i < 20; i++) {
                        direccion += fichero.readChar();
                    }
                    Element elementoDireccion = documento.createElement("direccion");
                    Text direccionText = documento.createTextNode(direccion.trim());
                    elementoDireccion.appendChild(direccionText);
                    elementoEmpleado.appendChild(elementoDireccion);

                    // Leer y añadir el salario
                    float salario = fichero.readFloat();
                    Element elementoSalario = documento.createElement("salario");
                    Text salarioText = documento.createTextNode(String.valueOf(salario));
                    elementoSalario.appendChild(salarioText);
                    elementoEmpleado.appendChild(elementoSalario);

                    // Leer y añadir la comisión
                    float comision = fichero.readFloat();
                    Element elementoComision = documento.createElement("comision");
                    Text comisionText = documento.createTextNode(String.valueOf(comision));
                    elementoComision.appendChild(comisionText);
                    elementoEmpleado.appendChild(elementoComision);

                    // Añadir el elemento <empleado> al elemento raiz <empleados>
                    rootElement.appendChild(elementoEmpleado);
                }
            }

            // Guardar el documento XML en el archivo empleados.xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("empleados.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo empleados.xml creado exitosamente.");

        } catch (ParserConfigurationException | IOException | TransformerException ex) {
            Logger.getLogger(Apartado1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
