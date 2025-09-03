package com.mycompany.garcia_perez_david_ad03_tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Garcia_Perez_David_AD03_Tarea {
    
    private static final String URL = "jdbc:mysql://localhost:3306/empresa";
    private static final String user = "root";
    private static final String password = "root";
    
    public static void main (String[] args){
    
    ejecutarMenu();
    
    }
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, user, password);
    }
    
     private static void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarOpciones();
            System.out.print("Ingrese su elección (0 para salir): ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    almacenarEmpleadoDesdeConsola(scanner);
                    break;
                case 2:
                    borrarEmpleadoDesdeConsola(scanner);
                    break;
                case 3:
                    modificarDepartamentoDesdeConsola(scanner);
                    break;
                case 4:
                    listarEmpleados();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarOpciones() {
        System.out.println("----- Menú Principal -----");
        System.out.println("1. Almacenar un empleado");
        System.out.println("2. Borrar un empleado");
        System.out.println("3. Modificar el departamento de un empleado");
        System.out.println("4. Listar empleados");
        System.out.println("0. Salir");
    }

    private static void almacenarEmpleadoDesdeConsola(Scanner scanner) {
        System.out.println("Ingrese los datos del empleado:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido1: ");
        String apellido1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String apellido2 = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();

        try (Connection connection = getConnection()) {
        almacenarEmpleado(connection, nombre, apellido1, apellido2, departamento);
    } catch (SQLException e) {
        System.out.println("Error de conexión a la base de datos: " + e.getMessage());
    }
    }

    private static void borrarEmpleadoDesdeConsola(Scanner scanner) {
        System.out.println("Ingrese los datos del empleado a borrar:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido1: ");
        String apellido1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String apellido2 = scanner.nextLine();

        int resultado = borrarEmpleado(nombre, apellido1, apellido2);
        mostrarResultado(resultado, "Empleado borrado con éxito", "Error al borrar empleado");
    }

    private static void modificarDepartamentoDesdeConsola(Scanner scanner) {
        System.out.println("Ingrese los datos del empleado y el nuevo departamento:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido1: ");
        String apellido1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String apellido2 = scanner.nextLine();
        System.out.print("Nuevo Departamento: ");
        String nuevoDepartamento = scanner.nextLine();

        int resultado = modificarDepartamento(nombre, apellido1, apellido2, nuevoDepartamento);
        mostrarResultado(resultado, "Departamento modificado con éxito", "Error al modificar departamento del empleado");
    }

    private static void mostrarResultado(int resultado, String mensajeExito, String mensajeError) {
        if (resultado == 1) {
            System.out.println(mensajeExito + " sin haberse almacenado el departamento en la tabla correspondiente.");
        } else if (resultado == 2) {
            System.out.println(mensajeExito + " habiéndose almacenado el departamento en la tabla correspondiente.");
        } else if (resultado == 0) {
            System.out.println(mensajeError);
        } else if (resultado == -1) {
            System.out.println("No se pudo realizar la operación. El empleado no existe.");
        }
    }
   
    
    private static boolean existeDepartamento(Connection connection, String departamento) throws SQLException {
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, departamento);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        }
    }
    
    private static boolean existeEmpleado(Connection connection, String nombre, String apellido1, String apellido2) throws SQLException{
         String sql = "SELECT * FROM empleados WHERE nombre = ? AND apellido1 = ? AND apellido2 = ?";
         try(PreparedStatement statement = connection.prepareStatement(sql)){
             statement.setString(1, nombre);
             statement.setString(2, apellido1);
             statement.setString(3, apellido2);
             try(ResultSet resultSet = statement.executeQuery()){
                 return resultSet.next();
            }
        }
    }
     
     
    private static void almacenarDepartamento(Connection connection, String departamento) throws SQLException {
        String sql = "INSERT INTO departamentos (dnombre) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, departamento);
            statement.executeUpdate();
        }
    }
      
    private static void almacenarEmpleadoEnBaseDeDatos(Connection connection, String nombre, String apellido1,
            String apellido2, String departamento) throws SQLException {
        String sql = "INSERT INTO empleados (nombre, apellido1, apellido2, departamento) " +
                "VALUES (?, ?, ?, (SELECT dept_no FROM departamentos WHERE dnombre = ?))";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, apellido1);
            statement.setString(3, apellido2);
            statement.setString(4, departamento);
            statement.executeUpdate();
        }
    }
     
    private static void almacenarEmpleado(Connection connection, String nombre, String apellido1,
            String apellido2, String departamento) throws SQLException {
        try {
            connection.setAutoCommit(false);

            // Verificar si el departamento existe
            if (!existeDepartamento(connection, departamento)) {
                almacenarDepartamento(connection, departamento);
                connection.commit();
                System.out.println("Departamento almacenado con éxito.");
            }

            // Verificar si el empleado ya existe
            if (existeEmpleado(connection, nombre, apellido1, apellido2)) {
                System.out.println("El empleado ya existe.");
                connection.rollback();
            } else {
                // Almacenar el empleado
                almacenarEmpleadoEnBaseDeDatos(connection, nombre, apellido1, apellido2, departamento);
                connection.commit();
                System.out.println("Empleado almacenado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("Error al almacenar empleado: " + e.getMessage());
            connection.rollback();
        }
    }
    
    private static int borrarEmpleado(String nombre, String apellido1, String apellido2) {
    try (Connection connection = getConnection()) {
        connection.setAutoCommit(false);

        // Verificar si el empleado existe
        if (!existeEmpleado(connection, nombre, apellido1, apellido2)) {
            System.out.println("El empleado no existe.");
            return 0;
        }

        // Obtener el ID del departamento antes de borrar el empleado
        int idDepartamento = obtenerIdDepartamento(connection, nombre, apellido1, apellido2);

        // Borrar el empleado
        borrarEmpleadoEnBaseDeDatos(connection, nombre, apellido1, apellido2);

        // Verificar si el departamento tiene más empleados
        if (!tieneMasEmpleadosEnDepartamento(connection, idDepartamento)) {
            // Borrar el departamento si no tiene más empleados
            borrarDepartamento(connection, idDepartamento);
            connection.commit();
            return 2;
        }

        connection.commit();
        return 1;

    } catch (SQLException e) {
        System.out.println("Error al borrar empleado: " + e.getMessage());
        return 0;
    }
}

// Método para obtener el ID del departamento de un empleado
private static int obtenerIdDepartamento(Connection connection, String nombre, String apellido1, String apellido2)
        throws SQLException {
    String sql = "SELECT departamento FROM empleados WHERE nombre = ? AND apellido1 = ? AND apellido2 = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nombre);
        statement.setString(2, apellido1);
        statement.setString(3, apellido2);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("departamento");
            } else {
                return -1; // Valor no válido, indicando que no se encontró el empleado
            }
        }
    }
}

