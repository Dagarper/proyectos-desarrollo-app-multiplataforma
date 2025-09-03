package pmdm.com.paises

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


/**
 * Actividad que muestra los créditos de la aplicación.
 * Incluye un botón para regresar a la pantalla anterior.
 */
class Creditos: AppCompatActivity() {

    /**
     * Método que se ejecuta al crear la actividad. Configura la interfaz y los comportamientos.
     *
     * @param savedInstanceState Estado de la actividad guardado previamente (si existe).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creditos)
        // Botón para volver a la actividad anterior
        val btnVolverCreditos = findViewById<Button>(R.id.btnVolverCred)

        btnVolverCreditos.setOnClickListener {
            finish()// Finaliza la actividad actual y regresa a la anterior
        }
    }
}