package pmdm.com.midletmensajero

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AniadirClientes : AppCompatActivity() {
    // Referencia a la base de datos
    private lateinit var baseDatos: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aniadir_cliente)

        // Inicializar la base de datos
        baseDatos = AppDatabase.getInstance(this)

        // Referencias a los elementos de la interfaz
        val nombreIntroducido = findViewById<EditText>(R.id.textNombreCliente)
        val telefonoIntroducido = findViewById<EditText>(R.id.textTelefono)

        // Configurar el botón para guardar el cliente
        findViewById<Button>(R.id.btnGuardarCliente).setOnClickListener {
            // Obtener el texto introducido en los campos
            val nombre = nombreIntroducido.text.toString().trim()
            val telefono = telefonoIntroducido.text.toString().trim()

            // Validar que los campos no estén vacíos
            if (nombre.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(this, "Introduce un nombre y un teléfono", Toast.LENGTH_SHORT).show()
            } else {
                guardarCliente(nombre, telefono) // Guardar cliente en la base de datos
            }
        }
    }

    // Método para guardar un cliente en la base de datos
    private fun guardarCliente(nombre: String, telefono: String) {
        lifecycleScope.launch {
            // Insertar cliente en un hilo secundario
            withContext(Dispatchers.IO) {
                val nuevoCliente = Client(name = nombre, phoneNumber = telefono) // Crear objeto Client
                baseDatos.clientDao().insert(nuevoCliente) // Insertar cliente en la base de datos
            }
            // Mostrar confirmación al usuario en el hilo principal
            Toast.makeText(this@AniadirClientes, "Cliente guardado correctamente", Toast.LENGTH_SHORT).show()
            finish() // Cierra la actividad y regresa a la anterior
        }
    }
}