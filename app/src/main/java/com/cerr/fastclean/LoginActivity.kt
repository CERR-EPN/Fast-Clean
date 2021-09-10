package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    lateinit var buttonLogin: Button
    lateinit var textViewRegistro: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonLogin = findViewById(R.id.buttonLogin)
        setupActivityLink()
        buttonLogin.setOnClickListener{
            val intencion = Intent(this, PrincipalActivity::class.java)
            startActivity(intencion)

        }
    }
    fun setupActivityLink() {
        val linkTextView = findViewById<TextView>(R.id.textViewRegistro)
        linkTextView.setTextColor(Color.BLUE)
        linkTextView.setOnClickListener {
            val switchActivityIntent = Intent(this, RegistroActivity::class.java)
            startActivity(switchActivityIntent)
        }
    }
}