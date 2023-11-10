package com.example.usandosqlite_pm25s_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import com.example.usandosqlite_pm25s_2023.database.DatabaseHandler
import com.example.usandosqlite_pm25s_2023.entity.Pessoa

class ListarActivity : AppCompatActivity() {

    private lateinit var lvPrincipal : ListView

    private lateinit var banco : DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        banco = DatabaseHandler( this )

        lvPrincipal = findViewById( R.id.lvPrincipal )

        val cursor = banco.listCursor()

        val adapter = SimpleCursorAdapter(
            this,
            R.layout.elemento_lista,
            cursor,
            arrayOf( "nome", "telefone" ),
            intArrayOf( R.id.tvNomeElementoLista, R.id.tvTelefoneElementoLista ),
            0
        )

        lvPrincipal.adapter = adapter

    }

}