package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ServicioActivity : AppCompatActivity() {
    lateinit var button2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio)
        button2 = findViewById(R.id.button2)
        button2.setOnClickListener{
            val intencion = Intent(this, PagarActivity::class.java)
            startActivity(intencion)

        }
    }
}