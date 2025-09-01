package pmdm.com.calculadora

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatos (context: Context) :SQLiteOpenHelper(context,"Calculadora.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("CREATE table operaciones (id INTEGER PRIMARY KEY AUTOINCREMENT, numero1 INT, numero2 INT, operacion TEXT, resultado INT)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL("DROP TABLE IF EXISTS operaciones")
            onCreate(db)

        }
    }

    fun insertarDatos(n1:Int,n2:Int, operacion:String, resultado:Int){

        val db = writableDatabase
        val valores = ContentValues().apply {
            put("numero1",n1)
            put("numero2",n2)
            put("operacion",operacion)
            put("resultado", resultado)

        }
        db.insert("operaciones",null, valores
        )
    }

    fun obtenerHistorial():List<String>{

        val lista = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM operaciones", null)

        while (cursor.moveToNext()){
            val n1 = cursor.getInt(1)
            val n2 = cursor.getInt(2)
            val operacion = cursor.getString(3)
            val resultado = cursor.getInt(4)
            lista.add(n1.toString() + " " + operacion + " " + n2.toString() + " = " + resultado.toString())
        }
            cursor.close()
            db.close()
            return lista
    }

}