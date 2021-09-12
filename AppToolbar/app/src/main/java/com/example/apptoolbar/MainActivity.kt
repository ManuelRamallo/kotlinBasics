package com.example.apptoolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)

        val buttonIr = findViewById<Button>(R.id.buttonIr)
        buttonIr?.setOnClickListener {
            val intent = Intent(this, PantallaDos::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.iv_fav -> {
                Toast.makeText(this, "Elemento añadido a favorito", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.iv_desfav -> {
                Toast.makeText(this, "Elemento quitado de favoritos", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> {
                return super.onOptionsItemSelected(item)
            }
        }

    }
}