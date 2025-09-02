
package com.prog11.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {// Define una nueva clase llamada ConnectionDB.
    private Connection con; //define una variable privada con de tipo Connection. 
    //Esta variable almacenará la conexión a la base de datos.

    public void openConnection() throws SQLException {
    //define un método público llamado openConnection que lanza una excepción de
    //tipo SQLException. Este método se encarga de abrir una conexión a la base 
    //de datos. utiliza la clase DriverManager para obtener una conexión a la 
    //base de datos con la URL de conexión.   

       
    this.con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/concesionario", "root", "root");
    } //Este método asigna la conexión a la variable con.

    public void closeConnection() throws SQLException {
        this.con.close();
    }//define un método público llamado closeConnection que lanza una excepción 
    //de tipo SQLException. Este método se encarga de cerrar la conexión a la base de datos.
    //cierra la conexión a la base de datos almacenada en la variable con.


    public Connection getConnection(){
    return this.con;
    }//define un método público llamado getConnection que devuelve la conexión 
    //a la base de datos almacenada en la variable con. La línea return this.con;
    //devuelve la conexión a la base de datos almacenada en la variable con.

}
