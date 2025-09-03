package pmdm.com.paises

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Actividad que muestra las instrucciones de uso de la aplicación.
 * Proporciona un botón para volver a la pantalla anterior.
 */

class Instrucciones: AppCompatActivity() {

    /**
     * Método que se ejecuta al crear la actividad. Configura la interfaz y los comportamientos.
     *
     * @param savedInstanceState Estado de la actividad guardado previamente (si existe).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instrucciones)
        // Botón para volver a la actividad anterior
        val btnVolverIntrucciones = findViewById<Button>(R.id.btnVolverInst)

        btnVolverIntrucciones.setOnClickListener {
            finish()// Finaliza la actividad actual y regresa a la anterior
        }
    }
}