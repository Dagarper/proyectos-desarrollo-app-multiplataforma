
import com.db4o.*;
import com.db4o.query.Query;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File fichero = new File("BDJefeHijo");
        fichero.delete();
        /*Este código anterior lo ponemos por si la base de datos ya existiera y quisiéramos empezar desde el principio.*/
        ObjectContainer baseDatos = Db4oEmbedded.openFile("BDJefeHijo ");
        baseDatos.store(new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7)));
        baseDatos.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
        baseDatos.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
        baseDatos.store(new Jefe("Dolores", 5, 63, new Hijo("Sergio", 7)));
        baseDatos.store(new Jefe("Vicki", 3, 5, null));
        baseDatos.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
        baseDatos.store(new Jefe("Juan Luís", 3, 5, null));
        baseDatos.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20, 45, new Hijo("Paula", 3)));
        baseDatos.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));
        baseDatos.close();
        
        
        baseDatos = Db4oEmbedded.openFile("BDJefeHijo");
        
         // 1. Visualizar los jefes con más de 55 años
            System.out.println("Jefes con mas de 55 años:");
            Query query1 = baseDatos.query();
            query1.constrain(Jefe.class);
            query1.descend("edad").constrain(55).greater();
            ObjectSet<Jefe> resultado1 = query1.execute();
            for (Jefe j : resultado1) {
                System.out.println(j);
            }
            
         // 2. Modificar la edad de Miguel
            Query query2 = baseDatos.query();
            query2.constrain(Jefe.class);
            query2.descend("nombre").constrain("Miguel");
            ObjectSet<Jefe> resultado2 = query2.execute();
            for (Jefe j : resultado2) {
                j.edad += 1;
                baseDatos.store(j);
            }
            
          // 3. Borrar los jefes que llevan más de 6 años en la empresa
            Query query3 = baseDatos.query();
            query3.constrain(Jefe.class);
            query3.descend("añosAntiguedad").constrain(6).greater();
            ObjectSet<Jefe> resultado3 = query3.execute();
            for (Jefe j : resultado3) {
                System.out.println("\nEl Jefe con nombre " + j.nombre + "con "+ j.añosAntiguedad+ " años de antiguedad ha sido borrado.");
                baseDatos.delete(j);
            }
            
          // 4. Visualizar todos los jefes restantes
            System.out.println("\nJefes restantes:");
            ObjectSet<Jefe> resultadoFinal = baseDatos.query(Jefe.class);
            for (Jefe j : resultadoFinal) {
                System.out.println(j);
            }
        
        
            baseDatos.close(); // Cerrar BD al final
        
    }

}
