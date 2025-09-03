package pmdm.com.midletmensajero

import androidx.room.*

// Define el DAO (Data Access Object) para gestionar operaciones en la tabla "Client"
@Dao
interface ClientDao {

    // Inserta un cliente en la base de datos
    @Insert
    fun insert(client: Client)

    // Recupera todos los clientes de la tabla
    @Query("SELECT * FROM Client")
    fun getAllClients(): List<Client>

    // Recupera un cliente específico basado en su ID
    @Query("SELECT * FROM Client WHERE id = :id")
    fun getClientById(id: Int): Client?

    // Elimina un cliente de la tabla
    @Delete
    fun delete(client: Client)

    // Actualiza los datos de un cliente existente
    @Update
    fun update(client: Client)
}