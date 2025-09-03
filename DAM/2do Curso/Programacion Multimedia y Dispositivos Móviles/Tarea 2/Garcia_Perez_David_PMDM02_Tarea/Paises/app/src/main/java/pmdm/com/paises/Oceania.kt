package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

/**
 * Clase que representa la actividad de selección de países en Oceanía.
 * Los usuarios pueden seleccionar uno o varios países de Oceania y, posteriormente,
 * ver mapas representativos de los países seleccionados.
 */
class Oceania: AppCompatActivity() {

    /**
     * Método que se ejecuta cuando se crea la actividad.
     * Configura el layout, inicializa los elementos de la interfaz y define el comportamiento
     * de los botones.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.oceania)

        // Botón para volver a la actividad anterior
        val btnVolver = findViewById<Button>(R.id.btnVolverOc)
        btnVolver.setOnClickListener {
            finish()//finaliza la actividad y regresa a la actividad anterior
        }

        // CheckBox para los países disponibles
        val ckBoxAustralia = findViewById<CheckBox>(R.id.ckBoxAustralia)
        val ckBoxNuevaZ = findViewById<CheckBox>(R.id.ckBoxNuevaZ)
        val ckBoxPapua = findViewById<CheckBox>(R.id.ckBoxPapua)

        // Botón para validar la selección de países y pasar a la siguiente actividad
        val btnVerPaises = findViewById<Button>(R.id.btnVerPaisesOc)

        // Listas para almacenar las selecciones del usuario
        val seleccion = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()

        // Listener del botón "Ver países", se incluyen las acciones al pulsar el botón
        btnVerPaises.setOnClickListener {

            // Limpia las listas de selección para evitar datos residuales
            seleccion.clear()
            imagenes.clear()

            // Verifica las selecciones y las añade a las listas
            if (ckBoxAustralia.isChecked){
                seleccion.add("Australia")
                imagenes.add(R.drawable.australia)
            }

            if (ckBoxNuevaZ.isChecked){
                seleccion.add("Nueva Zelanda")
                imagenes.add(R.drawable.nueva_zelanda)
            }

            if (ckBoxPapua.isChecked){
                seleccion.add("Papúa Nueva Guinea")
                imagenes.add(R.drawable.papua)
            }

            // Muestra un mensaje si no se seleccionó ningún país
            if (seleccion.isEmpty()){
                Toast.makeText(this,"No se ha seleccionado ningun país.", Toast.LENGTH_SHORT).show()

            }else{
                // Crea un Intent para abrir la actividad `Paises`
                val intent = Intent(this, Paises::class.java)
                // Pasa las selecciones y las imágenes a la siguiente actividad
                intent.putStringArrayListExtra("paises", ArrayList(seleccion))
                intent.putIntegerArrayListExtra("imagenes", ArrayList(imagenes))
                //Inicia la actividad 'Paises'
                startActivity(intent)
            }

        }

    }
}