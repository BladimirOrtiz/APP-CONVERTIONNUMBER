package com.example.conversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Binario : AppCompatActivity() {
    lateinit var conversor : Button
    lateinit var binario : EditText
    lateinit var  resultdecimal : EditText
    lateinit var resultadooct : EditText
    lateinit var resulthex : EditText
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binario)
        conversor= findViewById(R.id.btnconverir)
            binario = findViewById(R.id.txtoctal)
            resultdecimal= findViewById(R.id.txtconvdecimal)
            resultadooct= findViewById(R.id.txtconvhexadecimal)
            resulthex= findViewById(R.id.txtconvbinario)
            conversor.setOnClickListener {
        resultdecimal.setText(convertirDeBinarioADecimal(binario.text.toString().toInt()).toString())
        resultadooct.setText(convertDecimalaOctal(resultdecimal.text.toString().toInt()).toString())
        resulthex.setText(decimalahex(resultdecimal.text.toString().toInt()).toString())
        }
    }
          fun convertirDeBinarioADecimal(num: Int): Int {
            val binario: String = (num.toString()).reversed()
            var base = 1
            var resultado = 0;
            for (i in binario.indices) {
                resultado += if (binario[i].toString() == "0") 0 else base

                base *= 2
            }

            return resultado
        }
    fun convertDecimalaOctal(decimal: Int): Int {
        var decimal = decimal
        var octalNumber = 0
        var i = 1

        while (decimal != 0) {
            octalNumber += decimal % 8 * i
            decimal /= 8
            i *= 10
        }

        return octalNumber
    }
    fun decimalahex(decimal:Int):String{
        val finalValue = "0123456789ABCDEF"
        var value  = ""
        val base = 16
        var decimal = decimal
        while (decimal > 0) {
            val residuo: Int = decimal % base
            value = finalValue[residuo] + value // Add to left
            decimal /= base
        }
        return value
    }


}


