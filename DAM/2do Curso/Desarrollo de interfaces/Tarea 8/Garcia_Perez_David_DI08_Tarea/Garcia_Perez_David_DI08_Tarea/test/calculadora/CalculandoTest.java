/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package calculadora;

import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author David
 */
public class CalculandoTest extends TestCase {

    public CalculandoTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of add method, of class Calculando.
     */
    public void testAdd() {
        Calculando c = new Calculando();
        assertEquals(0, c.add(0, 0), 0);
        assertEquals(5, c.add(-5, 10), 0);
        assertEquals(2.5, c.add(5, -2.5), 0);
        assertEquals(-5, c.add(-2.5, -2.5), 0);
    }

    /**
     * Test of subtract method, of class Calculando.
     */
    public void testSubtract() {
        Calculando c = new Calculando();
        assertEquals(0, c.subtract(0, 0), 0);
        assertEquals(5, c.subtract(0, -5), 0);
        assertEquals(7.5, c.subtract(10, 2.5), 0);
        assertEquals(-15, c.subtract(-10, 5), 0);
    }

    /**
     * Test of multiply method, of class Calculando.
     */
    public void testMultiply() {
        Calculando c = new Calculando();
        assertEquals(0, c.multiply(0, 0), 0);
        assertEquals(50, c.multiply(-10, -5), 0);
        assertEquals(7.5, c.multiply(3, 2.5), 0);
        assertEquals(-50, c.multiply(5, -10), 0);
    }

    @Test
    public void testDivide() {
        Calculando c = new Calculando();
        assertEquals(Double.POSITIVE_INFINITY, c.divide(1, 0), Double.POSITIVE_INFINITY);
        assertEquals(-5, c.divide(10, -2), 0);
        assertEquals(4, c.divide(10, 2.5), 0);
        assertEquals(-2.5, c.divide(-5, 2), 0);
    }

    public void testIntegracion() {
        Main main = new Main();
        assertEquals(5, main.pruebaIntegracion(), 0.0);
    }

    public void testRecuperacion() {
        Main main = new Main();
        try {
            main.pruebaRecuperacionEntradaString("dos", "3");
            fail("Se esperaba una IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Debe introducir un número", e.getMessage());
        }
    }

    public void testRecuperacionNulos() {
        Main main = new Main();
        try {
            main.pruebaRecuperacionEntradaString(null, "3");
            fail("Se esperaba una IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Debe introducir un número no nulo", e.getMessage());
        }
    }

    public void testRecuperacionVacios() {
        Main main = new Main();
        try {
            main.pruebaRecuperacionEntradaString("", "3");
            fail("Se esperaba una IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Debe introducir un número, el campo se encuentra vacío", e.getMessage());
        }
    }
    
    public void testCapacidadNumerica() {
    Calculando c = new Calculando();
    
    // Valor máximo positivo de Double
    assertEquals(Double.MAX_VALUE, c.add(Double.MAX_VALUE, 0), 0.0);
    
    // Suma de dos valores máximos (debería causar desbordamiento positivo)
    assertEquals(Double.POSITIVE_INFINITY, c.add(Double.MAX_VALUE, Double.MAX_VALUE), 0.0);
    
    // Valor mínimo positivo de Double
    assertEquals(Double.MIN_VALUE, c.add(Double.MIN_VALUE, 0), 0.0);
    
    // Suma de un número muy grande y uno muy pequeño
    assertEquals(1.0E308, c.add(1E308, 1E-16), 0.0);
    }
    
    public void testDesbordamiento() {
    Calculando c = new Calculando();
    
    // Multiplicación que excede Double.MAX_VALUE
    assertEquals(Double.POSITIVE_INFINITY, c.multiply(Double.MAX_VALUE, 2), 0.0);
    
    // Multiplicación que causa underflow (resultado cercano a cero)
    assertEquals(0.0, c.multiply(Double.MIN_VALUE, 0.1), 0.0);
}
    
    public void testEstres() {
    Calculando c = new Calculando();
    double resultado = 1000000.0;
    
    // Realizar 1 millón de divisiones sucesivas
    for (int i = 0; i < 1000000; i++) {
        resultado = c.divide(resultado, 2.0);
    }
    
    // Verificar que el resultado final sea correcto
    assertEquals(0, resultado, 1E-10);
}

}
