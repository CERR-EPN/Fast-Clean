package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    lateinit var buttonLogin: Button
    lateinit var buttonRegistroLogin: Button

    lateinit var editTextUsuario: EditText
    lateinit var editTextPassword: EditText
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegistroLogin = findViewById(R.id.buttonRegistroLogin)
        editTextUsuario = findViewById(R.id.editTextUsuario)
        editTextPassword = findViewById(R.id.editTextPassword)
        auth = Firebase.auth
        buttonLogin.setOnClickListener{
          // AutenticarUsuario(editTextUsuario.text.toString(),editTextPassword.text.toString())
        }

        buttonRegistroLogin.setOnClickListener {
            var intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
        }
    }


    fun AutenticarUsuario(email:String, password:String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    var intent = Intent(this,PrincipalActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(baseContext, task.exception!!.message,
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}