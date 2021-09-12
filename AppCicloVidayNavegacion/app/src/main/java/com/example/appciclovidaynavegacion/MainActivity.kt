package com.example.appciclovidaynavegacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var nombre = "Marcos"
    val TAG = "nombre"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btActividadB = findViewById<Button>(R.id.btActividadB)
        val btActividadC = findViewById<Button>(R.id.btActividadC)

        /*boton.setOnClickListener {
            nombre = "Sergio"
            Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        }*/

        btActividadB.setOnClickListener {
            var intent = Intent(this, ActividadB::class.java)
            intent.putExtra("MENSAJE", "HACIA ACTIVIDAD B")
            startActivity(intent)
        }

        btActividadC.setOnClickListener {
            var intent = Intent(this, ActividadC::class.java)
            intent.putExtra("MENSAJE", "HACIA ACTIVIDAD C")
            startActivity(intent)
        }





    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TAG, nombre)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        nombre = savedInstanceState.getString(TAG).toString()
        Log.d("SAVE", "onRestoreInstanceState: $nombre")
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("SAVE", "onPaause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SAVE", "onStop")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SAVE", "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SAVE", "onDestroy")
    }
}