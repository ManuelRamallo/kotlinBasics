package com.example.appciclovidaynavegacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ActividadB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_b)

        val mensaje = intent.getStringExtra("MENSAJE")
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}