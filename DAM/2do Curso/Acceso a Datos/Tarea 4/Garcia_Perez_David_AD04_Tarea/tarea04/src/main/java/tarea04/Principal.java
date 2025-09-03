package tarea04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import clasesDB.Departamentos;
import clasesDB.Empleados;

import java.util.List;
import java.util.Scanner;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);
    private static final SessionFactory sessionFactory;

    static {
        try {
            
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Error al inicializar SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        Principal main = new Principal();
        main.menu();

        //Cerrar la sesión de Hibernate al salir del programa
        sessionFactory.close();
    }

    private void menu() {
        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Almacenar un empleado");
            System.out.println("2. Borrar un empleado");
            System.out.println("3. Modificar el departamento de un empleado");
            System.out.println("4. Listar empleados");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después del número

            switch (opcion) {
                case 1:
                    almacenarEmpleado();
                    break;
                case 2:
                    borrarEmpleado();
                    break;
                case 3:
                    modificarDepartamento();
                    break;
                case 4:
                	listarEmpleados();
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
    }

    private void almacenarEmpleado() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            System.out.println("Ingrese nombre del empleado:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese primer apellido del empleado:");
            String apellido1 = scanner.nextLine();

            System.out.println("Ingrese segundo apellido del empleado:");
            String apellido2 = scanner.nextLine();

            System.out.println("Ingrese nombre del departamento:");
            String nombreDepartamento = scanner.nextLine();
            
            Query<Departamentos> departamentoQuery = session.createQuery("FROM Departamentos WHERE dnombre = :nombre", Departamentos.class);
            departamentoQuery.setParameter("nombre", nombreDepartamento);
            Departamentos departamento = departamentoQuery.uniqueResult();
            
            if (departamento == null) {
                // El departamento no existe, así que lo almacenamos
                departamento = new Departamentos();
                departamento.setDnombre(nombreDepartamento);
                session.save(departamento);
                System.out.println("Departamento almacenado con éxito.");
            }
            
            Query<Long> empleadoExistQuery = session.createQuery("SELECT COUNT(*) FROM Empleados WHERE nombre = :nombre AND apellido1 = :apellido1 AND apellido2 = :apellido2", Long.class);
            empleadoExistQuery.setParameter("nombre", nombre);
            empleadoExistQuery.setParameter("apellido1", apellido1);
            empleadoExistQuery.setParameter("apellido2", apellido2);
            Long count = empleadoExistQuery.uniqueResult();
            
            if (count == 0) {
                // No existe el empleado, así que lo almacenamos
                Empleados empleado = new Empleados();
                empleado.setNombre(nombre);
                empleado.setApellido1(apellido1);
                empleado.setApellido2(apellido2);
                empleado.setDepartamentos(departamento);
                session.save(empleado);
                System.out.println("Empleado almacenado con éxito.");
            } else {
                System.out.println("Ya existe un empleado con el mismo nombre y apellidos.");
            }
            
            tx.commit();
            System.out.println("Empleado almacenado con éxito.");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("No se pudo almacenar el empleado. Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    private void borrarEmpleado() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            System.out.println("Ingrese nombre del empleado:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese primer apellido del empleado:");
            String apellido1 = scanner.nextLine();

            System.out.println("Ingrese segundo apellido del empleado:");
            String apellido2 = scanner.nextLine();

            // Buscar al empleado por nombre y apellidos
            Query<Empleados> empleadoQuery = session.createQuery("FROM Empleados WHERE nombre = :nombre AND apellido1 = :apellido1 AND apellido2 = :apellido2", Empleados.class);
            empleadoQuery.setParameter("nombre", nombre);
            empleadoQuery.setParameter("apellido1", apellido1);
            empleadoQuery.setParameter("apellido2", apellido2);
            Empleados empleado = empleadoQuery.uniqueResult();

            if (empleado != null) {
                // Obtener el departamento del empleado
                Departamentos departamento = empleado.getDepartamentos();

                // Verificar si el departamento solo tiene al empleado que estamos a punto de eliminar
                if (departamento.getEmpleadoses().size() == 1) {
                    // Si es el único empleado, eliminamos el departamento
                    session.delete(departamento);
                    System.out.println("Departamento eliminado ya que no tiene más empleados.");
                }

                // Eliminar al empleado
                session.delete(empleado);
                System.out.println("Empleado eliminado con éxito.");
            
            } else {
                System.out.println("No se encontró el empleado con los datos proporcionados.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("No se pudo eliminar el empleado. Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    private void modificarDepartamento() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            System.out.println("Ingrese nombre del empleado:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese primer apellido del empleado:");
            String apellido1 = scanner.nextLine();

            System.out.println("Ingrese segundo apellido del empleado:");
            String apellido2 = scanner.nextLine();

            // Buscar al empleado por nombre y apellidos
            Query<Empleados> empleadoQuery = session.createQuery("FROM Empleados WHERE nombre = :nombre AND apellido1 = :apellido1 AND apellido2 = :apellido2", Empleados.class);
            empleadoQuery.setParameter("nombre", nombre);
            empleadoQuery.setParameter("apellido1", apellido1);
            empleadoQuery.setParameter("apellido2", apellido2);
            Empleados empleado = empleadoQuery.uniqueResult();

            if (empleado != null) {
                // Imprime el departamento actual del empleado
                System.out.println("Departamento actual del empleado: " + empleado.getDepartamentos().getDnombre());

                // Pide al usuario que ingrese el nuevo nombre del departamento
                System.out.println("Ingrese el nuevo nombre del departamento:");
                String nuevoDepartamento = scanner.nextLine();

                // Buscar el nuevo departamento en la base de datos
                Query<Departamentos> departamentoQuery = session.createQuery("FROM Departamentos WHERE dnombre = :nombre", Departamentos.class);
                departamentoQuery.setParameter("nombre", nuevoDepartamento);
                Departamentos nuevoDepartamentoObj = departamentoQuery.uniqueResult();

                if (nuevoDepartamentoObj == null) {
                    // Si el nuevo departamento no existe, crea uno nuevo
                    nuevoDepartamentoObj = new Departamentos(nuevoDepartamento, null);
                    session.save(nuevoDepartamentoObj);
                }

                // Actualiza el departamento del empleado
                empleado.setDepartamentos(nuevoDepartamentoObj);
                session.update(empleado);

                System.out.println("Departamento del empleado modificado con éxito.");
            } else {
                System.out.println("No se encontró el empleado con los datos proporcionados.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("No se pudo modificar el departamento del empleado. Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    private void listarEmpleados() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Consulta HQL para obtener todos los empleados con detalles del departamento
            List<Object[]> results = session.createQuery(
                    "SELECT e.nombre, e.apellido1, e.apellido2, d.dnombre " +
                            "FROM Empleados e " +
                            "JOIN Departamentos d ON e.departamentos = d.deptNo", Object[].class).getResultList();

            if (results.isEmpty()) {
                System.out.println("No hay empleados registrados.");
            } else {
                System.out.println("Listado de empleados:");
                for (Object[] result : results) {
                    String nombre = (String) result[0];
                    String apellido1 = (String) result[1];
                    String apellido2 = (String) result[2];
                    String nombreDepartamento = (String) result[3];

                    System.out.println("Nombre: " + nombre +
                            ", Apellido1: " + apellido1 +
                            ", Apellido2: " + apellido2 +
                            ", Departamento: " + nombreDepartamento);
                }
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            System.out.println("Error al listar empleados. Error: " + e.getMessage());
        } finally {
            session.close();
        }
    }

	
}
