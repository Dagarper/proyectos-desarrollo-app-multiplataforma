package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

/**
 * Clase que representa la actividad de selección de países en América.
 * Los usuarios pueden seleccionar uno o varios países de América y, posteriormente,
 * ver mapas representativos de los países seleccionados.
 */
class America: AppCompatActivity() {

    /**
     * Método que se ejecuta cuando se crea la actividad.
     * Configura el layout, inicializa los elementos de la interfaz y define el comportamiento
     * de los botones.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.america)

        // Botón para volver a la actividad anterior
        val btnVolver = findViewById<Button>(R.id.btnVolverAm)
        btnVolver.setOnClickListener {
            finish()// Finaliza la actividad y regresa a la anterior
        }

        // Botón para validar la selección de países y pasar a la siguiente actividad
        val btnVerPaises = findViewById<Button>(R.id.btnVerPaisesAm)

        // CheckBox para los países disponibles
        val ckBoxEEUU = findViewById<CheckBox>(R.id.ckBoxEEUU)
        val ckBoxMexico = findViewById<CheckBox>(R.id.ckBoxMexico)
        val ckBoxBrasil = findViewById<CheckBox>(R.id.ckBoxBrasil)

        // Listas para almacenar las selecciones del usuario
        val seleccion = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()

        // Listener del botón "Ver países", se incluyen las acciones al pulsar el botón
        btnVerPaises.setOnClickListener {

            // Limpia las listas de selección para evitar datos residuales
            seleccion.clear()
            imagenes.clear()

            // Verifica las selecciones y las añade a las listas
            if (ckBoxEEUU.isChecked) {
                seleccion.add("Estados Unidos")
                imagenes.add(R.drawable.eeuu)
            }

            if (ckBoxMexico.isChecked){
                seleccion.add("Mexico")
                imagenes.add(R.drawable.mexico)
            }

            if (ckBoxBrasil.isChecked){
                seleccion.add("Brasil")
                imagenes.add(R.drawable.brasil)
            }

            // Muestra un mensaje si no se seleccionó ningún país
            if (seleccion.isEmpty()){
                Toast.makeText(this, "No se ha seleccionado ningún país", Toast.LENGTH_SHORT).show()
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