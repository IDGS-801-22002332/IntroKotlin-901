package org.utl.introkotlin_901.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R
import java.io.IOException

class CapturarActivity : AppCompatActivity() {

    private val fileName = "palabras.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capturar)

        val edtEspanol = findViewById<EditText>(R.id.edtEspanol)
        val edtIngles = findViewById<EditText>(R.id.edtIngles)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        btnRegresar.setOnClickListener {navigateToRegresar()}

        btnGuardar.setOnClickListener {
            val palabraEsp = edtEspanol.text.toString().trim()
            val palabraIng = edtIngles.text.toString().trim()

            if (palabraEsp.isNotEmpty() && palabraIng.isNotEmpty()) {
                val linea = "$palabraEsp - $palabraIng\n"
                try {
                    openFileOutput(fileName, MODE_APPEND).use {
                        it.write(linea.toByteArray())
                    }
                    mostrarAlerta("Guardado", "La palabra se guardó correctamente.")
                    edtEspanol.text.clear()
                    edtIngles.text.clear()
                } catch (e: IOException) {
                    e.printStackTrace()
                    mostrarAlerta("Error", "No se pudo guardar la palabra.")
                }
            } else {
                mostrarAlerta("Atención", "Ambos campos deben estar llenos.")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun mostrarAlerta(titulo: String, mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(titulo)
        builder.setMessage(mensaje)
        builder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        builder.create().show()
    }

    private fun navigateToRegresar(){
        val intent = Intent(this, MenuActivity::class.java)
        startActivity(intent)
    }
}
