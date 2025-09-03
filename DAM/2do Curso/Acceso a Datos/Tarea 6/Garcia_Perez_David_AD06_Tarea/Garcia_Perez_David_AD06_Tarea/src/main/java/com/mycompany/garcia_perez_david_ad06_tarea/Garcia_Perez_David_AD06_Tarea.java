package com.mycompany.garcia_perez_david_ad06_tarea;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XQueryService;

/**
 *
 * @author David
 */
public class Garcia_Perez_David_AD06_Tarea {
    private static final String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";
    private static final String COLLECTION_PATH = "/db/ejercicios";
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        try {
            // Cargar el controlador de eXist-DB
            String driver = "org.exist.xmldb.DatabaseImpl";
            Class<?> cl = Class.forName(driver);
            Database database = (Database) cl.getDeclaredConstructor().newInstance();
            DatabaseManager.registerDatabase(database);

            // Obtener la colección
            Collection col = DatabaseManager.getCollection(URI + COLLECTION_PATH, USER, PASSWORD);
            if (col == null) {
                System.out.println("No se encontró la colección.");
                return;
            }

            // Realizar la consulta XQuery
            String xquery = "for $libro in collection('/db/ejercicios')/bib/libro return $libro";
            XQueryService xqueryService = (XQueryService) col.getService("XQueryService", "1.0");
            ResourceSet result = xqueryService.query(xquery);

            // Mostrar los resultados
            ResourceIterator it = result.getIterator();
            while (it.hasMoreResources()) {
                Resource res = it.nextResource();
                System.out.println(res.getContent());
            }

            // Cerrar la colección
            col.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}