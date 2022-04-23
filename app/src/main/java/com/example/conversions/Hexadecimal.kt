package com.example.conversions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Hexadecimal : AppCompatActivity() {
    lateinit var conversor : Button
        lateinit var  resdeci : EditText
    lateinit var resbi : EditText
    lateinit var resoct : EditText
    lateinit var hex : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hexadecimal)
        conversor = findViewById(R.id.btnconversor)
        resdeci = findViewById(R.id.txtdeci)
        resbi = findViewById(R.id.txtbi)
        resoct = findViewById(R.id.txtoct)
        hex= findViewById(R.id.txthex)
        //INVOCACION DE EVENTOS EN EL BOTON CONVERTIR
        conversor.setOnClickListener {
            resdeci.setText(convertirDeHexadecimalADecimal(hex.text.toString()).toString())
            convertDB()
            resoct.setText(convertDecimalaOctal(resdeci.text.toString().toInt()).toString())

        }
        }

        fun valoresHexadecimal(a: String): Int = when(a) {
            "A" -> 10
            "B" -> 11
            "C" -> 12
            "D" -> 13
            "E" -> 14
            "F" -> 15
            else -> a.toInt()
        }
    fun convertirDeHexadecimalADecimal(cadena: String): Int{
        var conv = cadena.reversed()
        var ciclo: Int = cadena.length - 1
        var resultado = 0

        while (ciclo >= 0){
            resultado += valoresHexadecimal(conv[ciclo].toString()) * (Math.pow(16.toDouble(), ciclo.toDouble())).toInt()
            ciclo -= 1
        }

        return resultado
    }
    fun convertDB(){
        var numero : Int = resdeci.text.toString().toInt()
        var cadena : String =""
        var cociente : Int = numero
        var resto: Int = 0
        while (cociente !=0 ){
            resto = cociente % 2
            cociente /=2
            cadena += resto.toString()
        }
        val binario : String  = cadena.reversed();
        resbi.setText(binario)
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

}