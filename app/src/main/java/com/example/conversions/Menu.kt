package com.example.conversions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun binario(view: View) {
        val intento1 = Intent(this, Binario()::class.java)
        startActivity(intento1)

    }
    fun decimal(view: View) {
        val intento2 = Intent(this, Decimal()::class.java)
        startActivity(intento2)
    }
    fun hexadecimal(view: View) {
        val intento3 = Intent(this, Hexadecimal()::class.java)
        startActivity(intento3)
    }
    fun octal(view: View) {
        val intento4 = Intent(this, Octal()::class.java)
        startActivity(intento4)
    }
}