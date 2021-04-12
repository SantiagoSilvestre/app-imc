package me.san.calcularimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListernes()
    }

    private fun setListernes() {
        val editPeso = findViewById<EditText>(R.id.edit_peso)
        val editAltura = findViewById<EditText>(R.id.edit_altura)
        val btnCalcular = findViewById<Button>(R.id.button_calcular)
        val textImc = findViewById<TextView>(R.id.txt_imc)
        /*
        editPeso.doOnTextChanged {text, _, _, _ -> textImc.text = text  }
        editAltura.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_LONG).show()
        }

         */
        btnCalcular.setOnClickListener{
            calcularImc(editPeso.text.toString(), editAltura.text.toString(), textImc)
        }

    }

    private fun calcularImc(peso: String, altura: String, title: TextView) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null) {
            val imc = peso /  (altura * altura)
            title.text = "Seu Imc é \n %.2f".format(imc)
        }
    }
}
