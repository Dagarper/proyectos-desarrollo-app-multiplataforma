package pmdm.com.midletmensajero

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaClientes : AppCompatActivity() {

    // Declaración de variables para gestionar la interfaz y la base de datos
    private lateinit var recyclerView: RecyclerView
    private lateinit var clientAdapter: AdaptadorCliente
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_clientes)

        // Inicializar la base de datos Room
        database = AppDatabase.getInstance(this)

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar el botón para añadir un nuevo cliente
        findViewById<Button>(R.id.btnAniadirCliente).setOnClickListener {
            // Navegar a la pantalla de añadir cliente
            startActivity(Intent(this, AniadirClientes::class.java))
        }

        // Configurar el botón para volver atrás
        findViewById<Button>(R.id.btnAtras).setOnClickListener {
            finish() // Finaliza la actividad actual y vuelve a la anterior
        }

        // Cargar la lista de clientes desde la base de datos
        loadClients()
    }

    // Este método se ejecuta cada vez que la actividad se reanuda
    override fun onResume() {
        super.onResume()
        loadClients() // Recargar la lista de clientes
    }

    // Método para cargar la lista de clientes desde la base de datos
    private fun loadClients() {
        lifecycleScope.launch {
            val clients = withContext(Dispatchers.IO) {
                database.clientDao().getAllClients() // Obtiene todos los clientes
            }

            // Configurar el adaptador con los clientes obtenidos
            clientAdapter = AdaptadorCliente(clients) { client ->
                showOptionsDialog(client) // Mostrar diálogo de opciones al hacer clic en un cliente
            }
            recyclerView.adapter = clientAdapter // Asignar el adaptador al RecyclerView
        }
    }

    // Mostrar un diálogo con opciones (Modificar o Borrar) para un cliente específico
    private fun showOptionsDialog(client: Client) {
        val options = arrayOf("Modificar", "Borrar")
        AlertDialog.Builder(this)
            .setTitle("Seleccione una opción")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> navigateToModifyClient(client) // Navegar a la pantalla de modificar cliente
                    1 -> deleteClient(client) // Eliminar el cliente
                }
            }
            .show()
    }

    // Método para eliminar un cliente de la base de datos
    private fun deleteClient(client: Client) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                database.clientDao().delete(client) // Elimina el cliente de la base de datos
            }
            Toast.makeText(this@ListaClientes, "Cliente eliminado", Toast.LENGTH_SHORT).show()
            loadClients() // Recargar la lista de clientes después de la eliminación
        }
    }

    // Navegar a la pantalla de modificar cliente
    private fun navigateToModifyClient(client: Client) {
        val intent = Intent(this, ModificarCliente::class.java)
        intent.putExtra("CLIENT_ID", client.id) // Pasa el ID del cliente a la siguiente actividad
        startActivity(intent)
    }
}