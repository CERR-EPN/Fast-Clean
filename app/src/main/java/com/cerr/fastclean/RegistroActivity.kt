package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }
    fun setupActivityLink() {
        val linkTextView = findViewById<TextView>(R.id.textViewInicioSesion)
        linkTextView.setTextColor(Color.BLUE)
        linkTextView.setOnClickListener {
            val switchActivityIntent = Intent(this, RegistroActivity::class.java)
            startActivity(switchActivityIntent)
        }
    }
}