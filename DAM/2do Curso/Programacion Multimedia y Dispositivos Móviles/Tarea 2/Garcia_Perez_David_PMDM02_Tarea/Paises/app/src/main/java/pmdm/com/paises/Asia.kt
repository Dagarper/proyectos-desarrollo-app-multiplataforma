package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList


/**
 * Clase que representa la actividad de selección de países en Asia.
 * Los usuarios pueden seleccionar uno o varios países de Asia y, posteriormente,
 * ver mapas representativos de los países seleccionados.
 */
class Asia: AppCompatActivity() {

    /**
     * Método que se ejecuta cuando se crea la actividad.
     * Configura el layout, inicializa los elementos de la interfaz y define el comportamiento
     * de los botones.
     *
     * @param savedInstanceState Estado guardado previamente de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.asia)

        // Botón para volver a la actividad anterior
        val btnVolver = findViewById<Button>(R.id.btnVolverAs)
        btnVolver.setOnClickListener {
            finish()//finaliza la actividad y regresa a la actividad anterior
        }

        // CheckBox para los países disponibles
        val ckBoxChina = findViewById<CheckBox>(R.id.ckBoxChina)
        val ckBoxIndia = findViewById<CheckBox>(R.id.ckBoxIndia)
        val ckBoxRusia = findViewById<CheckBox>(R.id.ckBoxRusia)

        // Listas para almacenar las selecciones del usuario
        val seleccion = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()

        // Botón para validar la selección de países y pasar a la siguiente actividad
        val btnVerPaisesAs = findViewById<Button>(R.id.btnVerPaisesAs)

        // Listener del botón "Ver países", se incluyen las acciones al pulsar el botón
        btnVerPaisesAs.setOnClickListener {

            // Limpia las listas de selección para evitar datos residuales
            seleccion.clear()
            imagenes.clear()

            // Verifica las selecciones y las añade a las listas
            if (ckBoxChina.isChecked){

                seleccion.add("China")
                imagenes.add(R.drawable.china)
            }

            if (ckBoxIndia.isChecked){
                seleccion.add("India")
                imagenes.add(R.drawable.india)
            }

            if (ckBoxRusia.isChecked){
                seleccion.add("Rusia")
                imagenes.add(R.drawable.rusia)
            }

            // Muestra un mensaje si no se seleccionó ningún país
            if (seleccion.isEmpty()){
                Toast.makeText(this,"No se ha seleccionado ningun país",Toast.LENGTH_SHORT).show()
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