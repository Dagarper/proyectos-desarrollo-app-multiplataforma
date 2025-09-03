package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Clase principal de la aplicación que actúa como la pantalla inicial del proyecto.
 * Presenta una lista de continentes y botones adicionales para acceder a instrucciones, créditos
 * o salir de la aplicación.
 */

class MainActivity : AppCompatActivity() {

    /**
     * Método que se ejecuta al crear la actividad. Configura los elementos visuales y sus comportamientos.
     *
     * @param savedInstanceState Estado de la actividad guardado previamente (si existe).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()// Activa la compatibilidad con bordes en la interfaz.
        setContentView(R.layout.activity_main)

        // Inicialización del adaptador de la lista
        val arrayAdapter: ArrayAdapter<*>
        val paises = arrayOf("África", "América", "Asia", "Europa", "Oceanía")// Lista de continentes
        val listPaises = findViewById<ListView>(R.id.listPaises)
        var itemsAdapter =
            ArrayAdapter<String>(MainActivity@ this, android.R.layout.simple_list_item_1, paises)
        listPaises.adapter = itemsAdapter

        // Configuración del comportamiento al hacer clic en un elemento de la lista
        listPaises.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    // Abrir Africa al seleccionar "África" en la lista
                    val intent = Intent(this, Africa::class.java)
                    startActivity(intent)
                }

                1-> {
                    // Abrir América al seleccionar "América" en la lista
                    val intent = Intent(this, America::class.java)
                    startActivity(intent)


                }

                2-> {
                    // Abrir Asia al seleccionar "Asia" en la lista
                    val intent = Intent(this, Asia::class.java)
                    startActivity(intent)


                }

                3-> {
                    // Abrir Europa al seleccionar "Europa" en la lista
                    val intent = Intent(this, Europa::class.java)
                    startActivity(intent)


                }

                4-> {
                    // Abrir Oceanía al seleccionar "Oceanía" en la lista
                    val intent = Intent(this, Oceania::class.java)
                    startActivity(intent)


                }

            }

        }

        // Botón para abrir los créditos
        val btnCreditos = findViewById<Button>(R.id.btnCreditos)
        btnCreditos.setOnClickListener {
            val intent = Intent(this, Creditos::class.java)
            startActivity(intent)
        }

        // Botón para abrir las instrucciones
        val btnInstrucciones = findViewById<Button>(R.id.btnInstrucciones)
        btnInstrucciones.setOnClickListener {
            val intent = Intent(this, Instrucciones::class.java)
            startActivity(intent)
        }

        // Botón para cerrar la aplicación
        val btnTerminar = findViewById<Button>(R.id.btnTerminar)
        btnTerminar.setOnClickListener {
            finish()// Finaliza la actividad actual
        }
    }
}
