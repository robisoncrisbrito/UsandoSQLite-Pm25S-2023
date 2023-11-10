package com.example.usandosqlite_pm25s_2023

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
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

        val registros = recuperarArrayString( banco.list() )

        val adapter = ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1, registros )
        lvPrincipal.adapter = adapter

    }

    fun recuperarArrayString( registros : MutableList<Pessoa> ) : MutableList<String> {

        val listaNomes = mutableListOf<String>()

        for ( pessoa in registros ) {
            listaNomes.add( pessoa.nome )
        }

        return listaNomes

    }
}