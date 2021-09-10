package com.cerr.fastclean

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageButton

class PrincipalActivity : AppCompatActivity() {
    lateinit var ImageButtonCasa: ImageButton
    lateinit var ImageButtonEdificio: ImageButton
    lateinit var ImageButtonOficina: ImageButton
    lateinit var ImageButtonEventos: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        ImageButtonCasa = findViewById(R.id.imageButtonCasa)
        ImageButtonEdificio = findViewById(R.id.imageButtonEdificio)
        ImageButtonOficina = findViewById(R.id.imageButtonOficina)
        ImageButtonEventos = findViewById(R.id.imageButtonEventos)
        ImageButtonCasa.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
        ImageButtonOficina.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
        ImageButtonEventos.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
        ImageButtonEdificio.setOnClickListener{
            val intencion = Intent(this, ElegirActivity::class.java)
            startActivity(intencion)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal,menu)
        return super.onCreateOptionsMenu(menu)
    }

}