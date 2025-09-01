package pmdm.com.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Calculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora)

        val baseDatos = BaseDatos(this)
        var resultado = 0
        var numero1 = 0
        var operacion = ""
        val campoOperacion = findViewById<EditText>(R.id.editTextNumber)
        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener { campoOperacion.append("1") }
        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener { campoOperacion.append("2") }
        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener { campoOperacion.append("3") }
        val btn4 = findViewById<Button>(R.id.btn4)
        btn4.setOnClickListener { campoOperacion.append("4") }
        val btn5 = findViewById<Button>(R.id.btn5)
        btn5.setOnClickListener { campoOperacion.append("5") }
        val btn6 = findViewById<Button>(R.id.btn6)
        btn6.setOnClickListener { campoOperacion.append("6") }
        val btn7 = findViewById<Button>(R.id.btn7)
        btn7.setOnClickListener { campoOperacion.append("7") }
        val btn8 = findViewById<Button>(R.id.btn8)
        btn8.setOnClickListener { campoOperacion.append("8") }
        val btn9 = findViewById<Button>(R.id.btn9)
        btn9.setOnClickListener { campoOperacion.append("9") }
        val btn0 = findViewById<Button>(R.id.btn0)
        btn0.setOnClickListener { campoOperacion.append("0") }

        val btnMas = findViewById<Button>(R.id.btnMas)
        btnMas.setOnClickListener {
            operacion = "+"
            numero1 = campoOperacion.text.toString().toInt()
            campoOperacion.setText("")
        }

        val btnMenos = findViewById<Button>(R.id.btnMenos)
        btnMenos.setOnClickListener {
            operacion = "-"
            numero1 = campoOperacion.text.toString().toInt()
            campoOperacion.setText("")
        }
        val btnMult = findViewById<Button>(R.id.btnMult)
        btnMult.setOnClickListener {
            operacion = "*"
            numero1 = campoOperacion.text.toString().toInt()
            campoOperacion.setText("")
        }
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        btnDiv.setOnClickListener {
            operacion = "/"
            numero1 = campoOperacion.text.toString().toInt()
            campoOperacion.setText("")
        }

        val btnIgual = findViewById<Button>(R.id.btnIgual)
        btnIgual.setOnClickListener {


            var numero2 = campoOperacion.text.toString().toInt()

            if (numero2 == null) {
                Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(operacion == "+"){
              resultado = numero1 + numero2

            }else if (operacion == "-"){
                resultado = numero1 - numero2
            }else if (operacion == "*"){
                resultado = numero1 * numero2
            }else if (operacion == "/"){
                if (numero2 != 0) numero1 / numero2
                else {
                    Toast.makeText(this, "No se puede dividir por 0", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener //salir del onClick SIN salir de onCreate()
                }
                resultado = numero1 / numero2

            }

            baseDatos.insertarDatos(numero1,numero2,operacion,resultado)
            campoOperacion.setText(resultado.toString())


        }

        val btnBorrar = findViewById<Button>(R.id.btnBorrarTodo)
        btnBorrar.setOnClickListener {

            campoOperacion.setText("")
        }

        val btnHistorial = findViewById<Button>(R.id.btnHistorial)
        btnHistorial.setOnClickListener {
            val intent = Intent(this, HistorialOperaciones::class.java)
            startActivity(intent)

        }

        val btnAtras = findViewById<Button>(R.id.btnAtras)
        btnAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}