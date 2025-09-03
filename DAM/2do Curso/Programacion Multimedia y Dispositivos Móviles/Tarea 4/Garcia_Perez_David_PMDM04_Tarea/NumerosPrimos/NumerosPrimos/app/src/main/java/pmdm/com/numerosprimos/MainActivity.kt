package pmdm.com.numerosprimos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// La clase MainActivity hereda de AppCompatActivity y actúa como la actividad principal de la aplicación
class MainActivity : AppCompatActivity() {

    // El método onCreate se ejecuta cuando se crea la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Asocia el layout XML a esta actividad

        // Referencias a los elementos del layout usando sus IDs
        val etPosicion = findViewById<EditText>(R.id.etPosicion) // Campo de entrada del usuario
        val btnCalcular = findViewById<Button>(R.id.btnCalcular) // Botón para iniciar el cálculo
        val tvResultado = findViewById<TextView>(R.id.Resultado) // Campo de texto para mostrar el resultado

        // Configura un listener para el botón "Calcular"
        btnCalcular.setOnClickListener {
            // Obtiene el texto ingresado por el usuario
            val input = etPosicion.text.toString()

            // Verifica si el campo está vacío
            if (input.isBlank()) {
                Toast.makeText(
                    this,
                    getString(R.string.error_invalid_input),
                    Toast.LENGTH_SHORT
                ).show() // Muestra un mensaje de error usando un recurso del archivo strings.xml
                return@setOnClickListener // Sale de la función para evitar continuar
            }

            // Intenta convertir el texto a un número entero
            val posicion = input.toIntOrNull()
            if (posicion == null || posicion <= 0) {
                Toast.makeText(
                    this,
                    getString(R.string.error_invalid_input),
                    Toast.LENGTH_SHORT
                ).show() // Muestra un error si el número es inválido
                return@setOnClickListener // Sale de la función
            }

            try {
                // Llama al método getNthPrime para obtener el enésimo número primo
                val primo = PrimeCalculator.getNthPrime(posicion)

                // Actualiza el TextView con el resultado, usando un recurso string con formato
                tvResultado.text = getString(R.string.resultado, posicion, primo)
            } catch (e: Exception) {
                // Captura cualquier excepción inesperada y muestra un mensaje de error
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}