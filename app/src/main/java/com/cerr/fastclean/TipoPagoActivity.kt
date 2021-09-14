package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TipoPagoActivity : AppCompatActivity() {
    lateinit var buttonRealizarpago:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_pago)
        buttonRealizarpago = findViewById(R.id.buttonRealizarpago)
        buttonRealizarpago.setOnClickListener{
            val intencion = Intent(this, PagarActivity::class.java)
            startActivity(intencion)
        }
    }
}