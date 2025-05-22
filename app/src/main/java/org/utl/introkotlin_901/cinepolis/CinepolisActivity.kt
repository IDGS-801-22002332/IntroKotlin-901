package org.utl.introkotlin_901.cinepolis

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R


class CinepolisActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var cantC: EditText
    private lateinit var cantB: EditText
    private lateinit var total: EditText
    private lateinit var rdSi: RadioButton
    private lateinit var rdNo: RadioButton
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cinepolis)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edtName = findViewById(R.id.edtName)
        cantC = findViewById(R.id.cantC)
        cantB = findViewById(R.id.cantB)
        total = findViewById(R.id.total)
        rdSi = findViewById(R.id.rdsi)
        rdNo = findViewById(R.id.rdno)
        btnStart = findViewById(R.id.btnStart)

        btnStart.setOnClickListener {
            calcularTotal()
        }
    }

    private fun calcularTotal() {
        val nombre = edtName.text.toString()
        val personas = cantC.text.toString().toIntOrNull()
        val boletos = cantB.text.toString().toIntOrNull()

        if (nombre.isEmpty() || personas == null || boletos == null || personas <= 0) {
            Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            return
        }

        val maxPermitido = personas * 7

        if (boletos > maxPermitido) {
            Toast.makeText(
                this,
                "No puedes comprar más de $maxPermitido boletos para $personas persona(s)",
                Toast.LENGTH_LONG
            ).show()
            total.setText("")
            return
        }

        val precioBoleta = 12.0
        var subtotal = boletos * precioBoleta

        val descuentoCantidad = when {
            boletos > 5 -> 0.15
            boletos in 3..5 -> 0.10
            else -> 0.0
        }

        subtotal -= subtotal * descuentoCantidad

        if (rdSi.isChecked) {
            subtotal -= subtotal * 0.10
        }

        total.setText("Total: $${"%.2f".format(subtotal)}")
    }
}