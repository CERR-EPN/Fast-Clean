package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PagoActivity : AppCompatActivity() {
    lateinit var button3 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago)
        button3=findViewById(R.id.button3)
        button3.setOnClickListener{
            val intencion = Intent(this, TipoPagoActivity::class.java)
            startActivity(intencion)
        }
    }

}