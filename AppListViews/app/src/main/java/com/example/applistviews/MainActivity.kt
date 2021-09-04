package com.example.applistviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.applistviews.clases.AdaptadorCustom
import com.example.applistviews.clases.Fruta

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var frutas:ArrayList<Fruta> = ArrayList()

        frutas.add(Fruta("Manzana", R.drawable.ic_launcher_foreground))
        frutas.add(Fruta("Platano", R.drawable.ic_launcher_foreground))
        frutas.add(Fruta("Melocotón", R.drawable.ic_launcher_foreground))
        frutas.add(Fruta("Sandía", R.drawable.ic_launcher_foreground))

        val lista = findViewById<ListView>(R.id.lista)


        //val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1, frutas)
        val adaptador = AdaptadorCustom(this, frutas)
        lista.adapter = adaptador

        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_SHORT).show()
        }



    }
}