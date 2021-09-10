package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PagarActivity : AppCompatActivity() {
    lateinit var buttonFinalizar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagar)
        buttonFinalizar = findViewById(R.id.buttonFinalizar)
        buttonFinalizar.setOnClickListener{
            val intencion = Intent(this, PrincipalActivity::class.java)
            startActivity(intencion)

        }
    }
}