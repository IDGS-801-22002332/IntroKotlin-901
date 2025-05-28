package org.utl.introkotlin_901.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BuscarActivity : AppCompatActivity() {

    private val fileName = "palabras.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPalabra = findViewById<EditText>(R.id.edtPalabraB)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnRegresar.setOnClickListener {navigateToRegresar()}

        btnBuscar.setOnClickListener {
            val palabraIngresada = edtPalabra.text.toString().trim()
            if (palabraIngresada.isEmpty()) {
                mostrarAlerta("Atención", "Debes ingresar una palabra.")
                return@setOnClickListener
            }

            val esEspanol = radioGroup.checkedRadioButtonId == R.id.radioButton

            try {
                val fileInput = openFileInput(fileName)
                val reader = BufferedReader(InputStreamReader(fileInput))
                var linea: String?
                var encontrada = false

                while (reader.readLine().also { linea = it } != null) {
                    val partes = linea!!.split("-").map { it.trim() }
                    if (partes.size == 2) {
                        val esp = partes[0]
                        val ing = partes[1]

                        if ((esEspanol && palabraIngresada.equals(esp, ignoreCase = true)) ||
                            (!esEspanol && palabraIngresada.equals(ing, ignoreCase = true))) {

                            val resultado = if (esEspanol) "$esp → $ing" else "$ing → $esp"
                            tvResultado.text = resultado
                            mostrarAlerta("Resultado", resultado)
                            encontrada = true
                            break
                        }
                    }
                }

                reader.close()

                if (!encontrada) {
                    mostrarAlerta("Sin resultados", "La palabra no se encuentra en el diccionario.")
                    tvResultado.text = ""
                }

            } catch (e: Exception) {
                e.printStackTrace()
                mostrarAlerta("Error", "No se pudo leer el archivo.")
                tvResultado.text = ""
            }
        }
    }

    private fun mostrarAlerta(titulo: String, mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle(titulo)
            .setMessage(mensaje)
            .setPositiveButton("Aceptar", null)
            .show()
    }

    private fun navigateToRegresar(){
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
