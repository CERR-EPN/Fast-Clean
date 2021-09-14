package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton

class PrincipalActivity : AppCompatActivity() {
    lateinit var ButtonCasa: Button
    lateinit var ButtonEdificio: Button
    lateinit var ButtonOficina: Button
    lateinit var ButtonEventos: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        ButtonCasa = findViewById(R.id.buttonCasa)
        ButtonEdificio = findViewById(R.id.buttonEdificio)
        ButtonOficina = findViewById(R.id.buttonOficina)
        ButtonEventos = findViewById(R.id.buttonEventos)
        ButtonCasa.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
        ButtonOficina.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
        ButtonEventos.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
        ButtonEdificio.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_principal,menu)
        this.setTitle("Categorias")
        return super.onCreateOptionsMenu(menu)
    }



}