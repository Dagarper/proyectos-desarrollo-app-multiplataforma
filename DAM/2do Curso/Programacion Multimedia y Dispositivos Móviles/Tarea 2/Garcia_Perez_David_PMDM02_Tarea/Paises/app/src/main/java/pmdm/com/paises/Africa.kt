package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

/**
 * Actividad que representa la sección de África en la aplicación.
 * Permite seleccionar países africanos de una lista y navegar a una pantalla
 * para mostrar la información de los países seleccionados.
 */
class Africa: AppCompatActivity() {

    /**
     * Método que se ejecuta al crear la actividad. Configura la interfaz y los comportamientos
     * relacionados con la selección de países y la navegación.
     *
     * @param savedInstanceState Estado de la actividad guardado previamente (si existe).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.africa)

        // Configuración del botón "Volver" para regresar a la pantalla anterior
        val btnVolver = findViewById<Button>(R.id.btnVolverAf)
        btnVolver.setOnClickListener {
            finish()// Finaliza la actividad actual
        }

        // Referencias a los CheckBoxes para la selección de países
        val ckBoxMarruecos = findViewById<CheckBox>(R.id.ckBoxMarruecos)
        val chBoxKenia = findViewById<CheckBox>(R.id.ckBoxKenia)
        val ckBoxSudafrica = findViewById<CheckBox>(R.id.ckBoxSudafrica)

        // Botón "Ver Países" para confirmar la selección
        val btnVerPaises = findViewById<Button>(R.id.btnVerPaisesAf)

        // Listas para almacenar los países seleccionados y sus imágenes correspondientes
        val seleccion = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()

        // Configuración del botón "Ver Países"
        btnVerPaises.setOnClickListener {

            // Limpia las listas antes de agregar las selecciones actuales
            seleccion.clear()
            imagenes.clear()

            // Verifica si cada CheckBox está seleccionado y agrega los datos correspondientes
            if (ckBoxMarruecos.isChecked) {

                seleccion.add("Marruecos")
                imagenes.add(R.drawable.marruecos)// ID de la imagen asociada
            }

            if (chBoxKenia.isChecked) {

                seleccion.add("Kenia")
                imagenes.add(R.drawable.kenia)
            }

            if (ckBoxSudafrica.isChecked) {

                seleccion.add("Sudafrica")
                imagenes.add(R.drawable.sudafrica)
            }

            // Muestra un mensaje si no se ha seleccionado ningún país
            if (seleccion.isEmpty()) {

                Toast.makeText(this, "No se ha seleccionado ningun país.", Toast.LENGTH_SHORT)
                    .show()
            } else {

                // Si hay selecciones, navega a la actividad "Paises" pasando los datos
                val intent = Intent(this, Paises::class.java)
                intent.putStringArrayListExtra("paises", ArrayList(seleccion))// Lista de países
                intent.putIntegerArrayListExtra("imagenes", ArrayList(imagenes))// Lista de imágenes
                startActivity(intent)// Inicia la nueva actividad
            }
        }
    }
}