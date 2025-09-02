package com.prog11.bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehiculosDAO {
    
    //Método insertarVehiculo que recibe por parámetro la conexion con la base de datos,
    //el valor para las columnas del vehiculo y el id de propietario el nombre del propietario y el DNI. 
    //realizamos un PerparedStatement al que le pasamos la consulta con los valores de estas variables para 
    //insertar un nuevo registro en la tabla vehiculo
    //con el signo ?, que será intercambiado por los valores pasado por parametro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar)
    //posteriormente cerramos la conexion. 
    static public int insertarVehiculo(ConnectionDB con,String mat_veh, String marca_veh, int kms_veh, float precio_veh, String desc_veh, int id_prop){
    
        try {
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement("INSERT INTO vehiculo(mat_veh, marca_veh, kms_veh, precio_veh, desc_veh, id_prop) "
                    + "VALUES (?,?,?,?,?,?)");
            statement.setString(1, mat_veh);
            statement.setString(2, marca_veh);
            statement.setInt(3, kms_veh);
            statement.setFloat(4, precio_veh);
            statement.setString(5, desc_veh);
            statement.setInt(6, id_prop);
            
            statement.executeUpdate();
            statement.close();
           
            con.closeConnection();
            return 0;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
        
        return -1;
        
        
    }
    
    //Método actualizarProp que recibe por parámetro la conexion con la base de datos
    //el valor de la matricula del vehiculo y el id de propietario. Al final del método devuelve -1 o 0,
    //realizamos un PerparedStatement al que le pasamos la consulta para actualizar el valor de id_prop 
    //con el signo ?, que será intercambiado por el valor pasado por parametro cuando coincida con la matricula
    //pasada por parámetro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar)
    //posteriormente cerramos la conexion. 
    public static int actualizarProp(ConnectionDB con, String mat_veh, int id_prop){
        
        try {
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement("UPDATE vehiculo SET id_prop = ? WHERE mat_veh = ?");
            statement.setInt(1, id_prop);
            statement.setString(2, mat_veh);
            
            int actualizado = statement.executeUpdate();
            
            if (actualizado == 0) {
                return -1;
            } 
            
            statement.close();
            con.closeConnection();
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           return -1;
    }
    
    //Método eliminarVeh que recibe por parámetro la conexion con la base de datos
    //y el valor de la matricula del vehiculo. Al final del método devuelve -1 o 0,
    //realizamos un PerparedStatement al que le pasamos la consulta para borrar el registro que se  
    //corresponde con la matricula que utiliza un marcador de posicion (signo ?), que será intercambiado 
    //por el valor pasado por parametro cuando coincida con la matricula
    //pasada por parámetro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar)
    //posteriormente cerramos la conexion. 
    static public int eliminarVeh (ConnectionDB con, String mat_veh){
    
        try {
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement("DELETE FROM vehiculo WHERE mat_veh= ?");
            
            statement.setString(1, mat_veh);
            int eliminados = statement.executeUpdate();//Devuelve numero de filas afectadas.
            
            if (eliminados == 0) {
                return -1;
            }
            
            statement.execute();
            
            statement.close();
            con.closeConnection();
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    //Método recuperarVehiculos que recibe por parámetro la conexion con la base de datos y devuelve un array con la lista de vehiculos. 
    //realizamos un PerparedStatement al que le pasamos la consulta que muestra todos los vehículos de cada propietario. En esta consulta,
    //en WHERE igualamos los valores de la clave primaria idprop del prop al del vehículo (que es clave
    //foránea) para poder seleccionar los vehiculos que tiene cada propietario. 
    //posteriormente cerramos la conexion.
    public static ArrayList<String> recuperarTodosVeh(ConnectionDB con){
    
        try {
            
            ArrayList<String> lista_veh = new ArrayList<>();
            
            con.openConnection();
            PreparedStatement statement = con.getConnection().prepareStatement(
                    "SELECT  v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh, v.desc_veh, p.id_prop, p.nombre_prop, p.dni_prop "
                    + "FROM vehiculo v, propietario p "
                    + "WHERE v.id_prop =  p.id_prop");
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            
                lista_veh.add( "Matricula: " + rs.getString("mat_veh") + ". Marca: " + rs.getString("marca_veh") + " " + rs.getString("desc_veh") + 
                        ". Kilometros: " + rs.getString("kms_veh") + ". Precio: " + 
                        rs.getString("precio_veh") + "€"+ ". ID: " + rs.getString("id_prop")+". Propietario: "+ rs.getString("nombre_prop") + ". DNI: " + rs.getString("dni_prop"));
            }
            statement.close();
            
            con.closeConnection();
            return lista_veh;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
    
    }
    
    //Método recuperarVehiculos que recibe por parámetro la conexion con la base de datos y
    //la marca del vehículo y devuelve un array con la lista de vehiculos. 
    //realizamos un PerparedStatement al que le pasamos la consulta con el valor de la marca 
    //con el signo ?, que será intercambiado por los valores pasado por parametro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar). En esta consulta,
    //en WHERE igualamos los valores de la clave primaria idprop del prop al del vehículo (que es clave
    //foránea) para poder seleccionar los vehiculos del propietario con la marca pasada por parametro. 
    //posteriormente cerramos la conexion.
    public static ArrayList<String> recuperarVehMarca(ConnectionDB con, String marca_veh){
    
        try {
            
            ArrayList<String> lista_veh = new ArrayList<>();
            
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement(
                    "SELECT v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh, v.desc_veh, p.id_prop, p.nombre_prop, p.dni_prop "
                    + "FROM vehiculo v, propietario p "
                    + "WHERE p.id_prop = v.id_prop AND v.marca_veh = ?");
            
            statement.setString(1, marca_veh);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            
                lista_veh.add("Propietario: "+ rs.getString("nombre_prop") + ". Matricula: " + rs.getString("mat_veh") + ". Marca: " + 
                        rs.getString("marca_veh") + " " + rs.getString("desc_veh") + 
                        ". Kilometros: " + rs.getString("kms_veh") + ". Precio: " + 
                        rs.getString("precio_veh") + "€");
            }
            statement.close();
            con.closeConnection();
            return lista_veh;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
    
    }
    //Método recuperarVehiculos //No recibe parámetros (solo la coneción con la BBDD) y retorna una lista 
    //con la matrícula, marca, kilómetros y precio de cada vehículo.  
    //realizamos un PerparedStatement al que le pasamos la consulta para que selecciona todas las columnas de los vehículos.  
    //posteriormente cerramos la conexion.
    
    public static ArrayList<String> recuperarVehiculos(ConnectionDB con){
    
        try {
            
            ArrayList<String> lista_veh = new ArrayList<>();
            
            con.openConnection();
            PreparedStatement statement = con.getConnection().prepareStatement("SELECT v.mat_veh, v.marca_veh, v.desc_veh, v.kms_veh, v.precio_veh "
                    + "FROM vehiculos v");
            
           
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            
                lista_veh.add("Matricula: " + rs.getString("mat_veh") + "\nMarca: " + 
                        rs.getString("marca_veh") + " " + rs.getString("desc_veh") + 
                        "\nKilometros: " + rs.getString("kms_veh") + "\nPrecio: " + 
                        rs.getString("precio_veh") + "€");
            }
            statement.close();
            
            con.closeConnection();
            return lista_veh;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
         
    
    }
    
    
}
