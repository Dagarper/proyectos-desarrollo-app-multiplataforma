package pmdm.com.numerosprimos

// Objeto Singleton para calcular números primos
object PrimeCalculator {
    // Lista mutable que almacena los números primos calculados. Inicialmente contiene el primer primo (2).
    private val primos = mutableListOf(2)

    /**
     * Método para obtener el enésimo número primo.
     * @param n Posición del número primo a calcular (debe ser mayor que 0).
     * @return El número primo en la posición n.
     * @throws IllegalArgumentException Si n es menor o igual a 0.
     */
    fun getNthPrime(n: Int): Int {
        if (n <= 0) throw IllegalArgumentException("N debe ser mayor que 0.") // Validación de entrada

        // Variable que comienza a probar números para determinar si son primos.
        var prueba = primos.last() + 1 // Comienza después del último primo en la lista

        // Mientras no tengamos suficientes primos, sigue calculando
        while (primos.size < n) {
            if (esPrimo(prueba)) { // Si el número es primo
                primos.add(prueba) // Lo agrega a la lista de primos
            }
            prueba++ // Incrementa el número a probar
        }
        return primos[n - 1] // Devuelve el primo en la posición n (índice ajustado)
    }

    /**
     * Método privado para determinar si un número es primo.
     * @param numero Número a verificar.
     * @return `true` si el número es primo, `false` de lo contrario.
     */
    private fun esPrimo(numero: Int): Boolean {
        if (numero < 2) return false // Los números menores a 2 no son primos

        // Verifica divisores usando los primos previamente calculados
        for (prime in primos) {
            if (prime * prime > numero) break // Optimización: detiene el bucle si el cuadrado del primo es mayor
            if (numero % prime == 0) return false // Si el número es divisible por un primo, no es primo
        }
        return true // Si no se encontraron divisores, el número es primo
    }
}