// Método para borrar un empleado de la base de datos
private static void borrarEmpleadoEnBaseDeDatos(Connection connection, String nombre, String apellido1,
        String apellido2) throws SQLException {
    String sql = "DELETE FROM empleados WHERE nombre = ? AND apellido1 = ? AND apellido2 = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nombre);
        statement.setString(2, apellido1);
        statement.setString(3, apellido2);
        statement.executeUpdate();
    }
}

// Método para verificar si un departamento tiene más empleados
private static boolean tieneMasEmpleadosEnDepartamento(Connection connection, int idDepartamento) throws SQLException {
    String sql = "SELECT COUNT(*) AS numEmpleados FROM empleados WHERE departamento = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, idDepartamento);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("numEmpleados") > 0;
            } else {
                return false; // Valor predeterminado si no se encuentra el departamento
            }
        }
    }
}

// Método para borrar un departamento de la base de datos
private static void borrarDepartamento(Connection connection, int idDepartamento) throws SQLException {
    String sql = "DELETE FROM departamentos WHERE dept_no = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, idDepartamento);
        statement.executeUpdate();
    }
}
     
private static int modificarDepartamento(String nombre, String apellido1, String apellido2, String nuevoDepartamento) {
    try (Connection connection = getConnection()) {
        connection.setAutoCommit(false);

        // Verificar si el empleado existe
        if (!existeEmpleado(connection, nombre, apellido1, apellido2)) {
            System.out.println("El empleado no existe.");
            return -1;
        }

        // Verificar si el nuevo departamento existe, si no existe, almacenarlo
        if (!existeDepartamento(connection, nuevoDepartamento)) {
            almacenarDepartamento(connection, nuevoDepartamento);
        }

        // Obtener el ID del nuevo departamento
        int idNuevoDepartamento = obtenerIdDepartamentoxNombre(connection, nuevoDepartamento);

        // Obtener el ID del actual departamento del empleado
        int idDepartamentoActual = obtenerIdDepartamento(connection, nombre, apellido1, apellido2);

        // Verificar si el empleado ya pertenece al nuevo departamento
        if (idDepartamentoActual == idNuevoDepartamento) {
            System.out.println("El empleado ya pertenece al nuevo departamento.");
            connection.rollback();
            return 0;
        }

        // Modificar el departamento del empleado
        modificarDepartamentoEnBaseDeDatos(connection, nombre, apellido1, apellido2, idNuevoDepartamento);
        connection.commit();

        // Retornar el valor correspondiente
        return (existeDepartamentoEnEmpleado(connection, nombre, apellido1, apellido2, idNuevoDepartamento)) ? 2 : 1;

    } catch (SQLException e) {
        System.out.println("Error al modificar el departamento del empleado: " + e.getMessage());
        return 0;
    }
}



