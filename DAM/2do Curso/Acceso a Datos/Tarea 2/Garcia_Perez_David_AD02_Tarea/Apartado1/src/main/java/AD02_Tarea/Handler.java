package AD02_Tarea;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Handler personalizado para procesar un archivo XML utilizando la API SAX.
 * Esta clase extiende {@link DefaultHandler} y se encarga de manejar los eventos
 * que ocurren durante el análisis de un archivo XML, como el inicio y fin de elementos,
 * así como el contenido de texto.
 * 
 * El propósito de esta clase es leer y mostrar la información de libros de un archivo XML,
 * incluyendo el año de publicación, título, autores, editorial y precio.
 * 
 */

public class Handler extends DefaultHandler {
    
    /** StringBuilder para almacenar el contenido de texto entre etiquetas XML. */
    private StringBuilder valor;
    
    /**
     * Constructor por defecto que inicializa el StringBuilder utilizado para almacenar
     * el contenido de texto.
     */
    public Handler() {
        this.valor = new StringBuilder();
    }
        
    /**
     * Método que se llama al inicio de un elemento XML.
     * Este método se utiliza para detectar la etiqueta de inicio y sus atributos.
     * Si la etiqueta es "libro", se imprime el atributo "año".
     * @param uri El URI del espacio de nombres, o una cadena vacía si no hay ningún URI.
     * @param localName El nombre local de la etiqueta (sin prefijo), o una cadena vacía si no hay ninguno.
     * @param qName El nombre calificado de la etiqueta (con prefijo).
     * @param attributes Los atributos adjuntos al elemento. Si no hay atributos, será una colección vacía.
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
    
        this.valor.setLength(0);// Limpiar el valor previo
        
        // Si es la etiqueta "libro", mostrar el atributo "año"
        if (qName.equals("libro")) {
            
            System.out.println("Año: " + attributes.getValue("año"));
        }
        
    }
    
    /**
     * Método que se llama cuando se encuentra texto entre las etiquetas XML.
     * Este texto se agrega al StringBuilder para su uso posterior.
     * 
     * @param ch Array de caracteres que contiene el texto.
     * @param start Posición de inicio del texto relevante dentro del array.
     * @param length Longitud del texto relevante en el array.
     */
    @Override
    public void characters(char[] ch, int start, int length){
        // Añadir texto al StringBuilder
        this.valor.append(ch, start, length);
    }
    
    /**
     * Método que se llama al final de un elemento XML.
     * Basado en la etiqueta que se cierra, este método imprime la información recopilada,
     * como título, autor, editorial y precio.
     * 
     * @param uri El URI del espacio de nombres, o una cadena vacía si no hay ningún URI.
     * @param localName El nombre local de la etiqueta (sin prefijo), o una cadena vacía si no hay ninguno.
     * @param qName El nombre calificado de la etiqueta (con prefijo).
     */ 
    @Override
    public void endElement(String uri, String localName, String qName){
    // El bloque switch evalúa el nombre de la etiqueta que se está cerrando (qName)
        switch(qName){
            
            // Caso cuando se encuentra la etiqueta de cierre </libro>
            case "libro" -> System.out.println(""); // Imprime una línea en blanco para separar la información de distintos libros
            // Caso cuando se encuentra la etiqueta de cierre </titulo>
            case "titulo" -> System.out.println("Titulo: " + this.valor.toString()); // Muestra el título del libro almacenado en el StringBuilder 'valor'
            // Caso cuando se encuentra la etiqueta de cierre </apellido>
            case "apellido" -> System.out.println("Apellido autor: " + this.valor.toString()); // Imprime el apellido del autor, capturado previamente por el método characters()
            // Caso cuando se encuentra la etiqueta de cierre </nombre>
            case "nombre" -> System.out.println("Nombre autor: " + this.valor.toString()); // Imprime el nombre del autor, capturado previamente por el método characters()
            // Caso cuando se encuentra la etiqueta de cierre </editorial>
            case "editorial" -> System.out.println("Editorial: " + this.valor.toString());// Imprime el nombre de la editorial capturado previamente
            // Caso cuando se encuentra la etiqueta de cierre </precio>
            case "precio" -> System.out.println("Precio: " + this.valor.toString());// Imprime el precio del libro almacenado en el StringBuilder 'valor'
                
                
            
               
        }
    }
    
    
    
    
}
