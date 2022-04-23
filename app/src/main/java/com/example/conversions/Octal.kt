package com.example.conversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Octal : AppCompatActivity() {
    lateinit var conversor : Button
    lateinit var octal : EditText
    lateinit var resultadodeci : EditText
    lateinit var resulthex : EditText
    lateinit var resultbi : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_octal)
        // INICIAMOS LAS VARIABLES
        conversor = findViewById(R.id.btnconverir)
        octal = findViewById(R.id.txtoctal)
        resultadodeci = findViewById(R.id.txtconvdecimal)
        resultbi = findViewById(R.id.txtconvbinario)
        resulthex = findViewById(R.id.txtconvhexadecimal)
        // INVOCACION DE METODOS
        conversor.setOnClickListener {
        resultadodeci.setText(convertOctalaDecimal(octal.text.toString().toInt()).toString())
        convertDB()
       resulthex.setText(decimalahex(resultadodeci.text.toString().toInt()).toString())

        }
    }
    fun convertOctalaDecimal(octal: Int): Int {
        var octal = octal
        var decimalNumber = 0
        var i = 0

        while (octal != 0) {
            decimalNumber += (octal % 10 * Math.pow(8.0, i.toDouble())).toInt()
            ++i
            octal /= 10
        }

        return decimalNumber
    }
    fun convertDB(){
        var numero : Int = resultadodeci.text.toString().toInt()
        var cadena : String =""
        var cociente : Int = numero
        var resto: Int = 0
        while (cociente !=0 ){
            resto = cociente % 2
            cociente /=2
            cadena += resto.toString()
        }
        val binario : String  = cadena.reversed();
        resultbi.setText(binario)
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

