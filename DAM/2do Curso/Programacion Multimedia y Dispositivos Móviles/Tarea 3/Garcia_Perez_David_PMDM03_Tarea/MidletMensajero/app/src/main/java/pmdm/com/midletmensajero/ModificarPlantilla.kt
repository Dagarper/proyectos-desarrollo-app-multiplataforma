package pmdm.com.midletmensajero

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ModificarPlantilla : AppCompatActivity() {

    private lateinit var plantillaEditText: EditText // EditText para que el usuario ingrese o modifique la plantilla
    private lateinit var sharedPreferences: SharedPreferences // SharedPreferences para almacenar la plantilla

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_plantilla) // Asocia el layout con la actividad

        // Inicializa SharedPreferences para guardar la plantilla
        sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)

        // Obtiene la referencia al EditText y al botón de guardar
        plantillaEditText = findViewById(R.id.editTextPlantilla)
        val saveButton = findViewById<Button>(R.id.btnGuardarPlantilla)

        // Cargar la plantilla guardada (si existe) al iniciar la actividad
        val plantillaActual = sharedPreferences.getString("PLANTILLA_MENSAJE", "Enhorabuena *, has sido seleccionado para...")
        plantillaEditText.setText(plantillaActual) // Rellena el EditText con la plantilla actual

        // Configura el botón para guardar la plantilla
        saveButton.setOnClickListener {
            val nuevaPlantilla = plantillaEditText.text.toString().trim() // Obtiene el texto introducido por el usuario

            // Verifica si la plantilla está vacía
            if (nuevaPlantilla.isEmpty()) {
                // Muestra un mensaje si la plantilla está vacía
                Toast.makeText(this, "La plantilla no puede estar vacía", Toast.LENGTH_SHORT).show()
            } else {
                // Guarda la nueva plantilla en SharedPreferences
                sharedPreferences.edit().putString("PLANTILLA_MENSAJE", nuevaPlantilla).apply()
                // Muestra un mensaje de confirmación
                Toast.makeText(this, "Plantilla guardada correctamente", Toast.LENGTH_SHORT).show()
                finish() // Cierra la actividad y regresa a la anterior
            }
        }
    }
}