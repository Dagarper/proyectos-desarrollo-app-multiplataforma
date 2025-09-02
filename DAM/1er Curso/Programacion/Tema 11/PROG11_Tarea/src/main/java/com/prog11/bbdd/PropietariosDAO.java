package com.prog11.bbdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PropietariosDAO {
    
    //Método insertarPropietario que recibe por parámetro la conexion con la base de datos,
    //el id de propietario el nombre del propietario y el DNI. 
    //realizamos un PerparedStatement al que le pasamos la consulta con los valores de estas variables 
    //con el signo ?, que será intercambiado por los valores pasado por parametro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar)
    //posteriormente cerramos la conexion. 
    
    public static int insertarPropietario(ConnectionDB con,int id_prop,String nombre_prop,String dni_prop){
    
        try {
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement("INSERT INTO propietario(id_prop, nombre_prop, dni_prop)"
                    + "VALUES (?,?,?)");
            
            statement.setInt(1, id_prop);
            statement.setString(2, nombre_prop);
            statement.setString(3, dni_prop);
            
            statement.executeUpdate();
            
            statement.close();
            
            con.closeConnection();
            return 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        
        return -1;
    
    }
    
    //Método recuperarVehiculos que recibe por parámetro la conexion con la base de datos y
    //el DNI del propietario y devuelve un array con la lista de vehiculos. 
    //realizamos un PerparedStatement al que le pasamos la consulta con el valor de DNI 
    //con el signo ?, que será intercambiado por los valores pasado por parametro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar). En esta consulta,
    //en WHERE igualamos los valores de la clave primaria idprop del prop al del vehículo (que es clave
    //foránea) para poder seleccionar los vehiculos del propietario con el dni pasado por parametro. 
    //posteriormente cerramos la conexion.
    public static ArrayList<String> recuperarVehiculos(ConnectionDB con, String DNI){
    
        ArrayList<String> lista_vehiculos = new ArrayList<>();
        try {
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement(
                    "SELECT p.nombre_prop, v.mat_veh, v.marca_veh, v.desc_veh, v.kms_veh, v.precio_veh, p.id_prop, p.nombre_prop, p.dni_prop "
                    + "FROM vehiculo v, propietario p "
                    + "WHERE v.id_prop =  p.id_prop "
                    + "AND p.dni_prop = ?");
            
            statement.setString(1, DNI);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
            
                lista_vehiculos.add("Matricula: " + rs.getString("mat_veh") + "\nMarca: " + 
                        rs.getString("marca_veh") + " " + rs.getString("desc_veh") + 
                        "\nKilometros: " + rs.getString("kms_veh") + "\nPrecio: " + 
                        rs.getString("precio_veh") + "€");
            }
            
            con.closeConnection();
            return lista_vehiculos;
        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Método eliminarProp que recibe por parámetro la conexion con la base de datos,
    //y el DNI del propietario a eliminar. 
    //realizamos un PerparedStatement al que le pasamos la consulta para elimirar las filas correspondientes
    //con los valores de esta variable con el signo ?, que será intercambiado por los valores pasado por parametro, a través del
    //statement.setTipoVariable(posiciondelacolumna, parametro a intercambiar)
    //posteriormente cerramos la conexion.
    
    static public int eliminarProp (ConnectionDB con, String dni_prop){
    
        try {
            con.openConnection();
            
            PreparedStatement statement = con.getConnection().prepareStatement("DELETE FROM propietario WHERE dni_prop = ?");
            
            statement.setString(1, dni_prop);
            
            int eliminados = statement.executeUpdate();//Devuelve numero de filas afectadas.
            
            statement.close();
            con.closeConnection();
            return eliminados;
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return 0;
    }
}
