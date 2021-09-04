package com.example.app_1_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.app_1_kotlin.clases.Ciudad

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvStatus:TextView? = null
    var tvGrados:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ciudadExtras = intent.getStringExtra("ciudad")

        tvCiudad = findViewById(R.id.tvCiudad)
        tvStatus = findViewById(R.id.tvStatus)
        tvGrados = findViewById(R.id.tvGrados)


        val ciudadEsp = Ciudad("España", 15, "Soleado")
        val ciudadPort = Ciudad("Portugal", 20, "Nublado")

        if(ciudadExtras == "España") {
            tvCiudad?.text = ciudadEsp.nombre
            tvGrados?.text = ciudadEsp.grado.toString() + "º"
            tvStatus?.text = ciudadEsp.status
        } else if(ciudadExtras == "Portugal") {
            tvCiudad?.text = ciudadPort.nombre
            tvGrados?.text = ciudadPort.grado.toString() + "º"
            tvStatus?.text = ciudadPort.status
        } else {}

    }
}