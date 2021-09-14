package com.cerr.fastclean

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    lateinit var buttonLogin: Button
    lateinit var buttonRegistroLogin: Button
    lateinit var checkBoxRecordarme: CheckBox
    lateinit var editTextUsuario: EditText
    lateinit var editTextPassword: EditText
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //variable para guardar las preferencias
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        //inicialización de variables
        buttonLogin = findViewById(R.id.buttonLogin)
        buttonRegistroLogin = findViewById(R.id.buttonRegistroLogin)
        editTextUsuario = findViewById(R.id.editTextUsuario)
        editTextPassword = findViewById(R.id.editTextPassword)
        checkBoxRecordarme = findViewById(R.id.checkBoxRecordarme)
        auth = Firebase.auth
        editTextUsuario.setText ( sharedPref.getString(LOGIN_KEY,"") )
        editTextPassword.setText ( sharedPref.getString(PASSWORD_KEY,"") )
        checkBoxRecordarme.isChecked =ActivarRecuerdame()
        //verificar si el usuario ya ingresó en el sistema
        val currentUser = auth.currentUser
        if(currentUser != null)
        {
            var intent = Intent(this,PrincipalActivity::class.java)
            intent.putExtra(EXTRA_LOGIN,auth.currentUser!!.email)
            startActivity(intent)
        }

        buttonLogin.setOnClickListener{
            if(!ValidarDatosRequeridos())
            return@setOnClickListener
            if(checkBoxRecordarme.isChecked()){
                val editor = sharedPref.edit()
                editor.putString(LOGIN_KEY,editTextUsuario.text.toString())
                editor.putString(PASSWORD_KEY,editTextPassword.text.toString())
                editor.commit()
            }
            else{
                val editor = sharedPref.edit()
                editor.putString(LOGIN_KEY,"")
                editor.putString(PASSWORD_KEY,"")
                editor.commit()
            }
             AutenticarUsuario(editTextUsuario.text.toString(),editTextPassword.text.toString())
        }
        buttonRegistroLogin.setOnClickListener {
            var intent = Intent(this,RegistroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun ActivarRecuerdame():Boolean{
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        if(sharedPref.getString(LOGIN_KEY,"") != null&& sharedPref.getString(PASSWORD_KEY,"")!=null) {
            return true
        }
        return false
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

    private fun ValidarDatosRequeridos():Boolean{
        val email = editTextUsuario.text.toString()
        val clave = editTextPassword.text.toString()
        if (email.isEmpty()) {
            editTextUsuario.setError("El email es obligatorio")
            editTextUsuario.requestFocus()
            return false
        }
        if(validarEmail(email)==false){
            editTextUsuario.setError("No es un email válido")
            editTextUsuario.requestFocus()
            return false
        }

        if (clave.isEmpty()) {
            editTextPassword.setError("La clave es obligatoria")
            editTextPassword.requestFocus()
            return false
        }
        if (clave.length < MIN_PASSWORD_LENGTH) {
            editTextPassword.setError("La clave debe tener al menos 8 caracteres")
            editTextPassword.requestFocus()
            return false
        }
        return true
    }

    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}