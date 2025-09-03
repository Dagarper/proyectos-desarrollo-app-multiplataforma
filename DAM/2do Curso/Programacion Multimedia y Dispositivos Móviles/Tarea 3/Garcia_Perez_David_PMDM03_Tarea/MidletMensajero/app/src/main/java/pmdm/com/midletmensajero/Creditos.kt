package pmdm.com.midletmensajero

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Creditos: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creditos)

        findViewById<Button>(R.id.btnAtrasCred).setOnClickListener {
            finish()
        }
    }
}