package com.cerr.fastclean

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
            if(validarUsuario()){
                crearUsuario(editTextNombreUsuario.text.toString(),editTextApellidoUsuario.text.toString(),editTextCorreoUsuario.text.toString(),editTextContraseñaUsuario.text.toString())
            }
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
        if(contrasena.length<8){
            editTextContraseñaUsuario.setError("La contraseña debe tener al menos 8 caracteres",null)
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
    fun crearUsuario(nombre: String,apellido: String,correo:String,contrasena:String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(correo,contrasena).addOnCompleteListener() {
            if (it.isSuccessful) {
                ingresarNuevoUsuario(procesarNuevoUsuario(nombre,apellido,correo))
                val intent = Intent(this, PrincipalActivity::class.java)
                startActivity(intent)
            } else {
                alerta()
            }
        }
    }
    private fun alerta(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("El correo ya se encuentra ocupado")
        builder.setMessage("No se pudo registrar el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    fun procesarNuevoUsuario(nombre:String,apellido:String,correo: String):Usuario{
        val nombre1=nombre.uppercase()
        val apellido1=apellido.uppercase()
        val usuario = Usuario(nombre1,apellido1,correo)
    return usuario
    }
    fun ingresarNuevoUsuario(usuario:Usuario){
        val db = Firebase.firestore
        db.collection("usuarios")
            .add(usuario)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(this,"Usuario ingresado exitosamente", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(this,"Error al ingresar un nuevo usuario:-> {$e.message}", Toast.LENGTH_LONG).show()
            }
    }


}