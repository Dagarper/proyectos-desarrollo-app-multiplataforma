package com.prog11.princ;

import com.prog11.bbdd.ConnectionDB;
import com.prog11.bbdd.PropietariosDAO;
import com.prog11.bbdd.VehiculosDAO;
import java.util.ArrayList;
import java.util.Scanner;


public class Prog11_Principal {

    
    public static void main(String[] args) {
        
        
        ArrayList<String> datos = new ArrayList<>();
        ConnectionDB con = new ConnectionDB();
        Scanner entrada = new Scanner(System.in);
        int opcion;
        
        
        System.out.println("1. Insertar varios vehículos y propietarios.");
        
        if (PropietariosDAO.insertarPropietario(con, 6, "Pepito Grillo", "02468102A") == 0) {
            System.out.println("Se ha insertado el propietario Pepito Grillo");
        } else {
            System.out.println("No se ha insertado el propietario Pepito Grillo");
        }

        if (PropietariosDAO.insertarPropietario(con, 7, "Alba Fernandez", "12356789B") == 0) {
            System.out.println("Se ha insertado el propietario Alba Fernandez");
        } else {
            System.out.println("No se ha insertado el propietario Alba Fernandez");
        }

        if (VehiculosDAO.insertarVehiculo(con, "9876ABC", "Mercedes", 70000, 10000, "Clase A", 3) == 0) {
            System.out.println("Se ha insertado el vehiculo con matricula 9876ABC");
        } else {
            System.out.println("No se ha insertado el vehiculo con matricula 9876ABC");
        }

        if (VehiculosDAO.insertarVehiculo(con, "8765CBA", "Renault", 200000, 2000, "Megane", 5) == 0) {
            System.out.println("Se ha insertado el vehiculo con matricula 8765CBA");
        } else {
            System.out.println("No ha insertado el vehiculo con matricula 8765CBA");
        }
        System.out.println("2. Listar todos los vehículos.");
        
        datos = VehiculosDAO.recuperarTodosVeh(con);

        for (String dato : datos) {
            System.out.println(dato);
        }
        
        System.out.println("3. Actualizar propietario de un vehículo.");
        
          if (VehiculosDAO.actualizarProp(con, "1234AAA", 2) == 0) {
            System.out.println("Vehiculo con matricula 1234AAA ha cambiado de propietario con id 2");
        } else {
            System.out.println("No se ha podido cambiar el propietario");
        }
          
        System.out.println("4. Listar todos los vehículos.");
        
        datos = VehiculosDAO.recuperarTodosVeh(con);

        for (String dato : datos) {
            System.out.println(dato);
        }

        System.out.println("5. Eliminar un vehículo que exista.");
        
        
         if (VehiculosDAO.eliminarVeh(con, "1234AAA") == 0) {
             System.out.println("Se ha eliminado el vehiculo con la matricula 1234AAA");
        } else {
             System.out.println("No se ha podido eliminar el vehiculo");
        }
        
        System.out.println("6. Eliminar un vehículo que no exista.");
        
        if (VehiculosDAO.eliminarVeh(con, "0000AAA") == 0) {
            System.out.println("Se ha eliminado el vehiculo con matricula 0000AAA");
        } else {
            System.out.println("No se ha podido eliminar el vehiculo");
        }
        
        System.out.println("7. Listar todos los vehículos.");
        
        datos = VehiculosDAO.recuperarTodosVeh(con);

        for (String dato : datos) {
            System.out.println(dato);
        }
        
        System.out.println("8. Listar los vehículos de una marca.");
        
        datos = VehiculosDAO.recuperarVehMarca(con, "Renault");
        
        for (String dato : datos) {
            System.out.println(dato);
        }
        
        System.out.println("9. Listar todos los vehículos de un propietario.");
        
        datos = PropietariosDAO.recuperarVehiculos(con, "01234567C");
        
        for (String dato : datos) {
            System.out.println(dato);
        }
        
        System.out.println("10. Eliminar un propietario con vehículos.");
        
          if (PropietariosDAO.eliminarProp(con, "12345678A") != 0) {
            System.out.println("Se ha eliminado el propietario con el dni 12345678A");
        } else {
            System.out.println("No se ha eliminado el propietario con el dni 12345678A");
        }

        System.out.println("Eliminar un propietario sin vehículos.");

        if (PropietariosDAO.eliminarProp(con, "02468102A") != 0) {
            System.out.println("Se ha eliminado el propietario con el dni 02468102A");
        } else {
            System.out.println("No se ha eliminado el propietario con el dni 02468102A");
        }
        
        
    }
    
}
