package garcia_perez_david_di02_tarea;

import com.trolltech.qt.gui.QApplication;


/**
 * Clase principal de la aplicación.
 * 
 * Esta clase contiene el método `main` que sirve como punto de entrada para la ejecución de la aplicación Qt.
 * Inicializa la aplicación Qt, crea la ventana principal (MainWindow) y luego ejecuta el bucle de eventos de la aplicación.
 */

public class Main {

    public static void main(String[] args) {
         // Inicializar la aplicación Qt con los argumentos proporcionados
        QApplication.initialize(args);
        
        // Crear la ventana principal
        MainWindow principal = new MainWindow();
        // Configurar la interfaz de usuario de la ventana principal
        principal.setupUi(principal);
        // Mostrar la ventana principal en pantalla
        principal.show();
         // Ejecutar el bucle de eventos de la aplicación Qt
        QApplication.execStatic();
    }
    
    
}