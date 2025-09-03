package garcia_perez_david_psp06_tarea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String nombreUsuario;
        
        
        System.out.println("Indique el nombre del usuario:");
        
        do{
            //Debemos poner un trim() para que al ejecutar el programa por consola
        nombreUsuario = sc.next().trim();
            System.out.println("");
        
            if (!validarUsuario(nombreUsuario)) {
                System.out.println("El nombre del usuario debe componerse de 8 letras minusculas");
                log("El nombre del usuario debe componerse de 8 letras minusculas " + nombreUsuario);
            }
        
        
        }while(!validarUsuario(nombreUsuario));
        log("Usuario ingresado correctamente: " + nombreUsuario);
        
        
        String nombreFichero;
        
        
        System.out.println("Indique el nombre del fichero:");
        
        do{
        nombreFichero = sc.next().trim();
        
            if (!validarFichero(nombreFichero)) {
                System.out.println("El nombre del fichero debe componerse de 8 caracteres y una extension con 3 caracteres. Ejemplo: ejemplo.txt");
                log("El nombre del fichero debe componerse de 8 caracteres y una extension con 3 caracteres " + nombreFichero);
            }
        
        
        }while(!validarFichero(nombreFichero));
        log("Nombre de fichero ingresado correctamente: " + nombreFichero);
        
        try {
            leerFichero(nombreFichero);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static boolean validarUsuario(String nombre){
    
    return nombre.matches("[a-z]{1,8}");
    }
    
    public static boolean validarFichero(String nombre){
    
    return nombre.matches("[a-zA-Z0-9]{1,8}\\.[a-zA-Z0-9]{3}");
    }
    
    public static void leerFichero(String nombreFichero) throws FileNotFoundException, IOException{
    
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        
        String linea;
        while((linea = br.readLine()) != null){
        
            System.out.println(linea);
        }
        
    }
    
    
    public static void log (String mensaje) throws IOException{
    
        try (PrintWriter pw = new PrintWriter(new FileWriter("registro.log", true))) {
            pw.println("[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "]" + mensaje);
        }
    }
    
    
}
