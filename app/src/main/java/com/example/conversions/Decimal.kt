package com.example.conversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Decimal : AppCompatActivity() {
    lateinit var conversor : Button
    lateinit var decimal : EditText
    lateinit var resbinario: EditText
    lateinit var resoctal : EditText
    lateinit var resulthex : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decimal)
        conversor =findViewById(R.id.btnconverir)
        decimal = findViewById(R.id.txtoctal)
        resbinario =findViewById(R.id.txtconvdecimal)
        resoctal = findViewById(R.id.txtconvhexadecimal)
        resulthex= findViewById(R.id.txtconvbinario)
        //INVOCACION DE EVENTOS EN EL BOTON CONVERTIR
        conversor.setOnClickListener {
            convertDB()
            resoctal.setText(convertDecimalaOctal(decimal.text.toString().toInt()).toString())
            resulthex.setText(decimalahex(decimal.text.toString().toInt()).toString())
        }}
        //METODOS
        fun convertDB(){
            var numero : Int = decimal.text.toString().toInt()
            var cadena : String =""
            var cociente : Int = numero
            var resto: Int = 0
            while (cociente !=0 ){
                resto = cociente % 2
                cociente /=2
                cadena += resto.toString()
            }
            val binario : String  = cadena.reversed();
            resbinario.setText(binario)
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