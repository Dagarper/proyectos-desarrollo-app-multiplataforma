package pmdm.com.midletmensajero

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para manejar la lista de clientes en el RecyclerView
class AdaptadorCliente(
    private val clients: List<Client>,  // Lista de clientes a mostrar
    private val onLongClick: (Client) -> Unit  // Acción a ejecutar cuando se realiza un click largo en un ítem
) : RecyclerView.Adapter<AdaptadorCliente.ClientViewHolder>() {

    // Crear la vista para cada ítem en el RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        // Infla el layout item_cliente para cada elemento de la lista
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent, false)
        return ClientViewHolder(view)  // Retorna un ViewHolder con la vista inflada
    }

    // Llenar la vista con los datos de un cliente
    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        val client = clients[position]  // Obtiene el cliente correspondiente a la posición
        holder.nameTextView.text = client.name  // Asigna el nombre del cliente al TextView
        holder.phoneTextView.text = client.phoneNumber  // Asigna el número de teléfono al TextView

        // Configura el evento de click largo
        holder.itemView.setOnLongClickListener {
            onLongClick(client)  // Ejecuta la acción definida en onLongClick
            true  // Indica que el evento fue manejado
        }
    }

    // Número de elementos que tiene el RecyclerView
    override fun getItemCount(): Int = clients.size  // Retorna el tamaño de la lista de clientes

    // ViewHolder para manejar la vista de cada ítem
    inner class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)  // TextView para el nombre del cliente
        val phoneTextView: TextView = itemView.findViewById(R.id.textViewPhone)  // TextView para el número de teléfono
    }
}