// Método para obtener el ID del departamento por nombre
private static int obtenerIdDepartamentoxNombre(Connection connection, String nombreDepartamento) throws SQLException {
    String sql = "SELECT dept_no FROM departamentos WHERE dnombre = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nombreDepartamento);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("dept_no");
            } else {
                return -1; // Valor no válido, indicando que no se encontró el departamento
            }
        }
    }
}

// Método para verificar si un empleado ya pertenece a un departamento
private static boolean existeDepartamentoEnEmpleado(Connection connection, String nombre, String apellido1, String apellido2,
        int idDepartamento) throws SQLException {
    String sql = "SELECT COUNT(*) AS numEmpleados FROM empleados WHERE nombre = ? AND apellido1 = ? AND apellido2 = ? " +
            "AND departamento = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, nombre);
        statement.setString(2, apellido1);
        statement.setString(3, apellido2);
        statement.setInt(4, idDepartamento);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("numEmpleados") > 0;
            } else {
                return false; // Valor predeterminado si no se encuentra el empleado
            }
        }
    }
}

// Método para modificar el departamento de un empleado en la base de datos
private static void modificarDepartamentoEnBaseDeDatos(Connection connection, String nombre, String apellido1,
        String apellido2, int idNuevoDepartamento) throws SQLException {
    String sql = "UPDATE empleados SET departamento = ? WHERE nombre = ? AND apellido1 = ? AND apellido2 = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, idNuevoDepartamento);
        statement.setString(2, nombre);
        statement.setString(3, apellido1);
        statement.setString(4, apellido2);
        statement.executeUpdate();
    }
}

private static void listarEmpleados() {
    try (Connection connection = getConnection()) {
        String sql = "SELECT e.nombre, e.apellido1, e.apellido2, d.dnombre " +
                     "FROM empleados e INNER JOIN departamentos d ON e.departamento = d.dept_no";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("Listado de empleados:");
            System.out.printf("%-15s %-15s %-15s %-15s%n", "Nombre", "Apellido1", "Apellido2", "Departamento");
            System.out.println("----------------------------------------------------");

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido1 = resultSet.getString("apellido1");
                String apellido2 = resultSet.getString("apellido2");
                String departamento = resultSet.getString("dnombre");

                System.out.printf("%-15s %-15s %-15s %-15s%n", nombre, apellido1, apellido2, departamento);
            }
        }

    } catch (SQLException e) {
        System.out.println("Error al listar empleados: " + e.getMessage());
    }
}
}

