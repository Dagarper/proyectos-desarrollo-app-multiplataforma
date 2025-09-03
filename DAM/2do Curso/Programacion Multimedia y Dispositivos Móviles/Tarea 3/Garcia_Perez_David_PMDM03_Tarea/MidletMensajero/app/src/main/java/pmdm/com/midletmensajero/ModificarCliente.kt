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

class ModificarCliente : AppCompatActivity() {

    private lateinit var database: AppDatabase // Instancia de la base de datos
    private var clientId: Int = 0 // ID del cliente a modificar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.modificar_cliente) // Enlaza el layout que permite modificar los datos del cliente

        database = AppDatabase.getInstance(this) // Inicializa la base de datos
        clientId = intent.getIntExtra("CLIENT_ID", 0) // Obtiene el ID del cliente desde el intent

        // Cargar los datos actuales del cliente para mostrarlos en los campos de texto
        lifecycleScope.launch {
            val client = withContext(Dispatchers.IO) {
                database.clientDao().getClientById(clientId)
            }
            if (client != null) {
                // Rellena los campos de texto con el nombre y teléfono del cliente
                findViewById<EditText>(R.id.textActualizarNombre).setText(client.name)
                findViewById<EditText>(R.id.textActualizarTelefono).setText(client.phoneNumber)
            }
        }

        // Configuración del botón "Actualizar Cliente"
        findViewById<Button>(R.id.btnActualizarCliente).setOnClickListener {
            // Obtiene los valores actualizados desde los campos de texto
            val newName = findViewById<EditText>(R.id.textActualizarNombre).text.toString()
            val newPhone = findViewById<EditText>(R.id.textActualizarTelefono).text.toString()

            lifecycleScope.launch {
                withContext(Dispatchers.IO) {
                    // Crea un nuevo objeto cliente con los datos actualizados
                    val updatedClient = Client(clientId, newName, newPhone)
                    // Actualiza el cliente en la base de datos
                    database.clientDao().update(updatedClient)
                }
                // Muestra una confirmación al usuario
                Toast.makeText(this@ModificarCliente, "Cliente actualizado", Toast.LENGTH_SHORT).show()
                finish() // Cierra la actividad y regresa a la anterior
            }
        }
    }
}