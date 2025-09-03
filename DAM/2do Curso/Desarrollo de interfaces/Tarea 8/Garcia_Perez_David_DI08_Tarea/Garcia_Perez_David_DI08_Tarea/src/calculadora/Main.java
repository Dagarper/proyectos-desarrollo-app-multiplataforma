/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author usuario
 */
public class Main {

    public static void main(String[] args) {

        pruebaRendimiento();
    }

    public double pruebaIntegracion() {
        Calculando calculando = new Calculando();
        return calculando.divide(10, 2);
    }

    public double pruebaRecuperacionEntradaString(String numero1, String numero2) throws IllegalArgumentException {

        if (numero1 == null | numero2 == null) {
            throw new IllegalArgumentException("Debe introducir un número no nulo");
        }
        if (numero1.isEmpty() | numero2.isEmpty()) {
            throw new IllegalArgumentException("Debe introducir un número, el campo se encuentra vacío");
        }

        Calculando calculando = new Calculando();
        Double resultado = 0d;

        try {
            double num1 = Double.parseDouble(numero1);
            double num2 = Double.parseDouble(numero2);
            return calculando.add(num1, num2);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Debe introducir un número");
        }
    }
    
    public static void pruebaRendimiento(){
    
    double min = 0;
    double max = 1000;
    double maxAleatorio = getRandomNumber(min,max);
    double minAleatorio = getRandomNumber(min,max);
    
    Calculando c = new Calculando();
    
    
        for (int i = 0; i < 1000000; i++) {
            System.out.println("-----------Operación " + i + "------------------");
            c.add(minAleatorio, maxAleatorio);
            c.subtract(minAleatorio, maxAleatorio);
            c.multiply(minAleatorio, maxAleatorio);
            c.divide(minAleatorio, maxAleatorio);
        }
    }
    
    public static double getRandomNumber(double min, double max){
        return ThreadLocalRandom.current().nextDouble(min, max+1);
    }
}
