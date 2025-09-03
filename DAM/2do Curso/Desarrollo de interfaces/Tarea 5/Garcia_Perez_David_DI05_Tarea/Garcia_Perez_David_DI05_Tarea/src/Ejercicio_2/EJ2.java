package Ejercicio_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class EJ2 {
    
    public static void main (String[] args){
    
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();

        generarFactura(idCliente);
    }

    private static void generarFactura(int idCliente) {
        
        Connection conn = null;

        try {
            // Conectar a MySQL usando XAMPP
            String url = "jdbc:mysql://localhost:3306/fabrica";
            String usuario = "root"; 
            String clave = ""; 
            conn = DriverManager.getConnection(url, usuario, clave);

            // Cargar el archivo Jasper compilado
            String reportePath = "C:/Users/David/Documents/NetBeansProjects/Garcia_Perez_David_DI05_Tarea/src/factura.jasper";
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(reportePath);

            // Parámetro para filtrar por ID_Cliente
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("ID_Cliente", idCliente);

            // Llenar el informe con los datos
            JasperPrint print = JasperFillManager.fillReport(reporte, parametros, conn);

            // Mostrar el informe en un visor de JasperReports
            JasperViewer.viewReport(print, false);

            // Exportar el informe a PDF
            String pdfPath = "Factura_Cliente_" + idCliente + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, pdfPath);

            System.out.println("Informe generado: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
                
    }
}
