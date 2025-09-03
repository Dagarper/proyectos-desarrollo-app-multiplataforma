package pmdm.com.paises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity que muestra una lista de países seleccionados junto con sus respectivas imágenes.
 * Recibe la información a través de un Intent desde otras actividades.
 */
class Paises: AppCompatActivity() {

    /**
     * Método que se llama cuando se crea la actividad. Inicializa las vistas y configura
     * los datos pasados a través del Intent.
     *
     * @param savedInstanceState Si la actividad se recrea, contiene el estado previo.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paises)

        // Inicializamos las vistas de texto e imagen
        val text1 = findViewById<TextView>(R.id.textPais1)
        val text2 = findViewById<TextView>(R.id.textPais2)
        val text3 = findViewById<TextView>(R.id.textPais3)

        val image1 = findViewById<ImageView>(R.id.imageView)
        val image2 = findViewById<ImageView>(R.id.imageView2)
        val image3 = findViewById<ImageView>(R.id.imageView3)



        // Recuperamos los datos pasados por el Intent
        val paises = intent.getStringArrayListExtra("paises")
        val imagenes = intent.getIntegerArrayListExtra("imagenes")

        // Verificamos si los datos no son nulos y los mostramos en las vistas correspondientes
        if (paises != null && imagenes != null) {
            if (paises.size >= 1) {
                text1.text = paises[0]
                image1.setImageResource(imagenes[0])
            }

            if (paises.size >= 2) {
                text2.text = paises[1]
                image2.setImageResource(imagenes[1])
            }

            if (paises.size >= 3) {
                text3.text = paises[2]
                image3.setImageResource(imagenes[2])
            }
        }

        // Configuramos el botón "Volver" para cerrar la actividad actual
        val btnVolver = findViewById<Button>(R.id.btnVolverPaises)
        btnVolver.setOnClickListener {
            finish()
        }
    }

}
