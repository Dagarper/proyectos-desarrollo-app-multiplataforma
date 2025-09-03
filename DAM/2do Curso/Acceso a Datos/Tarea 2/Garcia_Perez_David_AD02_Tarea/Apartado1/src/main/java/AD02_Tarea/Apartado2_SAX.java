package AD02_Tarea;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 * Esta clase utiliza el analizador SAX para leer y procesar un archivo XML.
 * El archivo XML que se espera es "libros.xml", que contiene información sobre libros.
 */
public class Apartado2_SAX {
    
    
    /**
     * Método principal que se encarga de configurar y ejecutar el análisis SAX sobre el archivo XML.
     * Carga el archivo "libros.xml", crea una instancia de SAXParser y un manejador personalizado
     * Handler para procesar el contenido del archivo.
     */
    public static void main (String[] args){
       
        try {
            // Crear una referencia al archivo XML
            File archivoXML = new File("libros.xml");
            
            // Crear una instancia de SAXParserFactory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            // Crear un SAXParser para analizar el archivo
            SAXParser parser = factory.newSAXParser();
            
            // Crear un manejador personalizado para los eventos SAX
            Handler manejador = new Handler();
            
            // Iniciar el análisis del archivo XML utilizando el manejador
            parser.parse(archivoXML, manejador);
                    
                    
                    
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Apartado2_SAX.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
    
    
}
