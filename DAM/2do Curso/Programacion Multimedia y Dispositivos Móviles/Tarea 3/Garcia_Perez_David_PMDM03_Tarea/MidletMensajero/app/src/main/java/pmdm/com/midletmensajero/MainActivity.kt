package pmdm.com.midletmensajero

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.Manifest

// Clase principal que gestiona la pantalla principal y las interacciones iniciales de la aplicación
class MainActivity : AppCompatActivity() {
    private lateinit var database: AppDatabase // Instancia de la base de datos local

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_principal)

        // Verificar y solicitar permiso para enviar SMS
        checkSmsPermission()

        // Inicializar la base de datos
        database = AppDatabase.getInstance(this)

        // Configurar los botones principales y sus acciones
        findViewById<Button>(R.id.bntInicio).setOnClickListener {
            // Cambia la vista a la pantalla principal
            setContentView(R.layout.activity_main)

            // Configuración de cada botón de la pantalla principal
            findViewById<Button>(R.id.btnExplorar).setOnClickListener {
                // Navegar a la lista de clientes
                startActivity(Intent(this, ListaClientes::class.java))
            }

            findViewById<Button>(R.id.btnPlantilla).setOnClickListener {
                // Navegar a la pantalla para modificar la plantilla de mensaje
                startActivity(Intent(this, ModificarPlantilla::class.java))
            }

            findViewById<Button>(R.id.btnEnviarMensaje).setOnClickListener {
                // Enviar mensajes a los clientes
                enviarMensajes()
            }

            findViewById<Button>(R.id.btnSalir).setOnClickListener {
                // Finalizar la actividad actual y salir de la aplicación
                finish()
            }

            findViewById<Button>(R.id.btnInstrucciones).setOnClickListener {
                // Navegar a la pantalla de instrucciones
                startActivity(Intent(this, MostrarInstrucciones::class.java))
            }

            findViewById<Button>(R.id.btnCreditos).setOnClickListener {
                // Navegar a la pantalla de créditos
                startActivity(Intent(this, Creditos::class.java))
            }
        }
    }

    // Método para enviar mensajes a los clientes almacenados en la base de datos
    private fun enviarMensajes() {
        lifecycleScope.launch {
            // Recuperar la lista de clientes desde la base de datos en un hilo secundario
            val clients = withContext(Dispatchers.IO) {
                database.clientDao().getAllClients()
            }

            // Obtener la plantilla de mensaje desde SharedPreferences
            val sharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
            val plantilla = sharedPreferences.getString("PLANTILLA_MENSAJE", "Hola *, este es tu mensaje.")

            // Validar si hay clientes disponibles
            if (clients.isEmpty()) {
                Toast.makeText(this@MainActivity, "No hay clientes para enviar mensajes.", Toast.LENGTH_SHORT).show()
                return@launch
            }

            // Enviar mensajes en un hilo secundario para evitar bloquear la interfaz de usuario
            withContext(Dispatchers.IO) {
                val smsManager = SmsManager.getDefault()

                clients.forEach { client ->
                    val mensaje = plantilla?.replace("*", client.name) ?: "" // Personalizar el mensaje
                    try {
                        // Enviar mensaje SMS al número del cliente
                        smsManager.sendTextMessage(client.phoneNumber, null, mensaje, null, null)
                        println("Mensaje enviado a ${client.name}: $mensaje") // Para depuración
                    } catch (e: Exception) {
                        println("Error al enviar mensaje a ${client.name}: ${e.message}") // Para depuración
                    }
                }
            }

            // Mostrar un mensaje de confirmación en la interfaz de usuario
            withContext(Dispatchers.Main) {
                Toast.makeText(this@MainActivity, "Mensajes enviados correctamente", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método para verificar si se tienen permisos de SMS; si no, los solicita
    private fun checkSmsPermission() {
        val permission = Manifest.permission.SEND_SMS

        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
            // Solicitar permiso si no se tiene
            ActivityCompat.requestPermissions(this, arrayOf(permission), 1)
        }
    }
}