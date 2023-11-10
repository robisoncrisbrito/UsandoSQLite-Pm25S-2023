package com.example.usandosqlite_pm25s_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ListarActivity : AppCompatActivity() {

    private lateinit var lvPrincipal : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        lvPrincipal = findViewById( R.id.lvPrincipal )

        val registros = listOf<String> ( "Brasil", "Argentina", "Paraguai", "Uruguai" )

        val adapter = ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1, registros )
        lvPrincipal.adapter = adapter

    }
}