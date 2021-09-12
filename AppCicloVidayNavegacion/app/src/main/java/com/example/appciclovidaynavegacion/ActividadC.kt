package com.example.appciclovidaynavegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActividadC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_c)

        val mensaje = intent.getStringExtra("MENSAJE")
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        val boton = findViewById<Button>(R.id.button)

        boton.setOnClickListener {
            var intent = Intent(this, ActividadB::class.java)
            startActivity(intent)
        }
    }
}