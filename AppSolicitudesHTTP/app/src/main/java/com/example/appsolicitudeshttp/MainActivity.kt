package com.example.appsolicitudeshttp

import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appsolicitudeshttp.classes.Network
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btValidarRed = findViewById<Button>(R.id.btValidarRed)
        val btSolicitudHttp = findViewById<Button>(R.id.btSolicitudHttp)


        btValidarRed.setOnClickListener {
            // Código para validar red
            if(Network.hayRed(this)) {
                Toast.makeText(this, "SI HAY RED", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "NO HAY CONEXION A INTERNET", Toast.LENGTH_SHORT).show()
            }
        }

        btSolicitudHttp.setOnClickListener {
            if(Network.hayRed(this)) {
                Log.d("RED", "onCreate: " + descargarDatos("http://www.google.com"))

            } else {
                Toast.makeText(this, "NO HAY CONEXION A INTERNET", Toast.LENGTH_SHORT).show()
            }
        }


    }

    @Throws(IOException::class)
    private fun descargarDatos(url:String):String {

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        var inputStream:InputStream? = null

        try {
            val url = URL(url)
            val con = url.openConnection() as HttpURLConnection
            con.requestMethod = "GET"
            con.connect()

            inputStream = con.inputStream
            return inputStream.bufferedReader().use {
                it.readText()
            }
        } finally {
            if(inputStream != null) {
                inputStream.close()
            }
        }

    }
}