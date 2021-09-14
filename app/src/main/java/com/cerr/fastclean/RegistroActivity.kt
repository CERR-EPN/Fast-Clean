package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity() {
    lateinit var buttonRegistro: Button
    lateinit var buttonIngreso: Button
    lateinit var editTextNombreUsuario:EditText
    lateinit var editTextApellidoUsuario:EditText
    lateinit var editTextCorreoUsuario: EditText
    lateinit var editTextContraseñaUsuario:EditText
    lateinit var editTextRepetirContraseña: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //inicializcion de botones
        buttonRegistro = findViewById(R.id.buttonRegistro)
        buttonIngreso = findViewById(R.id.buttonIngreso)
        //inicialización de EditText
        editTextNombreUsuario = findViewById(R.id.EditTextNombreUsuario)
        editTextApellidoUsuario = findViewById(R.id.EditTextApellidoUsuario)
        editTextCorreoUsuario = findViewById(R.id.EditTextCorreoUsuario)
        editTextContraseñaUsuario = findViewById(R.id.EditTextContraseña)
        editTextRepetirContraseña = findViewById(R.id.EditTextRepetirContraseña)
        //funcionalidad
        buttonRegistro.setOnClickListener{
            validarUsuario()
        // val intencion = Intent(this, PrincipalActivity::class.java)
            //startActivity(intencion)
        }

        buttonIngreso.setOnClickListener{
            val intencion = Intent(this, LoginActivity::class.java)
            startActivity(intencion)
        }
    }

    fun validarUsuario ():Boolean{
        val nombre = editTextNombreUsuario.text.toString()
        val apellido = editTextApellidoUsuario.text.toString()
        val correo = editTextCorreoUsuario.text.toString()
        val contrasena = editTextContraseñaUsuario.text.toString()
        val repetirContrasena = editTextRepetirContraseña.text.toString()

        if(nombre.isEmpty()){
            editTextNombreUsuario.setError("El nombre es obligatorio",null)
            editTextNombreUsuario.requestFocus()
            return false
        }
        if(!validarLetras(nombre)){
            editTextNombreUsuario.setError("Solo se aceptan letras",null)
            editTextNombreUsuario.requestFocus()
            return false
        }
        if(apellido.isEmpty()){
            editTextApellidoUsuario.setError("El apellido es obligatorio",null)
            editTextApellidoUsuario.requestFocus()
            return false
        }
        if(!validarLetras(apellido)){
            editTextApellidoUsuario.setError("Solo se aceptan letras",null)
            editTextApellidoUsuario.requestFocus()
            return false
        }
        if(correo.isEmpty()){
            editTextCorreoUsuario.setError("El correo es obligatorio",null)
            editTextCorreoUsuario.requestFocus()
            return false
        }
        if(!validarEmail(correo)){
            editTextCorreoUsuario.setError("El formato del correo no es correcto",null)
            editTextCorreoUsuario.requestFocus()
            return false
        }
        if(contrasena.isEmpty()){
            editTextContraseñaUsuario.setError("La contraseña es obligatoria",null)
            editTextContraseñaUsuario.requestFocus()
            return false
        }
        if(repetirContrasena.isEmpty()){
            editTextRepetirContraseña.setError("El campo es obligatorio",null)
            editTextRepetirContraseña.requestFocus()
            return false
        }
        if(!contrasena.equals(repetirContrasena)){
            editTextRepetirContraseña.setError("Las contraseñas no coinciden",null)
            editTextRepetirContraseña.requestFocus()
            return false
        }
        return true
    }
    private fun validarEmail(email: String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
    fun validarLetras(txt: String?): Boolean {
        val regx = "[a-zA-Z]+\\.?"
        val pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE)
        return pattern.matcher(txt).matches()
    }
}