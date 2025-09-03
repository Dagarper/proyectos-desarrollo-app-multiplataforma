package pmdm.com.midletmensajero

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MostrarInstrucciones: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instrucciones)

        findViewById<Button>(R.id.btnAtrasInstrucciones).setOnClickListener {
            finish()
        }
    }
}