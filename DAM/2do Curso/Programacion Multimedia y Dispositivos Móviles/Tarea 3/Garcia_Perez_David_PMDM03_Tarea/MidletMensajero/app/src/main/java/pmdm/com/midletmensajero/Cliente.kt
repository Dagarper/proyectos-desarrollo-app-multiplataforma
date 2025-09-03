package pmdm.com.midletmensajero

import androidx.room.Entity
import androidx.room.PrimaryKey

// Define una entidad de Room que representa la tabla "Client" en la base de datos
@Entity
data class Client(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID único autogenerado para cada cliente
    val name: String, // Nombre del cliente
    val phoneNumber: String // Número de teléfono del cliente
)