package AD02_Tarea;

import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * La clase Apartado2 se encarga de leer y procesar un archivo XML que contiene información
 * sobre libros, imprimiendo en la consola todas las etiquetas y sus respectivos valores.
 * Utiliza la API DOM para analizar el contenido del archivo XML.
 */
public class Apartado2_DOM {

    /**
     * Método principal que ejecuta el programa.
     * Carga el archivo XML, lo analiza, y muestra en la consola los elementos y sus valores.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este programa).
     * @throws SAXException Si ocurre un error durante el análisis del archivo XML.
     */
    public static void main(String[] args) throws SAXException {

        try {
            // Cargar el archivo XML
            File archivoXML = new File("LIBROS.XML");

            // Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Crear un DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parsear el archivo XML y obtener el documento
            Document doc = dBuilder.parse(archivoXML);

            // Normalizar el documento XML para eliminar nodos redundantes
            doc.getDocumentElement().normalize();

            // Obtener el elemento raíz del documento XML
            Element raiz = (Element) doc.getDocumentElement();
            System.out.println("Elemento raiz: " + raiz.getNodeName());

            // Obtener la lista de elementos <libro>
            NodeList listaLibros = doc.getElementsByTagName("libro");

            // Iterar sobre cada elemento <libro>
            for (int i = 0; i < listaLibros.getLength(); i++) {
                Node nodo = listaLibros.item(i);

                // Verificar si el nodo es un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element libro = (Element) nodo;
                    // Imprimir el nombre de la etiqueta <libro> y el atributo "año"
                    System.out.println("Etiqueta: " + libro.getNodeName() + 
                                       ". Atributo: año = " + libro.getAttribute("año") + ".");

                    // Obtener todos los hijos del elemento <libro>
                    NodeList hijosLibro = libro.getChildNodes();

                    // Iterar sobre los hijos del elemento <libro>
                    for (int j = 0; j < hijosLibro.getLength(); j++) {
                        Node nodo2 = hijosLibro.item(j);

                        // Verificar si el nodo es un elemento
                        if (nodo2.getNodeType() == Node.ELEMENT_NODE) {
                            Element hijoLibro = (Element) nodo2;

                            // Verificar si el elemento tiene hijos
                            if (nodo2.hasChildNodes()) {
                                NodeList hijosAutor = hijoLibro.getChildNodes();

                                // Iterar sobre los hijos del elemento (caso de múltiples autores)
                                for (int k = 0; k < hijosAutor.getLength(); k++) {
                                    Node nodo3 = hijosAutor.item(k);

                                    // Verificar si el nodo es un elemento
                                    if (nodo3.getNodeType() == Node.ELEMENT_NODE) {
                                        Element hijoAutor = (Element) nodo3;
                                        // Imprimir el nombre de la etiqueta y su valor de texto
                                        System.out.println("Etiqueta: " + hijoAutor.getNodeName() + 
                                                           ". Valor: " + hijoAutor.getTextContent());
                                    }
                                }

                            } else {
                                // Imprimir el nombre de la etiqueta y su contenido de texto
                                System.out.println("Etiqueta: " + hijoLibro.getNodeName() + 
                                                   ". Texto: " + hijoLibro.getTextContent());
                            }
                        }
                    }
                }
                // Imprimir una línea en blanco para separar cada libro
                System.out.println("");
            }

        } catch (ParserConfigurationException | IOException ex) {
            Logger.getLogger(Apartado2_DOM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}