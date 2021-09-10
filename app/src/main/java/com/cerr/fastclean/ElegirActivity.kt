package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ElegirActivity : AppCompatActivity() {
    lateinit var buttonSiguiente: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir)
        buttonSiguiente = findViewById(R.id.buttonSiguiente)
        buttonSiguiente.setOnClickListener{
            val intencion = Intent(this, ServicioActivity::class.java)
            startActivity(intencion)
        }

    }
}