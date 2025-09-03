package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

/**
 * Clase que representa la actividad de selección de países en Europa.
 * Los usuarios pueden seleccionar uno o varios países de Europa y, posteriormente,
 * ver mapas representativos de los países seleccionados.
 */
class Europa: AppCompatActivity() {

    /**
    * Método que se ejecuta cuando se crea la actividad.
    * Configura el layout, inicializa los elementos de la interfaz y define el comportamiento
    * de los botones.
    *
    * @param savedInstanceState Estado guardado previamente de la actividad.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.europa)

        // Botón para volver a la actividad anterior
        val btnVolver = findViewById<Button>(R.id.btnVolverEu)
        btnVolver.setOnClickListener {
            finish()//finaliza la actividad y regresa a la actividad anterior
        }

        // CheckBox para los países disponibles
        val ckBoxEspaña = findViewById<CheckBox>(R.id.ckBoxEspaña)
        val ckBoxFrancia = findViewById<CheckBox>(R.id.ckBoxFrancia)
        val ckBoxAlemania = findViewById<CheckBox>(R.id.ckBoxAlemania)

        // Listas para almacenar las selecciones del usuario
        val seleccion = mutableListOf<String>()
        val imagenes = mutableListOf<Int>()

        // Botón para validar la selección de países y pasar a la siguiente actividad
        val btnVerPaisesEu = findViewById<Button>(R.id.btnVerPaisesEu)

        // Listener del botón "Ver países", se incluyen las acciones al pulsar el botón
        btnVerPaisesEu.setOnClickListener {

            // Limpia las listas de selección para evitar datos residuales
            seleccion.clear()
            imagenes.clear()

            // Verifica las selecciones y las añade a las listas
            if (ckBoxEspaña.isChecked){

                seleccion.add("España")
                imagenes.add(R.drawable.espania)
            }

            if (ckBoxFrancia.isChecked){
                seleccion.add("Francia")
                imagenes.add(R.drawable.francia)
            }

            if (ckBoxAlemania.isChecked){
                seleccion.add("Alemania")
                imagenes.add(R.drawable.alemania)
            }

            // Muestra un mensaje si no se seleccionó ningún país
            if (seleccion.isEmpty()){
                Toast.makeText(this, "No se ha seleccionado ningun pais", Toast.LENGTH_SHORT).show()
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