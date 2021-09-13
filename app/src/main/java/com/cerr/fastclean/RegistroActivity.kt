package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {
    lateinit var buttonRegistro: Button
    lateinit var buttonIngreso: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        buttonRegistro = findViewById(R.id.buttonRegistro)
        buttonIngreso = findViewById(R.id.buttonIngreso)

        buttonRegistro.setOnClickListener{
            val intencion = Intent(this, PrincipalActivity::class.java)
            startActivity(intencion)

        }

        buttonIngreso.setOnClickListener{
            val intencion = Intent(this, LoginActivity::class.java)
            startActivity(intencion)

        }
    }


}