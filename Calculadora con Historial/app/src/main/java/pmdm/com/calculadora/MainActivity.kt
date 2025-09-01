package pmdm.com.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btnAcercaDe = findViewById<Button>(R.id.btnAcerca).setOnClickListener{
            setContentView(R.layout.acerca_de)
        }

        val btnCalculadora = findViewById<Button>(R.id.btnCalculadora).setOnClickListener{

            val intent = Intent(this, Calculadora::class.java)
            startActivity(intent)
        }

    }
}