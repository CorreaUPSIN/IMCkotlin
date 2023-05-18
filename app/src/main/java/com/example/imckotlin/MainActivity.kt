package com.example.imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var pesoEditText: EditText
    private lateinit var alturaEditText: EditText
    private lateinit var resultadoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pesoEditText = findViewById(R.id.pesoEditText)
        alturaEditText = findViewById(R.id.alturaEditText)
        resultadoTextView = findViewById(R.id.resultadoTextView)

        val calcularButton: Button = findViewById(R.id.calcularButton)
        calcularButton.setOnClickListener {
            calcularIMC()
        }

        val borrarButton: Button = findViewById(R.id.borrarButton)
        borrarButton.setOnClickListener {
            borrarCampos()
        }

        val salirButton: Button = findViewById(R.id.salirButton)
        salirButton.setOnClickListener {
            finish()
        }
    }

    private fun calcularIMC() {
        val pesoString = pesoEditText.text.toString()
        val alturaString = alturaEditText.text.toString()

        if (!pesoString.isEmpty() && !alturaString.isEmpty()) {
            try {
                val peso = pesoString.toDouble()
                val altura = alturaString.toDouble()

                val imc = peso / (altura * altura)
                resultadoTextView.text = String.format("Tu IMC es: %.2f", imc)
            } catch (e: NumberFormatException) {
                Toast.makeText(this,
                    "Los valores ingresados no son válidos", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,
                "Favor de ingresar los datos correspondientes", Toast.LENGTH_SHORT).show()
        }
    }


    private fun borrarCampos() {
        pesoEditText.setText("")
        alturaEditText.setText("")
        resultadoTextView.setText("")
    }}
