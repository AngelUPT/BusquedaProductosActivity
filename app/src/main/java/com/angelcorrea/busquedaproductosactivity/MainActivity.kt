package com.angelcorrea.busquedaproductosactivity

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nombreProductoEditText = findViewById<EditText>(R.id.edtNombreProducto)
        val electronicaCheckBox = findViewById<CheckBox>(R.id.checkBox)
        val ropaCheckBox = findViewById<CheckBox>(R.id.checkBox2)
        val hogarCheckBox = findViewById<CheckBox>(R.id.checkBox3)
        val buscarButton = findViewById<Button>(R.id.btnBuscar)

        buscarButton.setOnClickListener {
            val nombreProducto = nombreProductoEditText.text.toString()

            val categoriasSeleccionadas = mutableListOf<String>()
            if (electronicaCheckBox.isChecked) categoriasSeleccionadas.add("Electrónica")
            if (ropaCheckBox.isChecked) categoriasSeleccionadas.add("Ropa")
            if (hogarCheckBox.isChecked) categoriasSeleccionadas.add("Hogar")

            if (nombreProducto.isEmpty() || categoriasSeleccionadas.isEmpty()) {
                Toast.makeText(
                    this,
                    "ngresa un nombre de producto y selecciona al menos una categoría.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val mensaje = """
                    Nombre del Producto: $nombreProducto
                    Categorías: ${categoriasSeleccionadas.joinToString(", ")}
                """.trimIndent()

                Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
            }
        }

    }
}