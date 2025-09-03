
package PruebaMatriculaBean;

import Alumno.MatriculaBean;
import Alumno.MatriculaBean.Matricula;
import Alumno.MatriculaBean.MatriculaModoListener;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        
       
            MatriculaBean matriculasBean = new MatriculaBean();
            
            
            matriculasBean.addMatriculaModoListener(new MatriculaModoListener(){
                
                public void cambiarModo(String modo){
                    
                    if (modo.equals("todos")) {
                        System.out.println("Modo de listado: Todos los alumnos");
                    }else if(modo.equals("DNI")){
                        System.out.println("Modo de listado: Matriculas por DNI");
                    }
                }
            });
          
         try {    
            
             //Listar todas las matriculas:
             matriculasBean.recargarMatriculas();
             System.out.println("\nListado completo de matrículas:");
            for (int i = 0; i < matriculasBean.getMatriculas().size(); i++) {
                Matricula m = matriculasBean.getMatriculas().get(i);
                System.out.println("DNI: " + m.getDNI() + ", Módulo: " + m.getNombreModulo() + ", Curso: " + m.getCurso() + ", Nota: " + m.getNota());
            }
             //Seleccionar la matricula de la fila 2:
             matriculasBean.seleccionarFila(2);
             System.out.println("\nMatricula seleccionada:");
             System.out.println("DNI: " + matriculasBean.getDNI());
             System.out.println("Modulo: " + matriculasBean.getNombreModulo());
             System.out.println("Curso: " + matriculasBean.getCurso());
             System.out.println("Nota: " + matriculasBean.getNota());
             System.out.println("");
            
            //Listar matrículas de un alumno:
           matriculasBean.recargarDNI("12345678A");
           System.out.println("\nListado de matriculas del alumno con DNI: 12345678A");
            for (int i = 0; i < matriculasBean.getMatriculas().size(); i++) {
                Matricula m = matriculasBean.getMatriculas().get(i);
                System.out.println("DNI: " + m.getDNI() + ", Módulo: " + m.getNombreModulo() + ", Curso: " + m.getCurso() + ", Nota: " + m.getNota());
            }
            
            //Añadir nueva matricula
            matriculasBean.setDNI("98765432A");
            matriculasBean.setNombreModulo("Geografia");
            matriculasBean.setCurso("24-25");
            matriculasBean.setNota(9.5);
            matriculasBean.addMatricula();
           
            //Volver a cargar todas las matrículas para ver si se ha añadido la nueva
            matriculasBean.recargarMatriculas();  // Recarga todas las matrículas
            
            //Listar todas las matrículas para comprobar que se ha añadido
             matriculasBean.seleccionarFila(matriculasBean.getMatriculas().size()-1);// Seleccionar la última matrícula añadida
             System.out.println("\nÚltima matrícula añadida:");
             System.out.println("DNI: " + matriculasBean.getDNI());
             System.out.println("Modulo: " + matriculasBean.getNombreModulo());
             System.out.println("Curso: " + matriculasBean.getCurso());
             System.out.println("Nota: " + matriculasBean.getNota());
             System.out.println("");
            
            
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
}
