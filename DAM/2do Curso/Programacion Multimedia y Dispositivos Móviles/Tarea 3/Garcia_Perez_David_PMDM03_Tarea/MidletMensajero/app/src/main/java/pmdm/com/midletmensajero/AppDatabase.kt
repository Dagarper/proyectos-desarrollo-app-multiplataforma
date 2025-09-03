package pmdm.com.midletmensajero

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Declaración de la base de datos utilizando Room
@Database(entities = [Client::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Método abstracto para obtener el DAO de clientes
    abstract fun clientDao(): ClientDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null // Instancia única de la base de datos

        // Método para obtener la instancia única de la base de datos
        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) { // Bloque sincronizado para garantizar que solo una instancia sea creada
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, // Clase de la base de datos
                    "clientes.db" // Nombre del archivo de la base de datos en el almacenamiento
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}