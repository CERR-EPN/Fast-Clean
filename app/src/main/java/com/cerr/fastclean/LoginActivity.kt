package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    lateinit var editTextEmail: EditText
    lateinit var editTextPassword:EditText
    lateinit var buttonLogin:Button
    lateinit var buttonNewUser:Button
    lateinit var mediaPlayer: MediaPlayer
    lateinit var checkBoxRecordarme: CheckBox
    lateinit var textViewRegistro: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextEmail = findViewById(R.id.editTextUsuario)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonNewUser = findViewById(R.id.buttonLogin)
        checkBoxRecordarme = findViewById(R.id.checkBoxRecordarme)
        buttonLogin.setOnClickListener{
            val intencion = Intent(this, PrincipalActivity::class.java)
            startActivity(intencion)
            setupActivityLink()
        }
    }
    override fun onDestroy() {
        mediaPlayer.release()
        super.onDestroy()
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