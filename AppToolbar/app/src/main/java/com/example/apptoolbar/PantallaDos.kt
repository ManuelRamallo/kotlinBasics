package com.example.apptoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar

class PantallaDos : AppCompatActivity() {

    var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dos)

        toolbar = findViewById(R.id.toolbar)
        toolbar?.title = "Pantalla Dos"
        setSupportActionBar(toolbar)

        var actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_pantalla_dos, menu)
        return super.onCreateOptionsMenu(menu)
    }
}