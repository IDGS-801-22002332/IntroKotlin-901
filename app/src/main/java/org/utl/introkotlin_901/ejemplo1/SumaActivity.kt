package org.utl.introkotlin_901.ejemplo1

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.utl.introkotlin_901.R
import android.view.View

class SumaActivity : AppCompatActivity() {
    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)
        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun calcular(view: View?) {
        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()

        val radioGroup = findViewById<android.widget.RadioGroup>(R.id.radio)
        val selectedId = radioGroup.checkedRadioButtonId

        val resultado = when (selectedId) {
            R.id.suma -> num1 + num2
            R.id.resta -> num1 - num2
            R.id.multiplicacion -> num1 * num2
            R.id.division -> num1/num2

            else -> {
                tv1.text = "Selecciona una operación"
                return
            }
        }

        tv1.text = "Resultado = $resultado"
    }


}