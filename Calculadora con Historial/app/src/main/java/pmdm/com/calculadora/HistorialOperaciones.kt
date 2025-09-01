package pmdm.com.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class HistorialOperaciones : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.historial)

        val baseDatos = BaseDatos(this)
        val vistaHistorial = findViewById<ListView>(R.id.listaHistorial)

        val lista = baseDatos.obtenerHistorial()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, lista)

        vistaHistorial.adapter = adapter

        val btnAtras = findViewById<Button>(R.id.btnAtrasHistorial)
        btnAtras.setOnClickListener {
            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }

    }
}