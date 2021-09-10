package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {
    lateinit var buttonRegistro: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        buttonRegistro = findViewById(R.id.buttonRegistro)
        setupActivityLink()
        buttonRegistro.setOnClickListener{
            val intencion = Intent(this, PrincipalActivity::class.java)
            startActivity(intencion)

        }
    }
    fun setupActivityLink() {
        val linkTextView = findViewById<TextView>(R.id.textViewIngreso)
        linkTextView.setTextColor(Color.BLUE)
        linkTextView.setOnClickListener {
            val switchActivityIntent = Intent(this, LoginActivity::class.java)
            startActivity(switchActivityIntent)
        }
    }
}