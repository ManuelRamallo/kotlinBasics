package com.example.app_1_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {

    val TAG = "ciudad"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val buttonEspana = findViewById<Button>(R.id.buttonEspana)
        val buttonPortugal = findViewById<Button>(R.id.buttonPortugal)

        buttonEspana.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "España")
            startActivity(intent)
        })

        buttonPortugal.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "Portugal")
            startActivity(intent)
        })

    }
}